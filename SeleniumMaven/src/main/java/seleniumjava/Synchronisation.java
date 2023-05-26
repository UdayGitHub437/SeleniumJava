package seleniumjava;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Synchronisation {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1000,1000));
	}
	@Test
	public void openApp()
	{
		driver.navigate().to("https://www.facebook.com/");
	}
	@Test
	public void syncDemo()
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("123456789");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("123456789");
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		WebDriverWait wait=new WebDriverWait(driver,1);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));
	element.click();
	}

}
