package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_BasedonCondtions_fromExelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String expectedTestId="tc_02";
		String data1="";
		String data2="";
		String data3="";
		FileInputStream fis = new FileInputStream("./Data/Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("org");
		int row_count = sh.getLastRowNum();
		
		for (int i =0 ;i<=row_count;i++)
		{
			String data ="";
			try
			{
				data= sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) 
				{
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();
					
				}
				
			}
			catch(Exception e)
			{}
			 
		}
		 System.out.println(data1);
	     System.out.println(data2);
	     System.out.println(data3);
       wb.close();
	}

}
