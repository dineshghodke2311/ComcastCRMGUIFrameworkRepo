package practice_test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReports {
    ExtentSparkReporter spark;
    ExtentReports report;
	
	@BeforeSuite
	public void configBs()
	{
		// spark report config
		
		spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		// add Env information 
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows10");
		report.setSystemInfo("Browser","Chrome-100");
		
	}
	
	@AfterSuite 
	public void configAs()
	{
		report.flush();
		
	}
	
	
	@Test
	public void createContact()
	{
		 ExtentTest test = report.createTest("createContact");
		 test.log(Status.INFO,"login to app");
		 test.log(Status.INFO,"navigate to contact page");
		 test.log(Status.INFO,"create contact");
		 if("HDFC".equals("HDFC"))
		 {
			 test.log(Status.PASS,"contact is created");
		 }
		 else
		 {
			 test.log(Status.FAIL,"contact is not created"); 
		 }
	}
	
	@Test
	public void createContactWithPhone()
	{
		 ExtentTest test = report.createTest("createContactWithPhone");
		 test.log(Status.INFO,"login to app");
		 test.log(Status.INFO,"navigate to contact page");
		 test.log(Status.INFO,"create contact");
		 if("HDFC".equals("HDFC"))
		 {
			 test.log(Status.PASS,"contact is created");
		 }
		 else
		 {
			 test.log(Status.FAIL,"contact is not created"); 
		 }
	}
	
	

}
