package seleniumjava;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class Selenium1 {
	RemoteWebDriver driver;
@Test
public void m1()
 {
	System.out.println("m1 starting....");
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
RemoteWebDriver driver=new EdgeDriver();
this.driver=driver;
driver.get("https://www.facebook.com");
System.out.println("m1 executed successfully");
	}
@AfterMethod
public void afterMethod()
{
System.out.println("AfterMethod executed successfully");	
}
@AfterTest
public void m2()
{
	driver.close();
	System.out.println("m2 executed successfully");

	}

}













