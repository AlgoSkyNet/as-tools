package com.tibco.as.io.excel;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tibco.as.io.file.excel.ExcelExport;
import com.tibco.as.io.file.excel.ExcelExporter;
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

public class TestExport extends TestBase {

	private static File dir;
	private Metaspace metaspace;
	private Space space;
	private final static String SPACE_NAME = "space1";
	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			"MM/dd/yy");
	static {
		DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	@BeforeClass
	public static void setupClass() throws IOException {
		dir = createTempDirectory();
	}

	@Before
	public void setup() throws IOException, ASException, ParseException {
		MemberDef memberDef = MemberDef.create(null, "tcp", null);
		memberDef.setConnectTimeout(10000);
		metaspace = Metaspace.connect(null, memberDef);
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
	public void testExcel() throws Exception {
		File file = new File(dir, "ms.xls");
		ExcelExporter exporter = new ExcelExporter(metaspace, file);
		ExcelExport export = new ExcelExport();
		export.setHeader(true);
		export.setSpaceName(SPACE_NAME);
		exporter.addTransfer(export);
		exporter.execute();
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		Assert.assertEquals(SPACE_NAME, sheet.getSheetName());
		Assert.assertEquals(19, sheet.getPhysicalNumberOfRows());
		Iterator<Row> iterator = sheet.rowIterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			long field1 = Math.round(row.getCell(0).getNumericCellValue());
			if (field1 != 16) {
				Date date = DATE_FORMAT.parse("1/" + field1 + "/14");
				Assert.assertEquals(date, row.getCell(1).getDateCellValue());
			}
		}
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
