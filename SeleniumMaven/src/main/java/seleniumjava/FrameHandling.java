package seleniumjava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args)throws Exception {
       System.setProperty("webdriver.edge.driver", "E:\\UpdatedEdgeDriver\\msedgedriver.exe");
       WebDriver driver=new EdgeDriver();
       driver.get("https://jqueryui.com/droppable/");
       driver.manage().window().maximize();
//       driver.switchTo().frame(0);
//       WebElement drag=driver.findElement(By.id("draggable"));
//       WebElement drop=driver.findElement(By.id("droppable"));
       Actions act=new Actions(driver);
//       act.dragAndDrop(drag, drop).perform();
//       driver.switchTo().defaultContent();	
       WebElement sliderframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
       driver.switchTo().frame(sliderframe);
       WebElement drag1=driver.findElement(By.id("draggable"));
       WebElement drop1=driver.findElement(By.id("droppable"));
       act.dragAndDrop(drag1, drop1).perform();
       }
}

