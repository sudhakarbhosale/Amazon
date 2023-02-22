package testNGpack;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.Amazonmobile;
import pompackage.CardBox;
import pompackage.Homepage;
import pompackage.Mobilespeci;

public class VerifyTheAddToCardFunctionality {
	private WebDriver driver ;

	@BeforeClass 
	public void ToLaunchBrowser ()
	{ System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 
	 driver = new ChromeDriver ();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@BeforeMethod 
	public void searchProduct ()
	{
		driver.get("https://www.amazon.in/");
	}
	@Test (priority=0)
	public void verifyAddToCardFunctionality ()    
	{
		Homepage homepage = new Homepage(driver);
		homepage.sendkeysproduct("mobile");
		homepage.clicksearch();
		
		Amazonmobile amazonmobile = new Amazonmobile (driver);
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
		
		Mobilespeci mobilespeci = new Mobilespeci (driver);
		
		mobilespeci.clickaddtocard();
		String actualurl = driver.getCurrentUrl();
		String expectedURL ="";
		Assert.assertEquals(actualurl, expectedURL) ;
		
		
		String actualtitle = driver.getTitle();
		String expectedTitle ="";
		
		Assert.assertEquals(actualtitle, expectedTitle);
		
	  
	}
	@Test (priority=1)
	public void verifyCardListBox ()
	{
		Homepage homepage = new Homepage(driver);
		homepage.moveToCardBox();
		CardBox cardBox = new CardBox (driver);
		String mobileDetails = cardBox.getmobileDetail();
		System.out.println(mobileDetails);
		
		String expectdresult ="Samsung Galaxy S20 FE 5G (Cloud Mint, 8GB RAM, 128GB Storage)";
		
		assertEquals(mobileDetails, expectdresult);
	}
	@AfterMethod 
	public void bachToHomePage ()
	{
		
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(0));
		
	}
	@AfterClass 
	public void closeTheBrowser ()
	{
		driver.quit();
	}
	
		
		
		
		
    
 	
	

} 




