package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mobilespeci {
	private WebDriver driver;
	
	@FindBy(xpath="//span[@id='submit.add-to-cart']")
	private WebElement addtocard ;
	
	
	
	@FindBy(xpath="//div[@id='titleSection']//span")
	private WebElement mobiledetail ;
	
	@FindBy(xpath="//span[@id='submit.buy-now']")
	private WebElement buyNow ;
	
	
	public Mobilespeci (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickaddtocard()
	{
		addtocard.click();
	}
	public void clickbuynow ()
	{
			Actions act = new Actions (driver);
			act.moveToElement(buyNow).click().build().perform();
	}
	
	public String getTextmobile()
	{
		String textdata = mobiledetail.getText();
		return textdata;
	}
	
	
	

	

}//(//input[@class='a-button-input'])[29]
