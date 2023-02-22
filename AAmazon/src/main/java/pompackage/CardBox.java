package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardBox {
	
	private WebDriver driver;
	
	
	
	@FindBy(xpath="(//div[@class='sc-item-content-group']//span)[5]")
	private WebElement mobileDetaisInCardBox ;
	
	public CardBox (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public String getmobileDetail()
	{
		String textdata = mobileDetaisInCardBox.getText();
		return textdata;
	}
	public void clickOnMobileDetail()
	{
		mobileDetaisInCardBox.click();
	}

}
