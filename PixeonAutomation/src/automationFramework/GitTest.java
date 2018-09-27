package automationFramework;

import pageObjects.Github_Page;

public class GitTest {

	public static void main(String[] args) {

		Github_Page git = new Github_Page();

		git.openGit();
		git.Search("Selenium");
		git.clickSeleniumHQSelenium();
		git.verifyOldestArchive();		
	}
}