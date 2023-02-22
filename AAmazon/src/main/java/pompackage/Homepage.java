package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	private WebDriver driver ;
	private 	Actions act ;
	//variables
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchproduct ;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement search ;
	
	@FindBy(xpath="//div[@id='nav-cart-count-container']")
	private WebElement cardsListBox ;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountandList ;
	
	//constructor
	 public Homepage (WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver =driver;
		  act = new Actions (driver);
		 
	 }
	 //methods
	 public void sendkeysproduct(String productname)
	 {
		 searchproduct.sendKeys(productname);
	 }
	 
	 public void clicksearch()
	 {
		 search.click();
	 }
	 public void moveToCardBox()
		{
			
			act.moveToElement(cardsListBox).click().build().perform();
		}
	 
	 
	 
	

}
