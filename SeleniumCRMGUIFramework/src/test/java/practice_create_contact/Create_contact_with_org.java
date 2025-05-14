package practice_create_contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Create_contact_with_org {
// stale element refereance exception are coming but in main method  class we can't handle this.
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
        Row row = sh.getRow(7);
        String orgname = row.getCell(2).toString()+random_number;
        String lastname = row.getCell(3).toString()+random_number;
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
		
		
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
        
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        
        while(it.hasNext())
        {
        	
        	String windowid = it.next();
        	driver.switchTo().window(windowid);
        	
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Accounts"))
			{
				break;
			}
			
        }
		
        driver.findElement(By.id("search_txt")).sendKeys(orgname);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath("//a[text()='"+orgname+"'")).click();
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

        Set<String> set1 = driver.getWindowHandles();
        Iterator<String> it1 = set.iterator();
        
        while(it.hasNext())
        {
        	
        	String windowid = it1.next();
        	driver.switchTo().window(windowid);
        	
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("Contacts&action"))
			{
				break;
			}
			
        }
        
        String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        
        if(headerinfo.contains(lastname))
         {
     	   System.out.println(lastname + "---is created --pass");
     	  
         }
        else
        {
     	   System.out.println(lastname + "---is not created --fail");
        }
        
       
         String actualorg_name = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualorg_name.trim().equals(orgname))
		{
			System.out.println(orgname + "information --pass");
		}
			
		else
		{
			System.out.println(orgname + "information --fail");
		}
		
        
        driver.quit();
	}

}
