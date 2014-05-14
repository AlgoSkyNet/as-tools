package com.tibco.as.io.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.tibco.as.io.file.text.delimited.DelimitedExport;
import com.tibco.as.io.file.text.delimited.DelimitedExporter;
import com.tibco.as.space.ASException;
import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class TestExport extends TestBase {

	private Space space;
	private final static String SPACE_NAME = "space1";
	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			"MM/dd/yy");
	static {
		DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	@Before
	public void setup() throws IOException, ASException, ParseException {
		SpaceDef spaceDef = SpaceDef.create(SPACE_NAME, 0,
				Arrays.asList(
						FieldDef.create("Field1", FieldType.LONG),
						FieldDef.create("Field2", FieldType.DATETIME)
								.setNullable(true),
						FieldDef.create("Field3", FieldType.CHAR).setNullable(
								true),
						FieldDef.create("Field4", FieldType.BOOLEAN)
								.setNullable(true)));
		spaceDef.setKey("Field1");
		Metaspace metaspace = getMetaspace();
		metaspace.defineSpace(spaceDef);
		space = metaspace.getSpace(SPACE_NAME, DistributionRole.SEEDER);
		for (long index = 1; index <= 18; index++) {
			Tuple tuple = Tuple.create();
			tuple.putLong("Field1", index);
			Date date = DATE_FORMAT.parse(MessageFormat.format("1/{0}/14",
					index));
			tuple.putDateTime("Field2", DateTime.create(date.getTime()));
			tuple.putChar("Field3", (char) index);
			tuple.putBoolean("Field4", index % 2 == 0);
			space.put(tuple);
		}
	}

	@Test
	public void testCSV() throws Exception {
		DelimitedExporter exporter = new DelimitedExporter(getMetaspace(),
				getDir());
		DelimitedExport export = new DelimitedExport();
		export.setSpaceName(SPACE_NAME);
		export.setQuoteChar(CSVWriter.DEFAULT_QUOTE_CHARACTER);
		export.setEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER);
		export.setHeader(true);
		exporter.addTransfer(export);
		exporter.execute();
		File file = new File(getDir(), SPACE_NAME + ".csv");
		Assert.assertTrue(file.exists());
		CSVReader reader = new CSVReader(new FileReader(file));
		try {
			List<String[]> lines = reader.readAll();
			Assert.assertEquals(19, lines.size());
		} finally {
			reader.close();
		}
	}

}
