package practice_create_org;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CerateOrg_with_IndusrtyandTypeTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		// read the common data form properties file
        FileInputStream fis = new FileInputStream("./PropertyData/commondata.properties");
		Properties propobj = new Properties();
		propobj.load(fis);
		String BROWSER = propobj.getProperty("browser");
		String URL = propobj.getProperty("url");
		String USERNAME = propobj.getProperty("username");
		String PASSWORD = propobj.getProperty("password");
		
		// create random number
		  Random random = new Random();
	       int random_number = random.nextInt(1000);
		// read the test data from exel file 

		FileInputStream fis1 = new FileInputStream("./Data/Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
        Sheet sh = wb.getSheet("org");
        Row row = sh.getRow(4);
        String orgname = row.getCell(2).toString()+random_number;
        String industry = row.getCell(3).toString();
        String	type     = row.getCell(4).toString();
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
        WebElement industry_field = driver.findElement(By.name("industry"));
		
		Select sel = new Select(industry_field);
		sel.selectByVisibleText(industry);
		
		WebElement account_type = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(account_type);
		sel2.selectByVisibleText(type);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String nameofindustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if(nameofindustry.equals(industry))
		{
			System.out.println(industry + "---information __pass");
		}
		else
		{
			System.out.println(industry + "---information __fail");
		}
		String typeofindustry = driver.findElement(By.id("dtlview_Type")).getText();
		
		if(typeofindustry.equals(type))
		{
			System.out.println(type + "---information __pass");
		}
		else
		{
			System.out.println(type + "---information __fail");
		}
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
