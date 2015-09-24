package com.ust.framework.util;

import java.util.ResourceBundle;

public class ConfigReader {
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	public static String getExcelPath(){
		return rb.getString("xlspath");
	}
	
	public static String getDriverPath(){
		return rb.getString("driverpath");
	}
	
	public static String getURL(){
		return rb.getString("url");
	}
	
	public static String getDriver(){
		return rb.getString("drivername");
	}
	
	public static String getDBURL(){
		return rb.getString("dburl");
	}
	
	public static String getDBUserid(){
		return rb.getString("userid");
	}
	
	public static String getDBPassword(){
		return rb.getString("password");
	}

}
