package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazonmobile {
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait ;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement mobile;
	
	
	public Amazonmobile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions (driver);
		wait = new WebDriverWait (driver,10);
		
	}
	
	public void clickmobile()
	{
		mobile.click();


	}
	public String getTextmobile()
	{
		String textdata = mobile.getText();
		return textdata;
	}

}
