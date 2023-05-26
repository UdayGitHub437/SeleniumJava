package seleniumjava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class KeywordDrivenFrameWork {
	WebDriver driver;
	FileInputStream fis;

	public void launchBrowser()
	{
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void navigate()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void enterUserName() throws IOException
	{
		WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
	}
	public void enterPassword()
	{
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
	}
	public void clickLoginButton()
	{
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
	}
	public void clickLogoutButton() throws Exception
	{
		WebElement dropDown=driver.findElement(By.cssSelector("[class='oxd-userdropdown']"));
		dropDown.click();
		WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
	}
	public void closeBrowser()
		{
		driver.close();
		}
	
	public static void main(String[] args) throws Exception {
		KeywordDrivenFrameWork kdf=new KeywordDrivenFrameWork();
		FileInputStream fis=new FileInputStream("C:\\Users\\lenovo\\Desktop\\Excel files\\KeywordsList.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
    	System.out.println(sheet.getLastRowNum());
        for(int i=1;i<=sheet.getLastRowNum();i++)
        {
        	XSSFRow row=sheet.getRow(i);
        	String s=row.getCell(2).getStringCellValue();
        	if(s.equals("Yes"))
        	{
        		String keyword=row.getCell(1).getStringCellValue();
        		if(keyword.equals("launchBrowser"))
        		{
        			kdf.launchBrowser();
        		}
        		else if(keyword.equals("navigate"))
        		{
        			kdf.navigate();
        		}
        		else if(keyword.equals("enterUserName"))
        		{
        			kdf.enterUserName();
        		}
        		else if(keyword.equals("enterPassword"))
        		{
        			kdf.enterPassword();
        		}
        		else if(keyword.equals("clickLoginButton"))
        		{
        			kdf.clickLoginButton();
        		}
        		else if(keyword.equals("clickLogoutButton"))
        		{
        			kdf.clickLogoutButton();
        		}
        		else if(keyword.equals("closeBrowser"))
        		{
        			kdf.closeBrowser();
        		}
        	}
        }
	}

}
