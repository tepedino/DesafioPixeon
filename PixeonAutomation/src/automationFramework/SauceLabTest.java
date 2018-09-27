package automationFramework;

import pageObjects.Saucelabs_Page;

public class SauceLabTest {

	public static void main(String[] args) {
		
		Saucelabs_Page sauceLabs = new Saucelabs_Page();
		
		sauceLabs.openSauceLabs();
		sauceLabs.clickSolution();
		sauceLabs.clickCrossBrowserSetting();
		sauceLabs.clickLeanMore();
		sauceLabs.checkText();		
	}
}