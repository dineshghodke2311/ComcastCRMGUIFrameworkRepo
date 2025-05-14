package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtility {

	
public String getDatafromExelfile( String sheetname, int rownum,int cellnum) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	wb.close();
	return data;
}



public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
    int rowcount = wb.getSheet(sheetname).getLastRowNum();
	return rowcount;


}

public void setDataintoExelfile( String sheetname, int rownum,int cellnum) throws IOException
{
	FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
    wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
	wb.close();
	
	FileOutputStream fos = new FileOutputStream("./Data/Test_Data.xlsx");
	wb.write(fos);
	wb.close();
	
}





}
