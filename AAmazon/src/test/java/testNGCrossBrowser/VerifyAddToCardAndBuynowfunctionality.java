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
import pompackage.Amazonsignup;
import pompackage.Homepage;
import pompackage.Mobilespeci;
import utils.Utility;

public class VerifyAddToCardAndBuynowfunctionality extends Browser  {

	public WebDriver driver ;
	private Homepage homepage ;
	private Amazonmobile amazonmobile ;
	private Mobilespeci mobilespeci  ;
	private String TestID;
	@Parameters ("browserSelection")
	@BeforeTest
	
	public void ToLaunchBrowser (String browser)
	{ 
		if(browser.equals("Chrome"))
		{		
			driver = openChromeBrowser();
			 
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
	}
	@BeforeMethod 
	public void searchProduct () throws EncryptedDocumentException, IOException
	{
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		homepage.sendkeysproduct(Utility.getExcelSheetData("Amazon", 1, 0));
		homepage.clicksearch();
		
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
	}
	@Test  (priority=1 )
	public void verifyTheBuyProductFunctionality ()    
	{
		TestID="T101";
//mobilespeci = new Mobilespeci (driver);
		mobilespeci.clickbuynow();
	
		String actualurl = driver.getCurrentUrl();
		String expectedURL ="actualurl";
		
		String actualtitle = driver.getTitle();
		String expectedTitle =actualtitle;
		
		SoftAssert soft = new SoftAssert ();
		soft.assertNotEquals(actualurl, expectedURL);
		soft.assertEquals(actualtitle, expectedTitle);
		soft.assertAll();
	}
	@Test 
	public void verifyTheAddToCardFunctionality ()    
	{
		TestID = "T102";
		//mobilespeci = new Mobilespeci (driver);
		mobilespeci.clickaddtocard();
		
		String actualurl = driver.getCurrentUrl();
		String expectedURL ="";
		Assert.assertEquals(actualurl, expectedURL) ;
		
		
		String actualtitle = driver.getTitle();
		String expectedTitle ="";
		
		Assert.assertEquals(actualtitle, expectedTitle);
		
	}
	@AfterMethod 
	public void backToBrowser (ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(TestID,driver);
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
		
	}
	@AfterTest
	public void toCloseBrowser ()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	
		
}
