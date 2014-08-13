package fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (!onMainPage()) {
			click(By.id(""));
		}
	}
	
	public void openMainPage() {
		openURL("http://33amis.com/home/");
	}
	
	private boolean onMainPage() {
		return countElements(By.id("popUp")) > 0;
	}

	public void groupsPage() {
		if (!onGroupPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupPage() {
		String currentURL = getCurrentUrl();
		findElements(By.name("new"));
		return (currentURL.contains("/group.php") && findElements(
				By.name("new")).size() > 0);
	}
}
