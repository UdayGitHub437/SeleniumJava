package seleniumjava;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.AfterTest;


public class ReadDataFromExcel {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void openApp()
	{
		driver.navigate().to("https://www.facebook.com");
	}
	@Test(priority=2)
	public void enterDetails() throws Exception
	{
		String excelPath="C:\\Users\\lenovo\\Desktop\\Excel files\\LoginDetails.xlsx";
		FileInputStream fis=new FileInputStream(excelPath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		System.out.println(sheet.getLastRowNum());
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			XSSFRow row=sheet.getRow(i);
			System.out.println(row.getLastCellNum());
			for(int j=0;j<(row.getLastCellNum())-1;j++)
			{
				XSSFCell cell=row.getCell(j);
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys(cell.getStringCellValue());
		XSSFCell cell1=row.getCell(j+1);
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys(cell1.getStringCellValue());
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement username1=driver.findElement(By.id("email"));
                  username1.clear();
			}
		}
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
