package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Alert {
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
    	driver.get("https://www.tsrtconline.in/oprs-web/");
    	driver.manage().window().maximize();
    }
    @Test(dependsOnMethods="openApp")
    public void enterDetails()
    {
    	driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("Hyderabad");
    	String s = driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getAttribute("value");
    	System.out.println(s);
    }
    @Test(dependsOnMethods="enterDetails")
    public void submit() throws InterruptedException
    {
    	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
			Thread.sleep(5000); 
		
    }
    @Test(dependsOnMethods="submit")
    public void handleAlert()
    {
    	driver.switchTo().alert().accept();
    }
    @AfterTest
    public void closeBrowser()
    {
    	//driver.close();
    }
    
}
