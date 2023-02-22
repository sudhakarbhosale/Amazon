package testNGpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.Amazonmobile;
import pompackage.Amazonsignup;
import pompackage.Homepage;
import pompackage.Mobilespeci;

public class VerifyAddToCardAndBuynowfunctionality {

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
		Homepage homepage = new Homepage(driver);
		homepage.sendkeysproduct("mobile");
		homepage.clicksearch();
		Amazonmobile amazonmobile = new Amazonmobile (driver);
		amazonmobile.clickmobile();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(1));
	}
	@Test  (priority=1 )
	public void verifyTheBuyProductFunctionality ()    
	{
		Mobilespeci mobilespeci = new Mobilespeci (driver);
		mobilespeci.clickbuynow();
	
		String url = driver.getCurrentUrl();
		String expectedURL ="";
		
		String title = driver.getTitle();
		String expectedTitle ="";
		if(expectedURL.equals(url) && expectedTitle.equals(title) )
		{
			System.out.println("test pass");
		}
		else
		{
			System.out.println("test case fail");
		}
	}
	@Test 
	public void verifyTheAddToCardFunctionality ()    
	{
		Mobilespeci mobilespeci = new Mobilespeci (driver);
		mobilespeci.clickaddtocard();
		
		String url = driver.getCurrentUrl();
		String expectedURL ="";
		
		String title = driver.getTitle();
		String expectedTitle ="";
		if(expectedURL.equals(url) && expectedTitle.equals(title) )
		{
			System.out.println("test pass");
		}
		else
		{
			System.out.println("test case fail");
		}
	}
	@AfterMethod 
	public void backToBrowser ()
	{
		//driver.close();
		ArrayList<String> adds= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(adds.get(0));
		
	}
	@AfterClass
	public void closeBrowser ()
	{
		driver.quit();
	}
	
		
}
