import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DWS_LoginTest {
	
	@DataProvider(name="LoginTestData")
	public Object[][] testdata() throws EncryptedDocumentException, IOException 
	{
		
		String path = "./DWS_TestData/TestData.xlsx";
		FileInputStream fis = new FileInputStream(new File(path));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("LoginTC");
		int row_count = sheet.getPhysicalNumberOfRows();
		int col_count = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[row_count-1][col_count];
		
		for(int i=1;i<row_count;i++)
		{
			for(int j = 0;j<=col_count-1;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
	
		}
		return data;
		
	}

	@Test(dataProvider="LoginTestData")
	public void logintest(String username, String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		driver.close();
		
	}
	
}
