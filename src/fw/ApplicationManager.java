package fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	protected static WebDriver driver;
	public static String baseUrl;
	
	private static NavigationHelper navigationHelper;
	
	private static Properties properties;
	private HelpHelper helpHelper;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		
	}
	
	 public void stop() {
		driver.quit(); 
	 }


	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}

	public HelpHelper getHelpHelper() {
		if (helpHelper == null) {
			helpHelper = new HelpHelper(this);
		}
		return helpHelper;
	}

	public static WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)) {
				driver = new FirefoxDriver();
			} else if ("ie".equals(browser)) {
				driver = new InternetExplorerDriver();
			} else {
				throw new Error("Unsupported browser" + browser);
			}

			baseUrl = properties.getProperty("baseURL");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl);
		}
		return driver;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
