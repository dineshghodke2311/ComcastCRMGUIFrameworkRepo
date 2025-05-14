import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Working_with_ExelFile {

	@Test
	public void demo() throws EncryptedDocumentException, IOException
	{
		
		// mention the path of testdata file 
		
		String path= "./DWS_TestData/TestData.xlsx";
		FileInputStream fis = new FileInputStream(new File(path));
		
		
		// create the workbook where test data store
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		// access the sheet where test data is present 
		
		Sheet sheet = workbook.getSheet("Names");
		
		// print the values of cells
		
	     //String value = sheet.getRow(1).getCell(0).toString();
	    //System.out.println(value);
		
		// get all row and columns
		
		int row_count = sheet.getPhysicalNumberOfRows();
		
	    int coloum_count = sheet.getRow(0).getPhysicalNumberOfCells();
		
	    //System.out.println(row_count);
	    //System.out.println(coloum_count);
		
		//print all rows and coloums values
		
	    
	    for(int i =0 ;i<=row_count-1;i++)
	    {
	    	for(int j=0;j<=coloum_count-1;j++)
	    	{
	    		
	    		System.out.print(sheet.getRow(i).getCell(j).toString()+"  ");
	    	}
	    	
	    	System.out.println();
	    }
		
		
		
		
		
		
	}
}
