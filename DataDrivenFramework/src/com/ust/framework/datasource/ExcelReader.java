package com.ust.framework.datasource;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ust.framework.util.ConfigReader;

public class ExcelReader {
	
	public static Object[][] readExcel() throws Exception{
		boolean isHeading = true;
		Object [][] array = new Object[2][2];
		int currentRowIndex = 0;
		int currentColIndex = 0;
		// Step - 0 
		//String xlsPath = ConfigReader.getExcelPath();
		// Step - 1 Specify the Location of an Excel , From where u want to
		// read the data
		//FileInputStream fi = new FileInputStream("D:\\Selenium-21stBatch\\xls\\UserData.xls");
		//FileInputStream fi = new FileInputStream(xlsPath);
		FileInputStream fi = new FileInputStream(ConfigReader.getExcelPath());
		// Step -2 Read the WorkBook
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		// Step -3 Reading the Sheet from WorkBook
		HSSFSheet sheet =workBook.getSheetAt(0);
		// Step- 4 Reading the Rows From the Sheet
		Iterator<Row> rows= sheet.rowIterator();
		// is there any row
		while(rows.hasNext()){
			Row currentRow = rows.next();  // this will give the current row
			// and then increment to the next row
			if(isHeading){
				isHeading = false;
				continue; // It will skip Rest of the Loop and Increment it to the Next Loop
			}
			// The Number of Cell in the CurrentRow
			Iterator<Cell> cells = currentRow.cellIterator();
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				//System.out.println(currentCell.getCellType());
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
					array[currentRowIndex][currentColIndex] = currentCell.getStringCellValue();
					currentColIndex++;
				}
				else
					if(currentCell.getCellType()==Cell.CELL_TYPE_NUMERIC){
						
						array[currentRowIndex][currentColIndex] = String.valueOf((int)currentCell.getNumericCellValue());
						currentColIndex++;
					}	
				
			}  // Cell Loop Ends Here
			currentColIndex=0; // ReInitalize the Col, so col will be start again from 0
			// for the next row 
			currentRowIndex++; // here increment the row , so it will reach to the next row
		}  // Row Loop Ends Here
		
		// Print Logic
		for(int startRow = 0 ; startRow<2; startRow++){
			for(int startCol = 0 ; startCol<2; startCol++){
				System.out.print(array[startRow][startCol]+"\t");
			}
			System.out.println();
		}
		workBook.close();
		fi.close();
		return array;
	}
	public static void main(String[] args) throws Exception {
		ExcelReader.readExcel();
	}

}
