import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNGDemo1 {
	
	WebDriver driver=null;  // Instance Var
	
	@BeforeMethod
	public void openDriver(){
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");

		driver = new ChromeDriver();  
	}
	
	@AfterMethod
	public void closeDriver(){
		if(driver!=null){
			driver.close();
		}
	}
	
	// My TestCase
	//@Test(timeOut=5000)
	//@Test(enabled=false)
	@Test(enabled=false)
	public void testLoginPage() throws Exception{
		final int DELAY = 2000;
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  // Creating a Chrome Driver Object
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
		String expected = "London to Acapulco";
		Assert.assertEquals(valueOfLabel,expected);
		/*	if(valueOfLabel.contains("London to ")){
			System.out.println("test pass");
		}
		else
		{
			System.out.println("test fail");
		}*/
		
		//select.selectByIndex(0);
		//select.selectByValue("London");
		/*if(radio2.isEnabled() && radio2.isDisplayed() && radio2.isSelected()){
		radio2.click();
		}*/
		
		Thread.sleep(DELAY);
		//driver.close(); // this will close the browser

	}
	
	@DataProvider(name="mydataproviderforusers")
	public Object[][] userData(){
		//Object [][]users = new Object[5][2];
		//Object users[][] = new Object[5][2];
		Object []users[] = new Object[5][2];
		users[0][0]="mike@yahoo.com";
		users[0][1]="123456";
		
		users[1][0]="mike@gmail.com";
		users[1][1]="123456";
		
		users[2][0]="tim@yahoo.com";
		users[2][1]="123456";
		
		users[3][0]="tim@gmail.com";
		users[3][1]="123456";
		if(10>20){
		users[4][0]="jim@yahoo.com";
		users[4][1]="123456";
		}
		return users;
 	}
	
	
	
	@Test(dataProvider="mydataproviderforusers")
	public void testFaceBook(String userid, String pwd){
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium-21stBatch\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  // Creating a Chrome Driver Object
		/*if(userid.equals("mike@yahoo.com") && pwd.equals("123456")){
			return;
		}*/
		// ResourceBundle is a Predefine class and it is used to read
		// the config file
		ResourceBundle rb = ResourceBundle.getBundle("config");
		// Use to read the Key and this will give the Value
		String url = rb.getString("pageurl");
		//String url = "https://www.facebook.com/";
		driver.get(url);  // Driver is going to open this URL.
		driver.manage().window().maximize();
		//WebElement email = driver.findElement(By.id("email"));
		WebElement email = driver.findElement(By.id(rb.getString("emailtxt")));
		email.sendKeys(userid);
		//email.sendKeys("mike@yahoo.com");
		//WebElement password = driver.findElement(By.id("pass"));
		WebElement password = driver.findElement(By.id(rb.getString("passwordtxt")));
		password.sendKeys(pwd);
		//password.sendKeys("123456");
		//WebElement loginButton = driver.findElement(By.id("u_0_v"));
		WebElement loginButton = driver.findElement(By.id(rb.getString("loginbt")));
		loginButton.click();
		//WebElement message = driver.findElement(By.cssSelector(".fsl.fwb.fcb"));
		WebElement message = driver.findElement(By.cssSelector(rb.getString("classname")));
		String actualMessage = message.getText();
		String expectedMessage = rb.getString("expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		//driver.close();
		//fsl fwb fcb
		//Please re-enter your password
		
	}

}
