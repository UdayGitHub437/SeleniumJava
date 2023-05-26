package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetPageSourceDemo {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openApp()
	{
		driver.navigate().to("https://www.facebook.com");
	}
	@Test(priority=1)
	public void getPageSource()
	{
		String ps=driver.getPageSource();
		System.out.println(ps);
	}

}
