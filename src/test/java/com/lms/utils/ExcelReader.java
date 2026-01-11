package com.lms.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    // Reads the entire sheet into a List of Maps
    public static List<Map<String, String>> getData(String filePath, String sheetName) {
        List<Map<String, String>> excelData = new ArrayList<>();

        try (InputStream is = ExcelReader.class.getClassLoader().getResourceAsStream(filePath);
             Workbook workbook = new XSSFWorkbook(is)) {
            if (is == null) {
                throw new RuntimeException("Excel file not found: " + filePath);
            }
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int colCount = headerRow.getLastCellNum();
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int r = 1; r < rowCount; r++) {
                Row currentRow = sheet.getRow(r);
                Map<String, String> rowData = new HashMap<>();

                for (int c = 0; c < colCount; c++) {
                    String columnName = headerRow.getCell(c).getStringCellValue();
                    Cell cell = currentRow.getCell(c);
                    DataFormatter formatter = new DataFormatter();
                    String cellValue = (cell == null) ? "" : formatter.formatCellValue(cell).trim();
                    rowData.put(columnName, cellValue);
                }
                excelData.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }
    // Fetch single row by TestCaseID from a sheet
    public static Map<String, String> getRowByTestCaseId(String filePath, String sheetName, String testCaseId) {
        List<Map<String, String>> allData = getData(filePath, sheetName);
        for (Map<String, String> row : allData) {
            if (row.get("TestCaseID").equalsIgnoreCase(testCaseId)) {
                return row;
            }
        }
        return new HashMap<String, String>();
    }

	
}
