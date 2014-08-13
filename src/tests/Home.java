package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.*;


public class Home {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private WebDriverBackedSelenium selenium;

	  /*report*/
	  static File file = new File("D:/workspace/33druga/report/Home/Home.txt");
	  static FileOutputStream fstr;
	  static String newLine = "\n";
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://33druga.ru/home/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    selenium = new WebDriverBackedSelenium(driver, baseUrl);
	    
	  }

	  @Test
	  public void testHome() throws Exception {
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
        		Thread.sleep(1500);
				selenium.waitForPageToLoad("1500");
		    	assertEquals("33Friends - Home", driver.getTitle());
		    	
		    }catch(Error e){
		    	verificationErrors.append("Cant open Home");
		    }
		    try{
		    	driver.switchTo().defaultContent();
		    	driver.switchTo().frame(2);
		    	
		    	driver.findElement(By.cssSelector("div form[id=\"u_0_1\"] div[class=\"pluginConnectButton\"] div[class] div div[class=\"pluginButtonContainer\"] span")).click();
		    	
		    	driver.findElement(By.cssSelector("div[class=\"pluginConnectButton\"] div[class] div div[class=\"pluginButtonContainer\"] span")).click();
		    	String winHandleBefore = driver.getWindowHandle();
		    	for(String winHandle : driver.getWindowHandles()){
		    		driver.switchTo().window(winHandle);
		    	}
		    	String title = driver.getTitle();
		    	System.out.println("title: "+title);
		    	assertEquals("Facebook", driver.getTitle());
		    	driver.close();
		    	driver.switchTo().window(winHandleBefore);
		    	assertEquals("33Friends - Home", driver.getTitle());

		    	title = driver.getTitle();
		    	System.out.println("title: "+title);
		    }catch (Error e){
			      verificationErrors.append("Like doesn't work");	
		    }
		    driver.switchTo().defaultContent();
	           
		    try
		    {
		    	driver.switchTo().frame(2);
		    	//driver.findElement(By.cssSelector("div form[id=\"u_0_1\"] div[class=\"pluginConnectButton\"] div[class]")).click();
		    	driver.findElement(By.cssSelector("div[class=\"pluginButton\"] div div span[class=\"pluginButtonLabel\"]")).click();
		    	String winHandleBefore = driver.getWindowHandle();
		    	for(String winHandle : driver.getWindowHandles()){
		    		driver.switchTo().window(winHandle);
		    	}
	    	
		    	String title = driver.getTitle();
		    	System.out.println("title: "+title);
		    	assertEquals("Facebook", driver.getTitle());
		    	driver.close();
		    	driver.switchTo().window(winHandleBefore);
		    	assertEquals("33Friends - Home", driver.getTitle());
		    }catch (Error e){
		    	verificationErrors.append("Share doesn't work");	
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from Home Page");
		    }
		    

		    try
		    {
		    	driver.findElement(By.cssSelector("img[alt=\"33 друга\"]")).click();
		    	assertEquals("33Friends - Home", driver.getTitle());
		        try {
		            assertTrue(driver.getCurrentUrl().matches("^https://33druga\\.ru/home[\\s\\S]home=true$"));
		            } catch (Error e) {
		            verificationErrors.append("URL of Home Page != https://33druga.ru/home?home=true");
		          }

		    }catch(Error e){
		    	verificationErrors.append("Cant open 33friends link");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from Home Page");
		    }
		    driver.switchTo().defaultContent();
	           driver.switchTo().frame(2);
	           try {
				      assertEquals("Sign Up", driver.findElement(By.xpath("//span/a[@target=\"_blank\"]")).getText());
				    } catch (Error e) {
				      verificationErrors.append("Sign up disappeared");
				      System.out.println("Sign up disappeared");
				    }
	        driver.switchTo().defaultContent();
		    try
		    {
		    	driver.findElement(By.cssSelector("span.menu__list__item__text")).click();
		    	assertEquals("33Friends", driver.getTitle());
		        try {
		            assertEquals("https://33druga.ru/howitworks", driver.getCurrentUrl());
		          } catch (Error e) {
		            verificationErrors.append("URL of howitworks != https://33druga.ru/howitworks ");
		          }		    	
		    }catch(Error e){
		    	verificationErrors.append("Cant open howitworks");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from howitworks");
		    }
		    try
		    {
		    	driver.findElement(By.xpath("//div[@id='page-header']/div/div/div/div/div/div[3]/div/ul/li[2]/a/span")).click();
		    	assertEquals("33Friends", driver.getTitle());
		        try {
		            assertEquals("https://33druga.ru/merchants", driver.getCurrentUrl());
		          } catch (Error e) {
		            verificationErrors.append("URL of merchants != https://33druga.ru/merchants ");
		          }		 
		    }catch(Error e){
		    	verificationErrors.append("Cant open https://33druga.ru/merchants");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from merchants");
		    }
		    try
		    {
		    driver.findElement(By.cssSelector("div.logo-2 > a > img[alt=\"33 друга\"]")).click();
		    assertEquals("33Friends - Home", driver.getTitle());
		    	try {
		    		assertTrue(driver.getCurrentUrl().matches("^https://33druga\\.ru/home[\\s\\S]home=true$"));
		    	} catch (Error e) {
		    		verificationErrors.append("URL of Home Page != ^https://33druga\\.ru/home[\\s\\S]home=true$");
		    	}
		    }catch(Error e){
		    	verificationErrors.append("Cant open  footer link of home page");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from footer link of home page");
		    }
		    try
		    {
		    driver.findElement(By.xpath("//div[@id='page-footer']/div/div/div/div/div/div[2]/div/ul/li/a/span")).click();
		    assertEquals("33Friends", driver.getTitle());
	    		try {
	    			assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/useragreement"));
	    		} catch (Error e) {
	    			verificationErrors.append("URL of useragreement != https://33druga.ru/useragreement");
	    		}
		    }catch(Error e){
		    	verificationErrors.append("Cant open useragreement ");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from useragreement");
		    }
		    try
		    {
		        driver.findElement(By.linkText("Условия договора-оферты")).click();
		        assertEquals("33Friends", driver.getTitle());
	    		try 
	    		{
	    			assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/offer"));
	    		} catch (Error e) {
	    			verificationErrors.append("URL of offer != https://33druga.ru/offer");
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
					driver.switchTo().defaultContent();   
			    }catch(Error e){
			    	verificationErrors.append("Some elements were diappeared from offer");
			    }
				driver.navigate().back();
				assertEquals("33Friends", driver.getTitle());	   
		    }catch(Error e){
		    	verificationErrors.append("Cant open Условия договора-оферты ");
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from Home Page");
		    }
		    try
		    {
		    driver.findElement(By.xpath("//div[@id='page-footer']/div/div/div/div/div/div[2]/div/ul/li[2]/a/span")).click();
		    assertEquals("33Friends", driver.getTitle());
    		try {
    			assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/about"));
    		} catch (Error e) {
    			verificationErrors.append("URL of about != https://33druga.ru/about");
    		}
		    }catch (Error e){
		    	verificationErrors.append("Cant open about ");		    	
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from about");
		    }
		    try
		    {
		    driver.findElement(By.xpath("//div[@id='page-footer']/div/div/div/div/div/div[2]/div/ul/li[3]/a/span")).click();
		    assertEquals("33Friends", driver.getTitle());
    			try {
    				assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/contact"));
    			} catch (Error e) {
    				verificationErrors.append("URL of contact != https://33druga.ru/contact");
    			}		    		    
	    	}catch (Error e){
	    		verificationErrors.append("Cant open contacts ");		    	
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from contact");
		    }
		    try
		    {
		    driver.findElement(By.xpath("//div[@id='page-footer']/div/div/div/div/div/div[2]/div/ul/li[4]/a/span")).click();
		    assertEquals("33Friends", driver.getTitle());
  				try {
  					assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/privacy"));
  				} catch (Error e) {
  					verificationErrors.append("URL of privacy != https://33druga.ru/privacy");
  				}				    
		    }catch (Error e){
	    		verificationErrors.append("Cant open privacy ");		    			    	
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
				driver.switchTo().defaultContent();   
		    }catch(Error e){
		    	verificationErrors.append("Some elements were diappeared from privacy");
		    }
		    try{
		    	String winHandleBefore = driver.getWindowHandle();
		    	
		    	driver.findElement(By.linkText("Скачать в формате PDF")).click();
	    		
		    	for(String winHandle : driver.getWindowHandles()){
		    	
		    	driver.switchTo().window(winHandle);
		    	}
		    	
		    	assertEquals("privacy.pdf", driver.getTitle());
				assertTrue(driver.getCurrentUrl().matches("https://33druga.ru/img/privacy.pdf"));
		        driver.findElement(By.cssSelector("div.annotationLayer > a")).click();
		        assertEquals("33Friends - Home", driver.getTitle());
		    	driver.close();
		    	driver.switchTo().window(winHandleBefore);

		    }catch(Error e){
	    		verificationErrors.append("Cant open Скачать в формате PDF ");	    		
		    }
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

	           
		    driver.switchTo().defaultContent();

	    System.out.println("Test Home_links PASSED");		
	}catch (Error e){
		verificationErrors.append("Test Home_links Failed" + e.toString());
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

	  private void captureScreenshot(String name)
	  {
		File screenshot = ((TakesScreenshot) driver)
		.getScreenshotAs(OutputType.FILE);
		String path = "./report/Home/" + screenshot.getName();
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

