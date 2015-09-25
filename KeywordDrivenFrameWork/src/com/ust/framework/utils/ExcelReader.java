package com.ust.framework.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ust.framework.dto.CommandDTO;

public class ExcelReader {
	/*
	 * It Read all the Data From the Excel and Store in ArrayList of CommandDTO
	 */
	public static List<CommandDTO> readExcel() throws Exception{
		int cellCounter = 1;
		CommandDTO commandDTO = null;
		String cellValue = null;
		// Need of ArrayList
		// 1. Dynamic Can be Increase and Can be Decrease during Runtime
		// 2. It Hold/ Store the Object
		ArrayList<CommandDTO> commandList = new ArrayList<>();
		FileInputStream fi = new FileInputStream(ConfigReader.getXLSPath());
		HSSFWorkbook workBook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()){
			Row currentRow = rows.next();
			Iterator<Cell> cells = currentRow.cellIterator();
			commandDTO = new CommandDTO();
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				System.out.println("Cell Type "+currentCell.getCellType());
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){
					
					cellValue  = currentCell.getStringCellValue();
					if(cellCounter==1){
						
						commandDTO.setCommand(cellValue);
					}
					else
					if(cellCounter == 2){
						
						commandDTO.setTarget(cellValue);
					}
					else
						if(cellCounter == 3){
							
							commandDTO.setValue(cellValue);
						}
				
				}
				cellCounter ++;
			}
			cellCounter = 1;
			commandList.add(commandDTO);
		}
		workBook.close();
		fi.close();
		return commandList;
	}

}
