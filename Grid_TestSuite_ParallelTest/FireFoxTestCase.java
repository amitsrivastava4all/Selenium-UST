import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class FireFoxTestCase {
	@Test
	public void loginTest(){
		
		WebDriver driver = new FirefoxDriver();
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
