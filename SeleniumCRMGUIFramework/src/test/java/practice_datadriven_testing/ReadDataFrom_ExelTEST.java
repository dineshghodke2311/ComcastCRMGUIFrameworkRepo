package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFrom_ExelTEST {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// step 1: get the exel path location ane java object of the physical exel file 
		
		FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
		// step 2 : open workbook in read mode 
		
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3 : get the control of the sheet 
		
		Sheet sh = wb.getSheet("org");
		
		// step 4 : get the control of the row 
		
		 Row row = sh.getRow(1);
		 
		// step 5 : get the cell control of cell and read the string data
		 
		 String cell_value = row.getCell(2).toString();
		 System.out.println(cell_value);
		
		// step 6 : close the workbook
		 
		 wb.close();
		

	}

}
