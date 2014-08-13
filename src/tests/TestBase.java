package tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import fw.ApplicationManager;
import utils.Randomizer;

public class TestBase {

	protected static ApplicationManager app;


	@BeforeTest
	public static void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	
	}
	
	

	@AfterTest
	public static void tearDown() throws Exception {
		app.stop();
	}

}