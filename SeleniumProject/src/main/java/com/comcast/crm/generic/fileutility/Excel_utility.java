package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
 import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	//get data from excel
	public String getFileFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
    FileInputStream fis =new FileInputStream("./TestData/vtiger_Testscript.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	//get rownum from sheet 
    public int getRowcount(String sheetname) throws Throwable, IOException {
    	FileInputStream fis =new FileInputStream("./TestData/vtiger_Testscript.xlsx");
    	Workbook wb=WorkbookFactory.create(fis);
    	int rowcount=wb.getSheet(sheetname).getLastRowNum();
    	return rowcount;
    	}
    //insert value in cell
    public void setDataIntoExcel(String sheetname,int rownum,int cellnum,String data ) throws EncryptedDocumentException, IOException {
    	FileInputStream fis =new FileInputStream("./TestData/vtiger_Testscript.xlsx");
    	Workbook wb=WorkbookFactory.create(fis);
    	wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data); 
    	
    	FileOutputStream fos=new FileOutputStream("./TestData/vtiger_Testscript.xlsx");
    	wb.write(fos);
    	wb.close();
    }
	
}

