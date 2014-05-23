package com.tibco.as.io.excel2as;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import com.tibco.as.io.TransferException;
import com.tibco.as.io.file.excel.ExcelImport;
import com.tibco.as.io.file.excel.ExcelImporter;
import com.tibco.as.space.ASException;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.Metaspace;

public class TestCommandExportExcel extends TestBase {

	@Test
	public void testExport() throws ASException, IOException, ParseException,
			TransferException, InvalidFormatException {
		File dir = getDir();
		File file = new File(dir, "jazzfunk.xlsx");
		TestUtils.copy("jazzfunk.xlsx", file);
		Metaspace metaspace = getMetaspace();
		ExcelImporter importer = new ExcelImporter(metaspace, file);
		ExcelImport config = new ExcelImport();
		config.setHeader(true);
		config.setDistributionRole(DistributionRole.SEEDER);
		config.setKeepSpaceOpen(true);
		importer.setDefaultTransfer(config);
		importer.execute();
		File exportFile = new File(dir, "export.xlsx");
		String[] args = { "-discovery", "tcp", "export", "-file",
				exportFile.getPath() };
		new Excel2AS().execute(args);
		Workbook workbook = WorkbookFactory.create(exportFile);
		Assert.assertEquals(2, workbook.getNumberOfSheets());
		Sheet artist = workbook.getSheet("artist");
		Assert.assertEquals(5, artist.getLastRowNum());
		Row header = artist.getRow(0);
		Assert.assertEquals("id[LONG key]", header.getCell(0)
				.getStringCellValue());
		Assert.assertEquals("name[STRING]", header.getCell(1)
				.getStringCellValue());
		Assert.assertEquals("birthdate[DATETIME]", header.getCell(2)
				.getStringCellValue());
	}
}
