package browserconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {
	
	public static WebDriver open(String browserName){
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			String driver = ".\\drivers\\chromedriver.exe"; 
			System.setProperty("webdriver.chrome.driver", driver);
			return new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{
			String driver = ".\\drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driver);
			return new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			String driver = ".\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driver);
			return new FirefoxDriver();
		}
	
		else 
		{
			String driver = ".\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driver);
			return new ChromeDriver();
		}
		
	}
	
}
