package seleniumjava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelWithIterator {
	public static void main(String[] args)throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		File file=new File("C:\\Users\\lenovo\\Desktop\\Excel files\\LoginDetails.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Iterator iterator=sheet.iterator();
		while(iterator.hasNext())
		{
		XSSFRow row=(XSSFRow)iterator.next();
		Iterator iterator1=row.cellIterator();
		while(iterator1.hasNext())
		{
			WebElement userName1=driver.findElement(By.id("email"));
            userName1.clear();
			WebElement password1=driver.findElement(By.id("pass"));
            password1.clear();
			for(int i=0;i<=1;i++)
			{	
			XSSFCell cell=(XSSFCell)iterator1.next();
			if(i==0)
			{
			WebElement userName=driver.findElement(By.id("email"));
			userName.sendKeys(cell.getStringCellValue());
			}
			if(i==1)
			{
			WebElement password=driver.findElement(By.id("pass"));
			password.sendKeys(cell.getStringCellValue());
			}
			}
		}
		}
		
		
		
	}

}
