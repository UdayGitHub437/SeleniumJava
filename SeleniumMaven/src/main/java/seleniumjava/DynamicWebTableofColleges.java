package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.WebElement;

public class DynamicWebTableofColleges {
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
		driver.get("http://jntuhaac.in/Public/oldcolleges");
	}
	@Test(priority=1)
	public void getGnitcAddress()
	{
		List<WebElement> cells=driver.findElements(By.xpath("(//table)[2]/tbody//td"));
		for(int i=0;i<cells.size();i++)
		{
			String cellName=cells.get(i).getText();
			//System.out.println(cellName);
			String clgName="SRI INDU COLLEGE OF ENGINEERING & TECHNOLOGY";
			if(clgName.equals(cellName))
			{
				System.out.println(clgName+"::District::"+cells.get(i+2).getText());
			}
		}
		
	}

}
