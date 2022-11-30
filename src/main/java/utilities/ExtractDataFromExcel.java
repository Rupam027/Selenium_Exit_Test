package utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;



public class ExtractDataFromExcel {
	
	public static Object[][] getTestData(String fileName, String sheet_name) throws IOException {
        	Object[][] data = null;
       
             
            FileInputStream fis = new FileInputStream(fileName);
            
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheet_name);
            
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];
            
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    
                    if(cell == null)
                    	data[i - 1][j] = " ";
                    
                    else if(cell.getCellType() == CellType.STRING)
                    	data[i - 1][j] = cell.getStringCellValue();
                    else if(cell.getCellType() == CellType.NUMERIC)
                        data[i - 1][j] = cell.getNumericCellValue();
                }
            }
            
            workbook.close();
       
        
        
        return data;
    }

}
