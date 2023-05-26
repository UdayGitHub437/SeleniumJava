
package seleniumjava;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ExplicitWaitDemo {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1000,1000));
	}
	@Test
	public void explicitwaitDemo()
	{
		driver.navigate().to("https://www.facebook.com");
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("12345","6789");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("12345","6789");
		WebElement loginbutton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
		WebElement loginbutton1=driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton1.click();
		WebElement loginbutton2=driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton2.click();
		WebElement loginbutton3=driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton3.click();
		WebElement loginbutton4=driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton4.click();
	}

}
	