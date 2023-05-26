package seleniumjava;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;import org.openqa.selenium.WebElement;

public class JavaScriptExecutorDemo {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	@Test
	public void openApp()throws Exception
	{
		driver.get("https://www.album.alexflueras.ro/index.php");
		driver.manage().window().maximize();
	}
	@Test
	public void scroll()throws Exception
	{
		JavascriptExecutor ju=(JavascriptExecutor)driver;
		//ju.executeScript("window.scrollBy(0,5000)");
		//Thread.sleep(5000);
		//ju.executeScript("window.scrollBy(0,1000)");
		//ju.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(4000);
		//ju.executeScript("window.scrollBy(0,-6000)");
		//WebElement amazon=driver.findElement(By.xpath("(//a[@class=\"a-button-text\"])[1]"));
		//ju.executeScript("arguments[0].scrollIntoView();", amazon);
		//Thread.sleep(4000);
		ju.executeScript("window.scrollBy(document.body.scrollWidth,0)");
		ju.executeScript("window.scrollBy(-8000,0)");
	}
	@AfterTest
	public void closeBrowser()throws Exception
	{
		driver.close();
	}

}
