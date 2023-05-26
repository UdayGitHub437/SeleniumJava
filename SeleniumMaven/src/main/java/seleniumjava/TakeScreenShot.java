package seleniumjava;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
public class TakeScreenShot {
	WebDriver driver;
	TakesScreenshot ts;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
@Test
public void openApp() throws Exception
{
	driver.get("https://www.cricbuzz.com");
	Thread.sleep(4000);
	ts=(TakesScreenshot)driver;
	  File file=ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file,new File("C:\\Users\\lenovo\\Desktop\\SeleniumScreenShots\\cricbuzzhom.jpg"));
	driver.findElement(By.xpath("//a[@title=\"Punjab Kings v Gujarat Titans - 18th Match\"]")).click();
}
@Test
public void screenshot() throws IOException
{
  ts=(TakesScreenshot)driver;
  File file=ts.getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(file,new File("C:\\Users\\lenovo\\Desktop\\SeleniumScreenShots\\cricmatc.jpg"));

}
	
}
