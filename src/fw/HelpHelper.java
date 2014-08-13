package fw;

import static org.junit.Assert.*;


import org.openqa.selenium.By;

import java.util.Random;



public class HelpHelper extends WebDriverHelperBase {

	public HelpHelper(ApplicationManager manager) {
		super(manager);
	}

	public HelpHelper removeContact(int index) {
		if (countContacts() != 0) {
			selectSomeContact(index);
			deleteSelectedContact();
			gotoHomePage();
		}
		return this;
	}

	public int countContacts() {
		return countElements(By.name("selected[]"));
	}

	// -------------------------------------------------------
	public HelpHelper deleteSelectedContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		return this;
	}

	public HelpHelper updateContact() {
		click(By.name("update"));
		return this;
	}

	public HelpHelper selectSomeContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public HelpHelper deleteAllContacts() {
		if (countContacts() != 0) {
			selectContactAndDeleteIt();
		}
		return this;
	}

	public HelpHelper selectContactAndDeleteIt() {
		int w = countContacts();
		System.out.println("Contacts = " + w);
		for (int index = 1; index <= w; index++) {
			click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
			deleteSelectedContact();
			gotoHomePage();
		}
		return this;
	}

	public HelpHelper openAddNew() {
		click(By.linkText("add new"));
		return this;
	}


	public HelpHelper submitEdit() {
		click(By.name("submit"));
		return this;
	}

	public void selectNewGroup() {
		int w = countElements(By.xpath("//select[@name='new_group']/option"));
		System.out.println("How many groups now: " + w);
		Random r = new Random();
		int a = r.nextInt(w) + 1;
		System.out.println(a);
		selectByIndex(By.xpath("//select[@name='new_group']"), a);
	}

	public HelpHelper gotoHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	public void captureScreen() {
		captureScreenshot("testHeader.png");
	}

	public void assertHeaderElements() {
		try{
			assertEquals("Как это работает", findElement(By.xpath("//div[@id=\"page-header\"]/div/div/div/div/div/div[@class=\"region__p-3\"]/div/ul[@class=\"menu__list\"]/li[@class=\"menu__list__item\"]/a[@href=\"/howitworks\"]/span[@class=\"menu__list__item__text\"]")).getText());
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
		} catch(Error e) {
			System.out.println("Some elements were disappeared from Home Page");
	    }
	}
}
