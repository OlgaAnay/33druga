package tests;


//import org.junit.Test;
import org.testng.annotations.Test;

public class Help extends TestBase {

	  
	  @Test
	  public void testHelp() {
		  
		  app.navigateTo().openMainPage();
	//  try{
		  app.getHelpHelper().assertHeaderElements();
		    
	    System.out.println("Test Help PASSED");		
	//  } catch (Error e) {
	//	System.out.println("failed" + e.toString());
	//	app.getHelpHelper().captureScreen();
	//}
	}
}

