package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_DataBackTo_ExelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step 1 : load the data in reading mode
		
		FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		//step 2 : control goes to sheet and get the row 
		 Sheet sh = wb.getSheet("org");
         Row row = sh.getRow(1);
         
       // step 3 : create the cell and metions celltype  
         Cell cel = row.createCell(4);
         cel.setCellType(CellType.STRING);
         cel.setCellValue("Pass");
         
       // step 4 : save the data which is enter 
         FileOutputStream fos = new FileOutputStream("./Data/Test_Data.xlsx");
         wb.write(fos);
         System.out.println("Executed");
        
       // step 5 : close the workbook
         wb.close();
	}

}
