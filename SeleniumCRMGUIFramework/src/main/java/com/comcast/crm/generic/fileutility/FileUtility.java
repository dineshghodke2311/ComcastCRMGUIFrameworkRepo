package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDatafromPropertiesfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./PropertyData/commondata.properties");
		Properties propobj = new Properties();
		propobj.load(fis);
		String data = propobj.getProperty(key);
		
		return data;
		
	}
	
}
