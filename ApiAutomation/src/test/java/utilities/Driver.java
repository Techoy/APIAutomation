package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
	
	private Driver() {}
	
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (ConfigurationReader.getProperty("browser")) {
			case "chrome":
//				WebDriverManager.firefoxdriver().setup();
//				
//				driver = new FirefoxDriver();
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.ANY);
				try {
					driver = new RemoteWebDriver(new URL("http://52.70.143.199:4444/wd/hub"),caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "firefox":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			default:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
