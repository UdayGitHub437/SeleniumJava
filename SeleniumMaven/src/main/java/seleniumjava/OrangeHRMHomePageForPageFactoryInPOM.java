package seleniumjava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

public class OrangeHRMHomePageForPageFactoryInPOM {
	WebDriver driver;
	public OrangeHRMHomePageForPageFactoryInPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="oxd-userdropdown-tab")
	private WebElement profileIcon;
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	public WebElement profileIcon()
	{
		return profileIcon;
	}
	public WebElement logout()
	{
		return logout;
	}
}
