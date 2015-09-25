package com.ust.framework.executor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ust.framework.dto.CommandDTO;
import com.ust.framework.utils.ConfigReader;
import com.ust.framework.utils.ExcelReader;

public class CommandExecutor {
	
	@Test
	public  void executor() throws Exception{
		WebDriver driver =null;
		List<CommandDTO> commandList = ExcelReader.readExcel();
		for(CommandDTO commandDTO : commandList){
			if(commandDTO.getCommand()!=null && commandDTO.getCommand().trim().length()>0){
				if(commandDTO.getCommand().equalsIgnoreCase("browser")){
					if(commandDTO.getTarget()!=null && commandDTO.getTarget().trim().length()>0){
						if(commandDTO.getTarget().equalsIgnoreCase("chrome")){
							System.setProperty("webdriver.chrome.driver",ConfigReader.getDriver());
							driver = new ChromeDriver();
						}
						else
						if(commandDTO.getTarget().equalsIgnoreCase("firefox")){	
							driver = new FirefoxDriver();
						}
					}
				}  // browser code ends
				else
				if(commandDTO.getCommand().equalsIgnoreCase("open")){
					driver.get(commandDTO.getTarget());
				}
				else
				if(commandDTO.getCommand().equalsIgnoreCase("type")){
					String target = commandDTO.getTarget();
					String array[] = target.split("=");
					if(array[0].equalsIgnoreCase("name")){
						WebElement element = driver.findElement(By.name(array[1]));
						element.sendKeys(commandDTO.getValue());
					}
					else
					if(array[0].equalsIgnoreCase("id")){
						WebElement element = driver.findElement(By.id(array[1]));
						element.sendKeys(commandDTO.getValue());
					}
					else
						if(array[0].equalsIgnoreCase("class")){
							WebElement element = driver.findElement(By.cssSelector(array[1]));
							element.sendKeys(commandDTO.getValue());
						}
						else
							if(array[0].equalsIgnoreCase("xpath")){
								WebElement element = driver.findElement(By.xpath(array[1]));
								element.sendKeys(commandDTO.getValue());
							}
					
				} // type command code ends
				else
				if(commandDTO.getCommand().equalsIgnoreCase("clickAndWait")){
					String target = commandDTO.getTarget();
					String array[] = target.split("=");
					if(array[0].equalsIgnoreCase("name")){
						WebElement element = driver.findElement(By.name(array[1]));
						element.click();
					}
					else
						if(array[0].equalsIgnoreCase("id")){
							WebElement element = driver.findElement(By.id(array[1]));
							element.click();
						}	
						else
					if(array[0].equalsIgnoreCase("class")){
						WebElement element = driver.findElement(By.cssSelector(array[1]));
						element.click();
					}
					else
					if(array[0].equalsIgnoreCase("xpath")){
						WebElement element = driver.findElement(By.xpath(array[1]));
						element.click();
					}
				} // ClickAndWait Command Code Ends
				else
				if(commandDTO.getCommand().equalsIgnoreCase("assertTitle")){
					String expectedValue = commandDTO.getTarget();
					String pageTitle = driver.getTitle();
					Assert.assertTrue(pageTitle.contains(expectedValue));
				}  // Assert Title Code ends
			}
		}
		if(driver!=null){
			driver.close();
		}
	}

}
