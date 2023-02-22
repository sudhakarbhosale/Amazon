package testNGpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.AccountAndListAndSignIn;
import utils.Utility;

public class VerifyYourOrdersOfAccountAndListFunctionality {
	
	private WebDriver driver ;

	@BeforeClass 
	public void ToLaunchBrowser ()
	{  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 
	 driver = new ChromeDriver ();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@BeforeMethod 
	public void searchProduct ()
	{
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		
	}
	@Test
	public void test () throws IOException
	{
		AccountAndListAndSignIn accountAndListAndSignIn = new AccountAndListAndSignIn (driver);
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
	public void afterMethod()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass ()
	{
		driver.close();
	}
	
	

}
