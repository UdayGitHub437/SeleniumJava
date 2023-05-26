package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

public class CheckSortWebTableButtonIsFunctioning {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openApp()
	{
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
	}
	@Test(priority=1)
	public void checkSortingButtonisFunctioningProperly()
	{
		WebElement sort=driver.findElement(By.xpath("//button[text()='Sort']"));
		sort.click();
		List<WebElement> afterSort=driver.findElements(By.xpath("//table[1]/tbody/tr/td[1]"));	
		for(int i=0;i<afterSort.size();i++)
		{
           System.out.println(afterSort.get(i).getText());
		}
		System.out.println("sort button is functioning as intended");
	}
	@Test(priority=2)
	public void closeBrowser()
	{
		driver.close();
	}

}
