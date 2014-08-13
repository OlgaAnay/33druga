package fw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverHelperBase extends HelperBase {

	protected WebDriver driver;
	public static boolean acceptNextAlert = true;
	private WebDriverWait wait;

	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
		this.driver = ApplicationManager.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	protected int countElements(By locator) {
		return findElements(locator).size();
	}

	protected void type(By locator, String text) {
		if (text != null || text != "") {
			WebElement element = findElement(locator);
			element.clear();
			element.sendKeys(text);
		}
	}

	protected void click(By locator) {
		findElement(locator).click();
	}

	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(findElement(locator)).selectByVisibleText(text);
		}
	}

	protected void selectByIndex(By locator, int index) {
		if (index != 0) {
			new Select(findElement(locator)).selectByIndex(index);
		}
	}

	protected boolean isElementPresent(By locator) {
		try {
			findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void ctrlF5() {
	      System.out.println("Click CTRL + F5");
	  	
	           Actions builder = new Actions(driver);
	  	  Action reload = 
	  	   builder .sendKeys(Keys.CONTROL,Keys.F5).build();
	  	  reload.perform();	

	  	  System.out.println("Page was refreshed");
	}
	
	protected void captureScreenshot(String name) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "./report/Help/" + screenshot.getName();
			try
			{
				FileUtils.copyFile(screenshot, new File(path));
		    } catch (IOException e) {
		    
		    }
	}
	
	protected String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
