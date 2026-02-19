package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Object[][] getExcelData(String filePath,String sheetName) throws IOException{
	FileInputStream file = new FileInputStream(filePath);
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheet(sheetName);

    int rowCount = sheet.getLastRowNum();
    int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // 

   /* Object[][] data = new Object[rowCount][colCount];

    DataFormatter formatter = new DataFormatter();

    for (int i = 1; i <= rowCount; i++) {

        Row row = sheet.getRow(i);

        for (int j = 0; j < colCount; j++) {

            if (row != null) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = (cell == null) ? "" : formatter.formatCellValue(cell);
            } else {
                data[i - 1][j] = "";
            }
        }
    }*/
    Object[][] data = new Object[rowCount][colCount];
    DataFormatter formatter = new DataFormatter();
    for (int i = 1; i <= rowCount; i++) {
        Row row = sheet.getRow(i);
        for (int j = 0; j < colCount; j++) {
            Cell cell = row.getCell(j);
            data[i-1][j] = (cell == null) ? "" : formatter.formatCellValue(cell);
        }
    }
    workbook.close();
    file.close();
    return data;
	}
}
