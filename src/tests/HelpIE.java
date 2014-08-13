package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HelpIE {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private WebDriverBackedSelenium selenium;

	  /*report*/
	  static File file = new File("D:/workspace/33druga/report/Help/HelpIE.txt");
	  static FileOutputStream fstr;
	  static String newLine = "\n";
	  
	  @Before
	  public void setUp() throws Exception {
		  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		  caps.setCapability(
	          InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
		      true);
		driver = new InternetExplorerDriver(caps);
	    baseUrl = "http://33druga.ru/home/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    selenium = new WebDriverBackedSelenium(driver, baseUrl);
	    
	  }

	  @Test
	  public void testHelpIE() throws Exception {
	try{
		File dir = file.getParentFile();
		if(false == file.exists())
		{
		dir.mkdir();
		}
		fstr = new FileOutputStream(file);
	  try{
		    try
		    {
		    	driver.get(baseUrl);
		    	assertEquals("33Friends - Home", driver.getTitle());
		    	
		    }catch(Error e){
		    	verificationErrors.append("33druga");
		    }
		    try{
		    	assertTrue(isElementPresent(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div/div/a[@href=\"/home?home=true\"]/img[@alt=\"33 друга\"]")));
		    	assertEquals("Как это работает", driver.findElement(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div[@class=\"region__p-3\"]/div/ul[@class=\"menu__list\"]/li[@class=\"menu__list__item\"]/a[@href=\"/howitworks\"]/span[@class=\"menu__list__item__text\"]")).getText());
		    	assertEquals("Магазины", driver.findElement(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div[@class=\"region__p-3\"]/div/ul[@class=\"menu__list\"]/li[@class=\"menu__list__item\"][2]/a[@href=\"/merchants\"]/span[@class=\"menu__list__item__text\"]")).getText());
		    	assertEquals("Зарегистрироваться", driver.findElement(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div[@class=\"region__p-3\"]/div[@class=\"menu-2\"]/ul/li/a[@href=\"#login\"]/span")).getText());
		    	assertEquals("Войти", driver.findElement(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div[@class=\"region__p-3\"]/div[@class=\"menu-2\"]/ul/li[2]/a[@href=\"#login\"]/span")).getText());
		    	assertTrue(isElementPresent(By.xpath("//div[@id=\"page-footer\"]/div/div/div/div/div/div/div/a[@href=\"/home?home=true\"]/img[@alt=\"33 друга\"]")));
		    	assertEquals("Пользовательское соглашение", driver.findElement(By.xpath("//div[@id=\"page-footer\"]/div/div/div/div/div/div[2]/div/ul/li/a/span[@class=\"menu__list__item__text\"]")).getText());
		    	assertEquals("О нас", driver.findElement(By.xpath("//div[@id=\"page-footer\"]/div/div/div/div/div/div[@class=\"region__p-2\"]/div/ul/li[2]/a[@href=\"/about\"]/span[@class=\"menu__list__item__text\"]")).getText());
		    	assertEquals("Свяжитесь с нами", driver.findElement(By.xpath("//div[@id=\"page-footer\"]/div/div/div/div/div/div[@class=\"region__p-2\"]/div/ul/li[3]/a/span")).getText());
		    	assertEquals("Безопасность", driver.findElement(By.xpath("//div[@id=\"page-footer\"]/div/div/div/div/div/div[@class=\"region__p-2\"]/div/ul/li[4]/a/span")).getText());
		    	
		    	driver.switchTo().defaultContent();
		           driver.switchTo().frame(2);
		           assertTrue(isElementPresent(By.xpath("//div[@class=\"pluginButton pluginButtonInline pluginConnectButtonDisconnected\" and @title=\"Like\"]")));
		           assertTrue(isElementPresent(By.xpath("//div[@class=\"pluginConnectButton\"]")));
		        
		           try {
		        	   assertEquals("Like", driver.findElement(By.xpath("//span[@class=\"pluginButtonLabel\"]")).getText()); 
		           } 
		           catch (Error e) {
		        	   verificationErrors.append("Like != Like");
		           }	
		           try {
		        	   assertEquals("Share", driver.findElement(By.xpath("//div[@class=\"pluginButton\"]/div/div[@class=\"pluginButtonContainer\"]/span[@class=\"pluginButtonLabel\"]")).getText());
		           } catch (Error e) {
		        	   verificationErrors.append("Share != Share");
		           } 
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from Home Page");
		    }
		    driver.switchTo().defaultContent();   
		    driver.findElement(By.xpath("//a[@class=\"circle__icon\"]")).click();
		    assertEquals("33Friends - Home", driver.getTitle());
		    ctrlF5();
		    if (selenium.isElementPresent("//a[@class=\"circle__icon\"]") && selenium.isVisible("//a[@class=\"circle__icon\"]")) 
		    { 
		    	System.out.println("? is here");
		    }
		    else
		    {	
		    	verificationErrors.append("? disappeared");
		    }
	    System.out.println("TestIE Help PASSED");		
	}catch (Error e){
		verificationErrors.append("TestIE Help Failed" + e.toString());
		System.out.println("failed" + e.toString());
		captureScreenshot("test.png");
	}
		fstr.close();	  
	}catch (IOException e){
		verificationErrors.append("Failed" + e.toString());
		System.out.println("failed" + e.toString());
		captureScreenshot("test.png");
	}
	}
	  public void ctrlF5()
	  {
	      System.out.println("Click CTRL + F5");
	  	
	           Actions builder = new Actions(driver);
	  	  Action reload = 
	  	   builder .sendKeys(Keys.CONTROL,Keys.F5).build();
	  	  reload.perform();	

	  	  System.out.println("Page was refreshed");
	  }
	  private void captureScreenshot(String name)
	  {
		File screenshot = ((TakesScreenshot) driver)
		.getScreenshotAs(OutputType.FILE);
		String path = "./report/Help/" + screenshot.getName();
			try
			{
				FileUtils.copyFile(screenshot, new File(path));
		    } catch (IOException e) {
		    
		    }
	  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }


}

