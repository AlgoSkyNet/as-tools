package com.tibco.as.io.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.h2.Driver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tibco.as.io.EventManager;
import com.tibco.as.io.IEvent;
import com.tibco.as.io.IEvent.Severity;
import com.tibco.as.io.IEventListener;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;

public class TestDatabaseImport extends TestBase {

	private final static String DRIVER = Driver.class.getName();

	private final static String URL = "jdbc:h2:mem:test";

	private static final int SIZE = 1000;

	@BeforeClass
	public static void setupClass() throws IOException {
		EventManager.addListener(new IEventListener() {

			@Override
			public void onEvent(IEvent event) {
				if (event.getSeverity() == Severity.ERROR) {
					event.getException().printStackTrace();
					Assert.fail(event.getMessage());
				}
			}
		});
	}

	@Test
	public void testDatabaseImporter() throws Exception {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL);
		// populate table "TEST"
		Statement stat = conn.createStatement();
		stat.execute("DROP TABLE IF EXISTS OTP");
		stat.execute("DROP TABLE IF EXISTS TEST");
		stat.execute("CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR)");
		PreparedStatement prep = conn
				.prepareStatement("INSERT INTO TEST VALUES(?, 'Test' || SPACE(100))");
		long time = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			long now = System.currentTimeMillis();
			if (now > time + 1000) {
				time = now;
				System.out.println("Inserting " + (100L * i / SIZE) + "%");
			}
			prep.setInt(1, i);
			prep.execute();
		}
		conn.commit();
		prep.close();
		stat.close();
		Metaspace metaspace = getMetaspace();
		Database db = new Database();
		db.setDriver(DRIVER);
		db.setUrl(URL);
		DatabaseImporter importer = new DatabaseImporter(metaspace, db);
		TableImport import1 = new TableImport();
		import1.setDistributionRole(DistributionRole.SEEDER);
		importer.setDefaultTransfer(import1);
		importer.execute();
		Space space1 = metaspace.getSpace("TEST");
		Assert.assertEquals(SIZE, space1.size());
	}

}
