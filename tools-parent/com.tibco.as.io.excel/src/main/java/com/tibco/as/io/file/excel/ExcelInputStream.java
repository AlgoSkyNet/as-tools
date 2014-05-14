package com.tibco.as.io.file.excel;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.tibco.as.io.IInputStream;

public class ExcelInputStream implements IInputStream<Row> {

	private ExcelImport config;
	private Workbook workbook;
	private Sheet sheet;
	private String sheetName;
	private int sheetIndex;
	private Iterator<Row> rowIterator;
	private int rownum;
	private int size;

	public ExcelInputStream(ExcelImport config, Workbook workbook) {
		this.config = config;
		this.workbook = workbook;
	}

	@Override
	public void open() throws Exception {
		openSheet();
		if (Boolean.TRUE.equals(config.getHeader())) {
			read();
		}
	}

	public void openSheet() {
		sheet = getSheet();
		this.size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		this.sheetName = sheet.getSheetName();
		this.sheetIndex = 1;
		this.rowIterator = sheet.rowIterator();
		this.rownum = 0;
	}

	public Sheet getSheet() {
		String sheetName = config.getSheetName();
		if (sheetName == null) {
			String spaceName = config.getSpaceName();
			if (spaceName == null) {
				return workbook.getSheetAt(0);
			}
			Sheet sheet = workbook.getSheet(spaceName);
			if (sheet == null) {
				return workbook.getSheetAt(0);
			}
			return sheet;
		}
		return workbook.getSheet(sheetName);
	}

	@Override
	public long size() {
		return size;
	}

	@Override
	public long getPosition() {
		return rownum;
	}

	@Override
	public Row read() {
		if (rowIterator.hasNext()) {
			rownum++;
			return rowIterator.next();
		}
		if (sheet.getWorkbook() instanceof HSSFWorkbook) {
			sheet = sheet.getWorkbook().getSheet(getNextSheetName());
			if (sheet != null) {
				size = sheet.getLastRowNum() - sheet.getFirstRowNum();
				rowIterator = sheet.rowIterator();
				rownum = 0;
				return read();
			}
		}
		return null;
	}

	private String getNextSheetName() {
		return sheetName + "-" + sheetIndex++;
	}

	@Override
	public void close() {
		this.rowIterator = null;
		this.sheet = null;
	}

	@Override
	public boolean isClosed() {
		return sheet == null;
	}

}
