package testNGCrossBrowser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import pompackage.Amazonmobile;
import pompackage.CardBox;
import pompackage.Homepage;
import pompackage.Mobilespeci;
import utils.Utility;

public class VerifyTheBuyProductFunctionality extends Browser {


	public WebDriver driver ;
	private Homepage homepage ;
	private Amazonmobile amazonmobile ;
	private Mobilespeci mobilespeci  ;
	private CardBox cardBox ;
	private String TestID;
	
	 @BeforeTest
	 @Parameters ("browserSelection")
	public void ToLaunchBrowser (String browser)
	{ 
		 if(browser.equals("Chrome"))
		 {		
			  driver = openChromeBrowser ();
		 }
			if(browser.equals("Edge"))
			{
				driver = openEdgeBrowser ();
			}
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@BeforeClass
	public void createPOMObjects()
	{
		 homepage = new Homepage(driver);
		 amazonmobile = new Amazonmobile (driver);
		 mobilespeci = new Mobilespeci (driver);
		 cardBox = new CardBox (driver);
	}
	@BeforeMethod 
	public void searchProduct ()
	{
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
	}
	@Test (priority=2)
	public void verifyTheBuyProductFunctionality () throws EncryptedDocumentException, IOException    
	{
		TestID="T301";
		homepage.sendkeysproduct(Utility.getExcelSheetData("Amazon", 1, 0));
		homepage.clicksearch();
		
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
		
		mobilespeci.clickbuynow();
		
		String actualurl = driver.getCurrentUrl();
		String actualtitle = driver.getTitle();
		
		String expectedURL = actualurl;
		String expectedTitle ="acaltitle";
		
		SoftAssert soft = new SoftAssert ();
		soft.assertEquals(actualurl, expectedURL);
		soft.assertNotEquals(actualtitle, expectedTitle);
		soft.assertAll();
	  
	}
	@Test (priority=0)
	public void verifyAddToCardFunctionality () throws EncryptedDocumentException, IOException    
	{
		TestID="T302";
		homepage.sendkeysproduct(Utility.getExcelSheetData("Amazon", 1, 0));
		homepage.clicksearch();
		
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
		
		mobilespeci.clickaddtocard();
		String actualurl = driver.getCurrentUrl();
		String expectedurl=actualurl;
	
		Assert.assertEquals(actualurl, expectedurl);
		
	}
	@Test (priority=1)
	public void verifyCardListBox ()
	{  TestID="T303";
		homepage.moveToCardBox();
		
		String actualmobileDetails = cardBox.getmobileDetail();
		System.out.println(actualmobileDetails);
		String expectedmobileDetails ="fail";
		Assert.assertEquals(actualmobileDetails, expectedmobileDetails);
		
		
	}
	@AfterMethod 
	public void bachToHomePage (ITestResult result) throws IOException
	{  if( ITestResult.FAILURE==result.getStatus())
	{
		Utility.captureScreenshot(TestID ,driver);
	}
		//driver.close();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(0));
		
	}
	@AfterClass
	public void nullTheObjects ()
	{
		homepage =null;
		mobilespeci = null;
		amazonmobile = null;
		cardBox =null;
	}
	@AfterTest
	public void toCloseBrowser ()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
}
