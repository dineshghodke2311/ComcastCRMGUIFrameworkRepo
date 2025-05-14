package practice_screenshot;

import java.io.File;
import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
public class SampleScreenshotTest{
	
	@Test
	public void SampleSS()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
      
	     String actttitle = driver.getTitle();
	    
        TakesScreenshot ts= (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./Screenshots/test.png");
	
			try {
				FileHandler.copy(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("exception not handled");
			}
        
 
		 
	}
	

}
