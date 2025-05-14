package practice_create_contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Create_contact_with_supportdate {

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
        Sheet sh = wb.getSheet("contact");
        Row row = sh.getRow(1);
        String lastname = row.getCell(2).toString()+random_number;
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		 Date date = new Date();
	       SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	       String startdate = sim.format(date);
	       Calendar cal = sim.getCalendar();
	       cal.add(Calendar.DAY_OF_MONTH,30);
	       String enddate = sim.format(cal.getTime());
	   
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("support_start_date")).sendKeys(startdate);
        driver.findElement(By.name("support_end_date")).clear();
        driver.findElement(By.name("support_end_date")).sendKeys(enddate);
        
        
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
        
      String actualstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
      if(actualstartdate.equals(startdate))
      {
    	  
    	  System.out.println(startdate + "--information verified --pass");
      }
       
      else
      {
    	  System.out.println(startdate + "--information not verified --fail");
    	  
      }
      
      String actualenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
    
      if(actualenddate.equals(enddate))
      {
    	  
    	  System.out.println(enddate + "--information verified --pass");
      }
       
      else
      {
    	  System.out.println(enddate + "--information not verified --fail");
    	  
      }
      
      
      
      driver.close();
       
       
       
       
       
       
       
       
       
       
       
	}

}
