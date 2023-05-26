package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CalendarDemo {
	WebDriver driver;
	JavascriptExecutor jse;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openApp()
	{
		driver.navigate().to("https://jqueryui.com/datepicker/");
	}
	@Test(priority=1)
	public void selectDate()
	{
		driver.switchTo().frame(0);
		jse=(JavascriptExecutor)driver;
		DateFormat dt=new SimpleDateFormat("MM/dd/yyyy");
		Date sysDate=new Date();
		String tdate=dt.format(sysDate);
		System.out.println(tdate);
		jse.executeScript("document.getElementById('datepicker').value=tdate");
		
	}

}
