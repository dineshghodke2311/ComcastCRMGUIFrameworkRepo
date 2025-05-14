import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_PropertyFileTest {
	WebDriver driver;

	@Test
	public void logintc() throws IOException
	{
		String path= "./TestData_Configuration/TestData.properties";
		FileInputStream fis = new FileInputStream(new File(path));

		Properties prop = new Properties();
        prop.load(fis);
		String url = prop.getProperty("URL");
		System.out.println(url);
		String uname = prop.getProperty("Username");
		String pass = prop.getProperty("Password");

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(uname);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		driver.close();


	}

}

