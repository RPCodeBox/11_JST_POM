package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Practice_POM {
	public static WebDriver driver;
	//public static object_dictionary element = new object_dictionary();
	public static Utility utility = new Utility();

	public static boolean UserLogin(WebDriver driver, String username, String password) {
		driver.get("http://automationpractice.com/index.php");

		WebElement SignIn = driver.findElement(By.linkText("Sign in"));
		utility.highLightElement(SignIn);
		SignIn.click();

		WebElement email = driver.findElement(By.id("email"));
		WebElement passwd = driver.findElement(By.id("passwd"));
		WebElement SubmitLogin = driver.findElement(By.id("SubmitLogin"));
		utility.highLightElement(email);
		email.sendKeys("testuser1@gmail.com");
		utility.highLightElement(passwd);
		passwd.sendKeys("testuser1");
		utility.highLightElement(SubmitLogin);
		SubmitLogin.click();

		WebElement SignOut = driver.findElement(By.linkText("Sign out"));
		if (SignOut.isDisplayed()) {
			utility.highLightElement(SignOut);
			SignOut.click();
			Reporter.log("POM_Lib.UserLogin: Page valid after login<BR>");
			return true;
		} else {
			Reporter.log("POM_Lib.UserLogin: Page invalid after login<BR>");
			return false;
		}
	}

}
