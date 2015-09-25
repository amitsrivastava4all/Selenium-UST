package com.ust.framework.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	public static String getXLSPath(){
		return rb.getString("xlspath");
	}
	public static String getDriver(){
		return rb.getString("driverpath");
	}
}
