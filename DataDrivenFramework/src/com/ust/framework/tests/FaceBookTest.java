package com.ust.framework.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ust.framework.datasource.DataBaseReader;
import com.ust.framework.datasource.ExcelReader;
import com.ust.framework.util.ConfigReader;

public class FaceBookTest {
	
	
WebDriver driver=null;  // Instance Var
	
	@BeforeMethod
	public void openDriver(){
		System.setProperty("webdriver.chrome.driver",ConfigReader.getDriverPath());

		driver = new ChromeDriver();  
	}
	
	@AfterMethod
	public void closeDriver(){
		if(driver!=null){
			driver.close();
		}
	}
	
	@DataProvider(name="fbDataProvider")
	public Object[][] fbDataProvider() throws Exception{
		Object array[][]=DataBaseReader.readDB();
		//Object array[][]  = ExcelReader.readExcel();
		return array;
	}
	
	@Test(dataProvider="fbDataProvider")
	public void doLoginTest(String userid, String pwd) throws Exception{
		driver.get(ConfigReader.getURL());
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(userid);
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(pwd);
		
		WebElement loginButton = driver.findElement(By.id("u_0_v"));
		loginButton.click();
		
		WebElement message = driver.findElement(By.cssSelector(".fsl.fwb.fcb"));
		String actualValue = message.getText();
		String expectedValue = "Please re-enter your password";
		Assert.assertEquals(actualValue,expectedValue);
		Thread.sleep(2000);
		//driver.close();
	}

}
