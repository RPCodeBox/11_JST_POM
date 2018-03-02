package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	public static WebDriver driver;
	
	public static WebDriver SetBrowser(String strBrowser){
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","lib\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "lib\\IEDriverServer.exe");
		if(strBrowser.equalsIgnoreCase("CHROME")){
			driver = new ChromeDriver();
		} else if(strBrowser.equalsIgnoreCase("FIREFOX")){
			driver = new FirefoxDriver();
		} else if(strBrowser.equalsIgnoreCase("IE")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	public static void SelectDropDown(String ddObject, String Value){
		Select Object = new Select(driver.findElement(By.name(ddObject)));
		Object.selectByVisibleText(Value);
	}
	public static void SelectRadioButton(String RDObject){
		WebElement radio1 = driver.findElement(By.xpath(RDObject));
		radio1.click();
	}
}
