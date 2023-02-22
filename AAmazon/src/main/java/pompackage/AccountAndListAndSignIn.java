package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountAndListAndSignIn {
	
	private WebDriver driver ;
	private 	Actions act ;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountandList ;
	
	@FindBy(xpath="//span[text()='Your Orders']")
	private WebElement yourorders ;
	
	@FindBy(xpath="//span[text()='Your Account']")
	private WebElement yourAccount;
	
	@FindBy(xpath="//span[text()='Your Wish List']")
	private WebElement yourWishList ;
	
	 public AccountAndListAndSignIn (WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver =driver;
		  act = new Actions (driver);
	 }
	
	 public void moveToaccountandListYourOrders()
	 {
			
			act.moveToElement(accountandList).moveToElement(yourorders).click().build().perform();
	 }
	 public void moveToaccountandListYourAccount()
	 {
			
			act.moveToElement(accountandList).moveToElement(yourAccount).click().build().perform();
	 }
	 public void moveToaccountandListyourWishList()
	 {
			
			act.moveToElement(accountandList).moveToElement(yourWishList).click().build().perform();
	 }

}
