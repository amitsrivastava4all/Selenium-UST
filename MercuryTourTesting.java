import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MercuryTourTesting {

	public static void main(String[] args) throws Exception {
		final int DELAY = 2000;
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // Creating a Chrome Driver Object
		String url = "http://newtours.demoaut.com/";
		driver.get(url);  // Driver is going to open this URL.
		driver.manage().window().maximize();
		// this line will looking for userName field in the entire page
		// and our code is searching for userName in the entire page
		WebElement userName = driver.findElement(By.name("userName"));
		userName.clear();
		userName.sendKeys("amitsrivastava"); // this will type the username
		Thread.sleep(DELAY);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("amit123456");
		Thread.sleep(DELAY);
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(DELAY);
		// Two Radio Button with Same Name , and We Need to Select One of them
		List<WebElement> radioButtons = driver.findElements(By.name("tripType"));
		WebElement radio2 = radioButtons.get(1);  // this will give the Second Radio Button
		radio2.click();
		WebElement deptFrom = driver.findElement(By.name("fromPort"));
		Select select = new Select(deptFrom);
		select.selectByVisibleText("London");
		
		
		
		WebElement continueBt = driver.findElement(By.name("findFlights"));
		continueBt.click();
		Thread.sleep(DELAY);
		// Ajax Calls
		/*WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("fieldname")));
		myDynamicElement.click();*/
		WebElement label = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font"));
		String valueOfLabel = label.getText();
		if(valueOfLabel.contains("London to ")){
			System.out.println("test pass");
		}
		else
		{
			System.out.println("test fail");
		}
		
		//select.selectByIndex(0);
		//select.selectByValue("London");
		/*if(radio2.isEnabled() && radio2.isDisplayed() && radio2.isSelected()){
		radio2.click();
		}*/
		
		Thread.sleep(DELAY);
		driver.close(); // this will close the browser

	}

}
