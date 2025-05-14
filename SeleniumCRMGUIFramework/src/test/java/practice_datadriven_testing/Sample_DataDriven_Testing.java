package practice_datadriven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Sample_DataDriven_Testing {

	public static void main(String[] args) throws IOException {
		//1. get the java represenation obect of the physical file 
		
		FileInputStream fis = new FileInputStream("./PropertyData/commondata.properties");
		
		//2. create the object for properties class ,load all the keys
		
		Properties prop = new Properties();
		prop.load(fis);
		
		//3 . get the value based on key
		
		System.out.println(prop.getProperty("browser"));
		
		System.out.println(prop.getProperty("url"));
		
		System.out.println(prop.getProperty("username"));
		
		System.out.println(prop.getProperty("password"));
		

	}

}
