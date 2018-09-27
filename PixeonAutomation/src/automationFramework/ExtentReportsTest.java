package automationFramework;

import pageObjects.ExtentReports_Page;

public class ExtentReportsTest {

	public static void main(String[] args) {
		
		ExtentReports_Page extentReports = new ExtentReports_Page();
		
		extentReports.openExtentReports();
		extentReports.clickJava();
		//extentReports.clickDotNet();
		extentReports.checkOfflineReportProVersion();		
	}
}