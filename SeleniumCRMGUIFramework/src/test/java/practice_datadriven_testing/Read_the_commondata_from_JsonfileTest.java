package practice_datadriven_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.FileReader;

public class Read_the_commondata_from_JsonfileTest {
	@Test
	public void readdata() throws EncryptedDocumentException, IOException, ParseException {
		WebDriver driver;
		
		//read the common data from JSON line
		 JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("./Data/commondata.json"));
		   JSONObject map = (JSONObject)obj ;
		
		String URL = map.get("url").toString();
		String BROWSER = map.get("browser").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD = map.get("password").toString();
		
		System.out.println("url data--"+URL);
		System.out.println("browser data--"+BROWSER);
		System.out.println("username data--"+USERNAME);
		System.out.println("password data--"+PASSWORD);
		
		// create random number
		  Random random = new Random();
	      int random_number = random.nextInt(1000);
		// read the test data from exel file 

		FileInputStream fis1 = new FileInputStream("./Data/Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
        Sheet sh = wb.getSheet("org");
        Row row = sh.getRow(1);
        String orgname = row.getCell(2).toString()+random_number;
        wb.close();
      
        if(BROWSER.equals("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}

