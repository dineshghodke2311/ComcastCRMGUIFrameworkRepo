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

public class DWS_RegisterTest {

	@DataProvider(name="RegisterData")
	public Object[][] testdata() throws EncryptedDocumentException, IOException
	{

		// path of test data file 
		String path = "./DWS_TestData/TestData.xlsx";
		FileInputStream fis = new FileInputStream(new File(path));

		// create workbook 
		Workbook workbook = WorkbookFactory.create(fis);

		//access the sheet and from sheet get rows and columns 
		Sheet sheet = workbook.getSheet("RegisterTC");
		int row_count = sheet.getPhysicalNumberOfRows();
		int col_count = sheet.getRow(0).getPhysicalNumberOfCells();

		// create object for 2 dimenstional array

		Object[][] data = new Object[row_count-1][col_count];

		// iterate data 
		for(int i =1;i<row_count;i++)
		{
			for(int j=0 ;j<=col_count-1;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}

		}
		return data;
	}

	@Test(dataProvider="RegisterData")
	public void register(String firstname,String lastname ,String email,String password,String cpassword) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.name("FirstName")).sendKeys(firstname);
        driver.findElement(By.name("LastName")).sendKeys(lastname);
        driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.name("ConfirmPassword")).sendKeys(cpassword);
        driver.findElement(By.id("register-button")).click();
        driver.quit();



	}

}
