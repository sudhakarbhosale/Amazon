package testNGpack;

import java.util.ArrayList;
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
import org.testng.asserts.SoftAssert;

import pompackage.Amazonmobile;
import pompackage.CardBox;
import pompackage.Homepage;
import pompackage.Mobilespeci;

public class VerifyTheBuyProductFunctionality {

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
	@Test 
	public void verifyTheBuyProductFunctionality ()    
	{
		Homepage homepage = new Homepage(driver);
		homepage.sendkeysproduct("mobile");
		homepage.clicksearch();
		
		Amazonmobile amazonmobile = new Amazonmobile (driver);
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
		
		Mobilespeci mobilespeci = new Mobilespeci (driver);
		
		mobilespeci.clickbuynow();
		
		String Actualurl = driver.getCurrentUrl();
		String actualtitle = driver.getTitle();
		
		String expectedURL = "";
		String expectedTitle ="Amazon Sign In";
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(Actualurl, expectedURL);
		soft.assertEquals(actualtitle, expectedTitle);
		soft.assertAll();
	}
	
	@AfterMethod 
	public void bachToHomePage ()
	{
		//driver.close();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(0));
		
	}
	@AfterClass 
	public void closeTheBrowser ()
	{
		driver.quit();
	}
	
		

}
