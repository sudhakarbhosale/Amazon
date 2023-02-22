package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonsignup {
	
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement mobemail ;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continuee ;
	
	public Amazonsignup (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendmobno(String mobno)
	{
		mobemail.sendKeys(mobno);
	}
	public void clickcontinue ()
	{
		continuee.click();
	}

}
