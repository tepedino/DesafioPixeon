package pageObjects;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtentReports_Page {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/div[2]/section/div/div/div/p[1]/a[1]")
    public WebElement javaButton;
	
	@FindBy(xpath = "/html/body/div/div[2]/section/div/div/div/p[1]/a[2]")
    public WebElement dotNetButton;
	
	@FindBy(xpath = "//a[contains(text(),'Offline report')]/../../td[3]/i")
	public WebElement OfflineReportPro;

	
	 public void openExtentReports() {
	        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://extentreports.com/");
	        PageFactory.initElements(driver, this);
	    }
	
	public void clickJava() {
		javaButton.click();
    }
	
	public void clickDotNet() {
		dotNetButton.click();
    }
	
    public void checkOfflineReportProVersion() {
        Assert.assertThat(OfflineReportPro.getAttribute("class"), CoreMatchers.containsString("success"));
        driver.quit();
        
    }


}