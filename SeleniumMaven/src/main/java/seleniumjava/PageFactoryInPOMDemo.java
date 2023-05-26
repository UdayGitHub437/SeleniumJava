package seleniumjava;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageFactoryInPOMDemo {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void openApp()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test(priority=1)
	public void login()
	{
		OrangeHRMLoginPageForPageFactoryInPOM orange=new OrangeHRMLoginPageForPageFactoryInPOM(driver);
		orange.username().sendKeys("Admin");
		orange.password().sendKeys("admin123");
		orange.loginButton().click();
	}
	@Test(priority=2)
	public void logout()
	{
		OrangeHRMHomePageForPageFactoryInPOM orange1=new OrangeHRMHomePageForPageFactoryInPOM(driver);
		orange1.profileIcon().click();
		orange1.logout().click();
	}
	@AfterTest
	public void closeBrowser()
	{
	driver.quit();	
	}

}
