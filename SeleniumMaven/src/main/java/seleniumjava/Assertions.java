package seleniumjava;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Assertions {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	@Test
	public void openApp()
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().setSize(new Dimension(100,1000));
	}
	@Test(priority=1)
	public void enterDetails() throws Exception
	{
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("123456789123456789");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("123456789");
		WebElement loginButton=driver.findElement(By.name("login"));
		loginButton.click();

		String expectedmsg="email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	    WebElement errormsg=driver.findElement(By.xpath("//div[@class=\"_9ay7\"]"));
	    String actualmsg=errormsg.getText();
	    Assert.assertEquals(actualmsg,expectedmsg,"Error msg is not matching the clients requirement");
	}
	@Test(priority=2)
	public void closeBrowser()
	{
		//driver.close();
	}
}
