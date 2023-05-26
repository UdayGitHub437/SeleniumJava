package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DynamicWebTableDemo {
	WebDriver driver;
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
		driver.navigate().to("https://www.etmoney.com/stocks/list-of-stocks");
	}
	@Test(priority=1)
	public void getDataFromDynamicWebTable()
	{
		List<WebElement> stockName=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> priceToday=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(int i=0;i<stockName.size();i++)
		{
			String expsName="3M India Ltd. 3MINDIA";
			String sname=stockName.get(i).getText();
			//System.out.println(sname);
			if(expsName.equals(sname))
			{
				System.out.println(expsName+":: Today's price is "+priceToday.get(i).getText());
			}
		}
	}

}
