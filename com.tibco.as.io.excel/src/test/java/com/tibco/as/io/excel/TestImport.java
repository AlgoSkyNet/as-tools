package com.tibco.as.io.excel;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tibco.as.io.Field;
import com.tibco.as.io.Import;
import com.tibco.as.io.Importer;
import com.tibco.as.io.file.excel.ExcelExport;
import com.tibco.as.io.file.excel.ExcelExporter;
import com.tibco.as.io.file.excel.ExcelImport;
import com.tibco.as.io.file.excel.ExcelImporter;
import com.tibco.as.space.ASException;
import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class TestImport extends TestBase {

	private static File dir;
	private Metaspace metaspace;

	@BeforeClass
	public static void setupClass() throws IOException {
		dir = createTempDirectory();
	}

	@Before
	public void setup() throws IOException, ASException {
		MemberDef memberDef = MemberDef.create(null, "tcp", null);
		memberDef.setConnectTimeout(10000);
		metaspace = Metaspace.connect(null, memberDef);
	}

	private void configure(ExcelImport config) {
		config.setFields(new Field("Field1", FieldType.LONG, true), new Field(
				"Field2", FieldType.DATETIME, false, true), new Field("Field3",
				FieldType.CHAR, false, true), new Field("Field4",
				FieldType.BOOLEAN, false, true));
	}

	@Test
	public void testXLSWithHeader() throws Exception {
		ExcelImport import1 = createExcelImport();
		import1.setHeader(true);
		testExcelImporter("ms.xls", import1);
		Space space1 = metaspace.getSpace("space1");
		Tuple tuple1 = Tuple.create();
		tuple1.putLong("Field1", 1);
		tuple1 = space1.get(tuple1);
		Assert.assertEquals("2", tuple1.getString("Field5"));

	}

	@Test
	public void testXLSXWithHeader() throws Exception {
		ExcelImport import1 = createExcelImport();
		import1.setHeader(true);
		testExcelImporter("ms.xlsx", import1);
	}

	@Test
	public void testXLSNoHeader() throws Exception {
		ExcelImport import1 = createExcelImport();
		configure(import1);
		testExcelImporter("ms-noheader.xls", import1);
	}

	@Test
	public void testXLSXNoHeaderConfigured() throws Exception {
		ExcelImport import1 = createExcelImport();
		configure(import1);
		testExcelImporter("ms-noheader.xlsx", import1);
	}

	@Test
	public void testXLSXHeaderDefault() throws Exception {
		File file = copy("ms.xlsx", dir);
		ExcelImporter importer = new ExcelImporter(metaspace, file);
		ExcelImport defaultConfig = new ExcelImport();
		defaultConfig.setHeader(true);
		defaultConfig.setDistributionRole(DistributionRole.SEEDER);
		defaultConfig.setKeepSpaceOpen(true);
		importer.setDefaultTransfer(defaultConfig);
		importer.execute();
		assertSpace1("space1");
	}

	@Test
	public void testExcel97Multisheet() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String spaceName = "space1";
		SpaceDef spaceDef = SpaceDef.create(spaceName, 0,
				Arrays.asList(
						FieldDef.create("Field1", FieldType.LONG),
						FieldDef.create("Field2", FieldType.DATETIME)
								.setNullable(true),
						FieldDef.create("Field3", FieldType.CHAR).setNullable(
								true),
						FieldDef.create("Field4", FieldType.BOOLEAN)
								.setNullable(true)));
		spaceDef.setKey("Field1");
		metaspace.defineSpace(spaceDef);
		Space space = metaspace.getSpace(spaceName, DistributionRole.SEEDER);
		space.waitForReady(1000);
		int batchSize = 1000;
		long size = 70000;
		List<Tuple> list = new ArrayList<Tuple>(batchSize);
		for (long index = 1; index <= size; index++) {
			Tuple tuple = Tuple.create();
			tuple.putLong("Field1", index);
			Date date = dateFormat.parse(MessageFormat.format("1/{0}/14",
					(index % 25) + 1));
			tuple.putDateTime("Field2", DateTime.create(date.getTime()));
			tuple.putChar("Field3", (char) index);
			tuple.putBoolean("Field4", index % 2 == 0);
			list.add(tuple);
			if (list.size() == batchSize) {
				space.putAll(list);
				list.clear();
			}
		}
		File file = new File(dir, "multisheet.xls");
		ExcelExporter exporter = new ExcelExporter(metaspace, file);
		ExcelExport export = new ExcelExport();
		export.setQueryLimit(-1L);
		export.setSpaceName(spaceName);
		export.setHeader(true);
		exporter.addTransfer(export);
		exporter.execute();
		Assert.assertEquals(size, space.size());
		space.closeAll();
		metaspace.dropSpace(spaceName);
		metaspace.defineSpace(spaceDef);
		space = metaspace.getSpace(spaceName, DistributionRole.SEEDER);
		Assert.assertEquals(0, space.size());
		ExcelImporter importer = new ExcelImporter(metaspace, file);
		ExcelImport config = new ExcelImport();
		config.setHeader(true);
		config.setDistributionRole(DistributionRole.SEEDER);
		importer.setDefaultTransfer(config);
		importer.execute();
		Assert.assertEquals(size, space.size());
	}

	private ExcelImport createExcelImport() {
		ExcelImport import1 = new ExcelImport();
		configureImport(import1);
		return import1;
	}

	private void configureImport(Import config) {
		config.setDistributionRole(DistributionRole.SEEDER);
		config.setKeepSpaceOpen(true);
	}

	private void testExcelImporter(String filename, ExcelImport import1)
			throws Exception {
		File file = copy(filename, dir);
		ExcelImporter importer = new ExcelImporter(metaspace, file);
		testImporter(importer, "space1", import1);
	}

	private <T> void testImporter(Importer<T> importer, String spaceName,
			Import config) throws Exception {
		importer.addTransfer(config);
		importer.execute();
		assertSpace1(spaceName);
	}

	private void assertSpace1(String spaceName) throws ASException,
			ParseException {
		Space space1 = metaspace.getSpace(spaceName);
		Assert.assertEquals(17, space1.size());
		Tuple tuple18 = Tuple.create();
		tuple18.putLong("Field1", 18);
		tuple18 = space1.get(tuple18);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date date18 = dateFormat.parse("1/18/14");
		Assert.assertEquals(DateTime.create(date18.getTime()),
				tuple18.getDateTime("Field2"));
		Assert.assertEquals(null, tuple18.getBoolean("Field4"));
		Assert.assertEquals('q', tuple18.getChar("Field3").charValue());
	}

	@After
	public void teardown() throws ASException {
		metaspace.closeAll();
	}

	@AfterClass
	public static void teardownClass() {
		dir.delete();
	}
}
