package pageObjects;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucelabs_Page {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[3]/div/div/div[2]/div[1]/span")
    public WebElement solutionsButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[4]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/a")
    public WebElement crossBrowserTestingButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/section/div[1]/div/div[2]/div/div[2]/div/p[2]/a")
    public WebElement leanMoreButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/section/div[2]/div/div[1]/h2")
    public WebElement seleniumText;
	
	 public void openSauceLabs() {
	        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://saucelabs.com/");
	        PageFactory.initElements(driver, this);
	    }
	
	public void clickSolution() {
        solutionsButton.click();
    }
	
	public void clickCrossBrowserSetting(){
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		crossBrowserTestingButton.click();
	}
	
    public void clickLeanMore() {
        leanMoreButton.click();
    }

    public void checkText() {
        Assert.assertThat(seleniumText.getText(), CoreMatchers.containsString("Run Selenium tests securely in the cloud"));
        driver.quit();
        
    }


}