package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ThreadPoolSize {
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
		driver.manage().window().maximize();
	}
	@Test(priority=1, invocationCount=2, threadPoolSize=1)
	public void enterDetails()
	{
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("123456789");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("123456789");
	}
	@Test(priority=2)
	public void login()
	{
		WebElement loginButton=driver.findElement(By.name("login"));
		loginButton.click();
	}

}
