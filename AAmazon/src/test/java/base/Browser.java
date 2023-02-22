package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	public static WebDriver openChromeBrowser ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sudhakar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver ();
		
		return driver ;
	}
	
	public static WebDriver openEdgeBrowser ()
	{
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\Sudhakar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		 
		 WebDriver driver = new EdgeDriver ();
		
		return driver ;
	}

}
