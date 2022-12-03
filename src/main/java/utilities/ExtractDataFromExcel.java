package utilities;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;



public class ExtractDataFromExcel {
	
	@SuppressWarnings("deprecation")
	public static String[][] getTestData(String fileName, String sheet_name) throws IOException {
        	
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
            XSSFSheet sheet = workbook.getSheet(sheet_name);
            int row_count = sheet.getPhysicalNumberOfRows();
            int col_count = sheet.getRow(0).getLastCellNum();
            
            String dataTable[][] = new String[row_count - 1][col_count];
            
            
            for (int i = 1; i < row_count; i++) {
            	Row row =  sheet.getRow(i);
                for (int j = 0; j < col_count; j++) {
                	Cell cell = row.getCell(j);
                	if(cell == null) 
                		dataTable[i - 1][j]	= " " ;
                	else {
                		
                	cell.setCellType(CellType.STRING);
                    dataTable[i - 1][j] = cell.getStringCellValue();
                	}
                }
            }
            
            workbook.close();
            return dataTable;
       }

}
