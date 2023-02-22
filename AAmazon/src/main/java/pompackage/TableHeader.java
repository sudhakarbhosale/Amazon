package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableHeader {
	
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	private WebElement all ;
	
	@FindBy(xpath="//a[text()='Sell']")
	private WebElement sell ;
	
	@FindBy(xpath="(//a[text()='Best Sellers'])[1]")
	private WebElement bestseller ;
	
	@FindBy(xpath="(//a[text()='Mobiles'])[1]")
	private WebElement mobiles ;
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountandList ;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	private WebElement ruturnAndOrders ;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	private WebElement cards ;

	public TableHeader (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void a()
	{
		
	}
	
}
