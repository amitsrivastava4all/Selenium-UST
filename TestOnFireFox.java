import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestOnFireFox {

	public static void main(String[] args) throws InterruptedException {
		//D:\Selenium-21stBatch
		// 
		//System.setProperty("webdriver.ie.driver","pathofiedriver");
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		WebElement userNameElement = driver.findElement(By.name("userName"));
		Thread.sleep(2000);
		userNameElement.sendKeys("amitsrivastava");
		Thread.sleep(2000);
		WebElement pwdElement = driver.findElement(By.name("password"));
		Thread.sleep(2000);
		pwdElement.sendKeys("amit123456");
		Thread.sleep(2000);
		WebElement loginBt = driver.findElement(By.name("login"));
		loginBt.click();
		Thread.sleep(3000);
		String title = driver.getTitle(); // Give the Current Page title
		String expectedTitle ="Find a Train";
		if(title.contains(expectedTitle)){
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail..");
		}
		driver.close();

	}

}
