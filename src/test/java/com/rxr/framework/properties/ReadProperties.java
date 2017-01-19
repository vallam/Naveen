package com.rxr.framework.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	String result = "";
	InputStream inputStream;
	static String propFileName;
	Properties prop;
	
	public Properties readProperties(String folder, String fileName, Boolean matchDirectories) throws IOException{
		File propertyRootPath = new File((System.getProperty("user.dir"))+"/property/windows7property/"+folder).getAbsoluteFile();
		System.out.println("Context:" +propertyRootPath);
		fileName = fileName+".properties";
		if(matchDirectories){
			get(folder, propertyRootPath, fileName, true);
		}else{
			get(folder, propertyRootPath, fileName, false);
		}
		return getPropValues(propFileName);
	}
	
	public String findFolder(String folderName){
		return null;
	}
	
	public static void find(String folder, File context, String fileName) {
	     get(folder, context, fileName, false);
	  }
	
	public static void find(String folder, File context, String fileName, Boolean matchDirectories) {
	     get(folder, context, fileName, matchDirectories);
	  }
	
	public static void get(String folder, File context, String fileName, boolean matchDirectories) {
		String path = null;
	    if (context == null)
	      throw new NullPointerException("Context Null");

	    if (fileName == null)
	      throw new NullPointerException("File Name Null");

	    if (!context.isDirectory()) {
	      String message = "Not a directory";
	      throw new IllegalArgumentException(message);
	    }

	    File[] files = context.listFiles();
	    
	    for (int n = 0; n < files.length; ++n) {
	    	System.out.println(files[n].getName());
	    	if(files[n].getName().equals(fileName) && files[n].isFile()){
	    		propFileName = files[n].getAbsolutePath();
	    		System.out.println("File path:" +path);
	    	}
	    	if (files[n].isDirectory()){
	    		find(folder, files[n], fileName);
	    	}
	    }
	    
	  }
	
	
	public Properties getPropValues(String propFileName) throws IOException {
		 
		try {
			prop = new Properties();
 
			inputStream = new FileInputStream(propFileName.toString());
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return prop;
	}

}
