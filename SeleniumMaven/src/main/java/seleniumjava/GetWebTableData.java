package seleniumjava;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.WebElement;

public class GetWebTableData {
	WebDriver driver;
	List<WebElement> tables;
	List<WebElement> rows;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
	}
	@Test
	public void countOfTables()
	{
		tables=driver.findElements(By.tagName("table"));
		System.out.println("Total no: of tables= "+tables.size());
	}
	@Test(priority=1)
	public void countOfRows()
	{
		rows=tables.get(0).findElements(By.tagName("tr"));
		System.out.println("Total no: of rows= "+rows.size());
	}
	@Test(priority=2)
	public void countOfCellsInTable()
	{
		List<WebElement> cells=tables.get(0).findElements(By.tagName("td"));
		System.out.println("Total no: of cells= "+cells.size());
	}
	@Test(priority=3)
	public void printTimeOfCities()
	{
		String s1="//table/tbody/tr[";
		String s2="]/td[";
		String s3="]";
		for(int i=1;i<rows.size();i++)
		{
			for(int j=1;j<=2;j++)
			{
				WebElement row=tables.get(0).findElement(By.xpath(s1+i+s2+j+s3));
                System.out.print(row.getText());
                System.out.print(" : ");
			}
			System.out.println();
			System.out.println("--------------------------");
			for(int j=3;j<=4;j++)
			{
				WebElement row=tables.get(0).findElement(By.xpath(s1+i+s2+j+s3));
                System.out.print(row.getText());
                System.out.print(" : ");
			}
			System.out.println();
			System.out.println("--------------------------");
			for(int j=5;j<=6;j++)
			{
				WebElement row=tables.get(0).findElement(By.xpath(s1+i+s2+j+s3));
                System.out.print(row.getText());
                System.out.print(" : ");
			}
			System.out.println();
			System.out.println("--------------------------");
			for(int j=5;j<=6;j++)
			{
				WebElement row=tables.get(0).findElement(By.xpath(s1+i+s2+j+s3));
                System.out.print(row.getText());
                System.out.print(" : ");
			}
			System.out.println();
			System.out.println("--------------------------");
		}
	}

}
