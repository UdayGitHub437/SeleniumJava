package seleniumjava;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Practice {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
     	WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("enter username");
		String s=sc.next();
		userName.sendKeys(s);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("enter password");
		String s1=sc.next();
		password.sendKeys(s1);
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
	}
}