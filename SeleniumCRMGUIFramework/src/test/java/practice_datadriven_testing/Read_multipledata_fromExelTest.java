package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_multipledata_fromExelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Sheet1");
		int row_count = sh.getLastRowNum();
		for(int i=0;i<=row_count;i++)
		{
			Row row = sh.getRow(i);
			Cell col1 = row.getCell(0);
			Cell col2 = row.getCell(1);
			System.out.println(col1 + "-" +col2 );
			
		}
	    
	    wb.close();
	    
	    
	    
	
	}
	
	

}
