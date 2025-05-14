import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Working_with_PropertyfilesTest {

	
	@Test
	public void demo() throws IOException
	{
		String path = "./TestData_Configuration/TestData.properties";
		
		FileInputStream fis = new FileInputStream(new File(path));
		
		//create object for property class
		Properties prop = new Properties();
		prop.load(fis);
		
		// to retrive the values from the property file
		
		String fname = prop.getProperty("FirstName");
		System.out.println(fname);
		
		String lname = prop.getProperty("LastName");
		System.out.println(lname);
		
		
		
		
		
	}
	
}
