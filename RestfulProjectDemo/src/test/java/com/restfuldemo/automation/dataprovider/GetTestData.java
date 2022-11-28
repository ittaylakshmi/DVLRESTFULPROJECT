package com.restfuldemo.automation.dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public  class GetTestData {
	public static Object[][] getTestData(String filename,String sheetname) throws Exception {
		
		File file = new File(filename);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(inputstream);
		Sheet sheet = workbook.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		
		int rowInd=0;
		int colInd=0;		
		for(rowInd=sheet.getFirstRowNum();rowInd<=sheet.getLastRowNum();rowInd++)
		{
			System.out.println("entered in for");
			for(colInd=sheet.getRow(rowInd).getFirstCellNum(); colInd<sheet.getRow(rowInd).getLastCellNum();colInd++) 
			{
			System.out.println("entered in forloop");
			data[rowInd][colInd]=sheet.getRow(rowInd).getCell(colInd).toString();
			}			
		}
		workbook.close();
		return data;		 
		
		
	}

}
