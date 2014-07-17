package com.tibco.as.io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tibco.as.convert.Attribute;
import com.tibco.as.io.EventManager;
import com.tibco.as.io.Field;
import com.tibco.as.io.IEvent;
import com.tibco.as.io.IEvent.Severity;
import com.tibco.as.io.IEventListener;
import com.tibco.as.io.file.text.TextFileImport;
import com.tibco.as.io.file.text.delimited.DelimitedImport;
import com.tibco.as.io.file.text.delimited.DelimitedImporter;
import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.Tuple;

public class TestImport extends TestBase {

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
	public void testCSVNoHeader() throws Exception {
		DelimitedImport import1 = createDelimitedImport("space1-noheader.csv");
		import1.setSpaceName("space2");
		configure(import1);
		testDelimitedImporter(import1, import1.getSpaceName());
	}

	private void configure(TextFileImport config) {
		config.setFields(new Field("Field1", FieldType.LONG, true), new Field(
				"Field2", FieldType.DATETIME, false, true), new Field("Field3",
				FieldType.CHAR, false, true), new Field("Field4",
				FieldType.BOOLEAN, false, true));
	}

	@Test
	public void testCSVWithHeader() throws Exception {
		DelimitedImport import1 = createDelimitedImport("space1.csv");
		import1.setHeader(true);
		testDelimitedImporter(import1, "space1");
	}

	@Test
	public void testCSVWithHeaderSkip() throws Exception {
		DelimitedImport import1 = createDelimitedImport("space1-skip.csv");
		import1.setSpaceName("space1");
		import1.setHeader(true);
		File dir = getDir();
		copy(import1.getFilename(), dir);
		Metaspace metaspace = getMetaspace();
		DelimitedImporter importer = new DelimitedImporter(metaspace, dir);
		import1.setKeepSpaceOpen(true);
		import1.getAttributes()
				.put(Attribute.FORMAT_DATE, "MM/dd/yy", "Field2");
		importer.addTransfer(import1);
		importer.execute();
		Space space1 = metaspace.getSpace("space1");
		Assert.assertNull(space1.getSpaceDef().getFieldDef("Field3"));
		Assert.assertEquals(17, space1.size());
		Tuple tuple18 = Tuple.create();
		tuple18.putLong("Field1", 18);
		tuple18 = space1.get(tuple18);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date18 = dateFormat.parse("1/18/14");
		Assert.assertEquals(DateTime.create(date18.getTime()),
				tuple18.getDateTime("Field2"));
		Assert.assertEquals(null, tuple18.getBoolean("Field4"));
	}

	@Test
	public void testCSVWithHeaderAndFields() throws Exception {
		DelimitedImport import1 = createDelimitedImport("space1.csv");
		import1.setSpaceName("space1");
		import1.setHeader(true);
		import1.setFields(new Field("Field1", FieldType.LONG, true), new Field(
				"Field2", FieldType.DATETIME, false, true), new Field(),
				new Field("Field4", FieldType.BOOLEAN, false, true));
		File dir = getDir();
		copy(import1.getFilename(), dir);
		Metaspace metaspace = getMetaspace();
		DelimitedImporter importer = new DelimitedImporter(metaspace, dir);
		import1.setKeepSpaceOpen(true);
		import1.getAttributes()
				.put(Attribute.FORMAT_DATE, "MM/dd/yy", "Field2");
		importer.addTransfer(import1);
		importer.execute();
		Space space1 = metaspace.getSpace("space1");
		Assert.assertNull(space1.getSpaceDef().getFieldDef("Field3"));
		Assert.assertEquals(17, space1.size());
		Tuple tuple18 = Tuple.create();
		tuple18.putLong("Field1", 18);
		tuple18 = space1.get(tuple18);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date18 = dateFormat.parse("1/18/14");
		Assert.assertEquals(DateTime.create(date18.getTime()),
				tuple18.getDateTime("Field2"));
		Assert.assertEquals(null, tuple18.getBoolean("Field4"));
	}

	@Test
	public void testCSVNoHeaderSkip() throws Exception {
		DelimitedImport import1 = createDelimitedImport("space1-noheader.csv");
		import1.setSpaceName("space2");
		import1.setFields(new Field("Field1", FieldType.LONG, true), new Field(
				"Field2", FieldType.DATETIME, false, true), new Field(),
				new Field("Field4", FieldType.BOOLEAN, false, true));
		File dir = getDir();
		copy(import1.getFilename(), dir);
		Metaspace metaspace = getMetaspace();
		DelimitedImporter importer = new DelimitedImporter(metaspace, dir);
		import1.setKeepSpaceOpen(true);
		import1.getAttributes()
				.put(Attribute.FORMAT_DATE, "MM/dd/yy", "Field2");
		importer.addTransfer(import1);
		importer.execute();
		Space space1 = metaspace.getSpace(import1.getSpaceName());
		Assert.assertEquals(17, space1.size());
		Assert.assertNull(space1.getSpaceDef().getFieldDef("Field3"));
		Tuple tuple18 = Tuple.create();
		tuple18.putLong("Field1", 18);
		tuple18 = space1.get(tuple18);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date18 = dateFormat.parse("1/18/14");
		Assert.assertEquals(DateTime.create(date18.getTime()),
				tuple18.getDateTime("Field2"));
		Assert.assertEquals(null, tuple18.getBoolean("Field4"));
	}

	private DelimitedImport createDelimitedImport(String filename) {
		DelimitedImport import1 = new DelimitedImport();
		import1.setFilename(filename);
		import1.setDistributionRole(DistributionRole.SEEDER);
		import1.setKeepSpaceOpen(true);
		return import1;
	}

	private void testDelimitedImporter(DelimitedImport import1, String spaceName)
			throws Exception {
		File dir = getDir();
		copy(import1.getFilename(), dir);
		Metaspace metaspace = getMetaspace();
		DelimitedImporter importer = new DelimitedImporter(metaspace, dir);
		import1.setKeepSpaceOpen(true);
		import1.getAttributes()
				.put(Attribute.FORMAT_DATE, "MM/dd/yy", "Field2");
		importer.addTransfer(import1);
		importer.execute();
		Space space1 = metaspace.getSpace(spaceName);
		Assert.assertEquals(17, space1.size());
		Tuple tuple18 = Tuple.create();
		tuple18.putLong("Field1", 18);
		tuple18 = space1.get(tuple18);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date18 = dateFormat.parse("1/18/14");
		Assert.assertEquals(DateTime.create(date18.getTime()),
				tuple18.getDateTime("Field2"));
		Assert.assertEquals(null, tuple18.getBoolean("Field4"));
		Assert.assertEquals('q', tuple18.getChar("Field3").charValue());
	}

}
