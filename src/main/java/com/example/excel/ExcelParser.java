package com.example.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelParser {

	private static final Logger logger = LoggerFactory.getLogger(ExcelParser.class);

	public static void validate() {
		int rowCount = 0;
		FileInputStream fileInputStream = null;
		Workbook xssfWorkbook = null;

		logger.info("start time : {}", new Date());

		try {
			fileInputStream = new FileInputStream(new File("D:\\tmp\\test.xlsx"));
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			Sheet datatypeSheet = xssfWorkbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					rowCount++;
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						logger.info("{} {}", currentCell.getStringCellValue(), "--str");
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						logger.info("{} {}", currentCell.getNumericCellValue(), "--num");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		logger.info("end time : {}, rowCount : {}", new Date(), rowCount);
	}
}
