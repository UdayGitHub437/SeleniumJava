package seleniumjava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssertions {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
	       System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
           driver=new EdgeDriver();
	}
	@Test
	public void softAssertDemo() throws Exception
	{
		driver.get("https://www.facebook.com");
		String actualTitle=driver.getTitle();
		String url="https://www.facebook.com";
		String expectedTitle="Facebook – log in or sign up";
		String expectedmsg="email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("123456789123456789");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("123456789");
		WebElement loginButton=driver.findElement(By.name("login"));
		loginButton.click();
		String actualurl=driver.getCurrentUrl();
		String title=driver.getTitle();
	    WebElement errormsg=driver.findElement(By.xpath("//div[@class=\"_9ay7\"]"));
	    String actualmsg=errormsg.getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle,"Title mismatched");
		sa.assertEquals(actualmsg,expectedmsg,"error msg mismatched");
		sa.assertNotEquals(url, actualurl, "Url did not change");
		sa.assertAll();
	}
	@Test(priority=1)
	public void closeBrowser()
	{
		driver.close();
	}

}
