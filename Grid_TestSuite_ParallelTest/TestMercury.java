import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMercury {
	
	@Test
	public void gridTest() throws Exception{
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.LINUX);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.154.1:4444/wd/hub"),dc);
		
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.name("userName"));
		
		userName.sendKeys("amitsrivastava");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("amit123456");
		Thread.sleep(3000);
		
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Flight"));
		driver.close();
	}

}
