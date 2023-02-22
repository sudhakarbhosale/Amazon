package testNGCrossBrowser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import base.Browser;
import pompackage.AccountAndListAndSignIn;
import utils.Utility;

public class VerifyYourOrderAndAccountFuntcionality extends Browser{
	public WebDriver driver ;
	private AccountAndListAndSignIn accountAndListAndSignIn ;
	private String TestID ;

	 @BeforeTest
	 @Parameters ("browserSelection")
	public void ToLaunchBrowser (String browser)
	{ 
		 if(browser.equals("Chrome"))
		 {		
			 
			driver=openChromeBrowser ();	
		 }
			if(browser.equals("Edge"))
			{
				driver = openEdgeBrowser ();
			}
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	 @BeforeClass 
	 public void createPOMObjects ()
	 {
		  accountAndListAndSignIn = new AccountAndListAndSignIn (driver);
	 }
	@BeforeMethod 
	public void searchProduct ()
	{
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		
	}
	@Test
	public void test () 
	{ TestID="T401";
   	//	AccountAndListAndSignIn accountAndListAndSignIn = new AccountAndListAndSignIn (driver);
		accountAndListAndSignIn.moveToaccountandListYourAccount();
		String actualtitle = driver.getTitle();
		String expectedtitle ="Your Account";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://www.amazon.in/gp/css/homepage.html?ref_=nav_AccountFlyout_ya";
		Assert.assertEquals(actualurl, expectedurl);
		
		boolean result = actualtitle.equals(expectedtitle);
		
		Assert.assertTrue(result);
		
	}
	@AfterMethod 
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus() )
		{
			Utility.captureScreenshot(TestID, driver);
		}
		
	}
	@AfterClass
	public void nullTheObjects ()
	{
		accountAndListAndSignIn=null ;
	}
	
	@AfterTest
	public void closeTheBrowser ()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	


}
