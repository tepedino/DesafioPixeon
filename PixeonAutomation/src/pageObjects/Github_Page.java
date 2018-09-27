package pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Github_Page {

	public static WebDriver driver;

	@FindBy(name = "q")
	public WebElement searchField;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[3]/div/ul/div[1]/div[1]/h3/a")
	public WebElement seleniumHQSeleniumButton;

	@FindBy(xpath = "//td[@class='age']//time-ago")
	public List<WebElement> ageList;
	
	@FindBy(xpath = "//td[@class='content']/span/a")
	public List<WebElement> fileFolderName;


	@FindBy(xpath = "")
	public WebElement leanMoreButton;

	public void openGit() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com");
		PageFactory.initElements(driver, this);
	}

	public void Search(String value) {
		searchField.sendKeys(value);
		searchField.sendKeys(Keys.RETURN);
	}

	public void clickSeleniumHQSelenium(){
		/*try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		seleniumHQSeleniumButton.click();
	}

	@SuppressWarnings("deprecation")
	public void verifyOldestArchive() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		int position = 1;
		try {
			Date date = formatter.parse(ageList.get(position).getAttribute("datetime"));
			Date newDate = null;
			for (int i = 2; i < ageList.size(); i++) {
				newDate = formatter.parse(ageList.get(i).getAttribute("datetime")); 
				if (newDate.compareTo(date) < 0) {
					date = newDate;
					position = i;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("O commit mais antigo foi feito na pasta/arquivo " + fileFolderName.get(position).getText());
		driver.quit();
	}
}