package practice_testng_annotations;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExelUtility;

public class Practice_DataProviderTest {
	
	@Test(dataProvider="getdata")
	public void sampleTest(String brandname , String productname)
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("http://amazon.in");
		
        // serach product 
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
        
        // capture product info 
        
        String x= "//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";
        String  price = driver.findElement(By.xpath(x)).getText();
        System.out.println(price);
	}
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		ExelUtility elib = new ExelUtility();
		int rowcount = elib.getRowcount("product");
		
		Object[][] objr = new Object[rowcount][2];
		
		for(int i =0 ;i<rowcount ;i++)
		{
			objr[i][0]=elib.getDatafromExelfile("product", i+1, 0);
			objr[i][1]=elib.getDatafromExelfile("product", i+1, 1);
			
		}
		
	return objr;
		
	}

}
