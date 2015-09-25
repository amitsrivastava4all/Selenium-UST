import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ChromeTestCase {

	@Test
	public void loginTest(){
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("mike@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("u_0_v"));
		loginButton.click();
		driver.close();
	}
	
}
