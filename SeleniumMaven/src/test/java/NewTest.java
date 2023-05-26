import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	RemoteWebDriver driver;
 
  @BeforeSuite
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.navigate().to("https://www.cricbuzz.com");
	  driver.manage().window().maximize();
	  driver.navigate().back();
  }


@Test
public void m1()
{
	
}
@AfterSuite
public void closeBrowser()
{
	driver.close();}
}