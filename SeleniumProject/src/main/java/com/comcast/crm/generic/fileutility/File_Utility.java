package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/vtiger.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}

}
