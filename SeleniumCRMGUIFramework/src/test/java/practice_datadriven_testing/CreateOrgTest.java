package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		FileInputStream fis = new FileInputStream("./PropertyData/commondata.properties");
		
		Properties propobj = new Properties();
		propobj.load(fis);
		
		String BROWSER = propobj.getProperty("browser");
		String URL = propobj.getProperty("url");
		String USERNAME = propobj.getProperty("username");
		String PASSWORD = propobj.getProperty("password");
		
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
		
		driver.findElement(By.name("accountname")).sendKeys("Testyantra");
		driver.findElement(By.name("website")).sendKeys("testyantra.com");
		//driver.findElement(By.name("tickersymbol")).sendKeys("");
		//driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[7]/input[1]")).sendKeys("testing");
		driver.findElement(By.id("employees")).sendKeys("100");
		driver.findElement(By.id("email2")).sendKeys("test@testyantra.com");
		WebElement industry = driver.findElement(By.name("industry"));
		
		Select sel = new Select(industry);
		sel.selectByVisibleText("Technology");
		
		WebElement account_type = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(account_type);
		sel2.selectByVisibleText("Other");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("fax")).sendKeys("yes");
		driver.findElement(By.id("otherphone")).sendKeys("2222222222");
		driver.findElement(By.id("email1")).sendKeys("abcd@test.com");
		driver.findElement(By.id("ownership")).sendKeys("Kumar");
		WebElement rating = driver.findElement(By.name("rating"));
		
		Select sel3 = new Select(rating);
		sel3.selectByVisibleText("Active");
		driver.findElement(By.id("siccode")).sendKeys("1234");
		driver.findElement(By.name("annual_revenue")).sendKeys("100000000");
		driver.findElement(By.name("notify_owner")).click();
		driver.findElement(By.name("cpy")).click();
		 WebElement add1 = driver.findElement(By.xpath("//td[@class='dvtCellInfo']/textarea[@name='bill_street']"));
		add1.click();
		add1.sendKeys("thergaon pune");
		driver.findElement(By.xpath("//td[@class='dvtCellInfo']/textarea[@name='ship_street']")).sendKeys("thergaon pune");
		driver.findElement(By.id("bill_pobox")).sendKeys("2345");
		driver.findElement(By.id("ship_pobox")).sendKeys("2345");
		driver.findElement(By.id("bill_city")).sendKeys("pune");
		driver.findElement(By.id("ship_city")).sendKeys("pune");
		driver.findElement(By.id("bill_state")).sendKeys("maharashtra");
		driver.findElement(By.id("ship_state")).sendKeys("maharashtra");
		driver.findElement(By.id("bill_code")).sendKeys("411033");
		driver.findElement(By.id("ship_code")).sendKeys("411033");
		driver.findElement(By.id("bill_country")).sendKeys("India");
		driver.findElement(By.id("ship_country")).sendKeys("India");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contentEquals("Testyantra"))
		{
			System.out.println("Organization name verified");
			
		}
		
		driver.close();
	}
	

}
