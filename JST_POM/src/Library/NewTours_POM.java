package Library;

import org.openqa.selenium.*;
import org.testng.Reporter;
import Library.object_dictionary;
import Library.Utility;

public class NewTours_POM{
	public static WebDriver driver;
	public static object_dictionary element = new object_dictionary(); 
	public static Utility utility = new Utility();

	public static boolean UserLogin(WebDriver driver, String username, String password) {
		try {
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("SIGN-ON")).click();
			Reporter.log("POM_Lib.UserLogin: Sign On Page initiated<BR>");
			driver.findElement(By.name(element.txtUserName)).clear();
			driver.findElement(By.name(element.txtUserName)).sendKeys(username);
			driver.findElement(By.name(element.txtPassword)).clear();
			driver.findElement(By.name(element.txtPassword)).sendKeys(password);
			driver.findElement(By.name(element.btnLogin)).click();
			if(driver.getTitle().contains("Find a Flight")){
				driver.findElement(By.linkText(element.lnkSignOff)).click();
				Reporter.log("POM_Lib.UserLogin: Page valid after login<BR>");
				return true;
				}
			else {
				Reporter.log("POM_Lib.UserLogin: Page invalid after login<BR>");
				return false;
			}
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public static boolean Register(WebDriver driver, String username, String password) {
		try {
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("REGISTER")).click();
			Reporter.log("POM_Lib.Register: Register Page initiated<BR>");
			driver.findElement(By.name("firstName")).sendKeys("TestUser");
			driver.findElement(By.name("lastName")).sendKeys("TestUser");
			driver.findElement(By.name("phone")).sendKeys("1800100200");
			driver.findElement(By.id("userName")).sendKeys("testuser@Qualitest.in");
			driver.findElement(By.name("address1")).sendKeys("QualiTest");
			driver.findElement(By.name("address2")).sendKeys("MTP");
			driver.findElement(By.name("city")).sendKeys("Bangalore");
			driver.findElement(By.name("state")).sendKeys("Karnataka");
			driver.findElement(By.name("postalCode")).sendKeys("560025");
			driver.findElement(By.name("email")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("confirmPassword")).sendKeys(password);
			driver.findElement(By.name("register")).click();
			if(driver.getTitle().contains("Register:")){
				Reporter.log("POM_Lib.Register: Page valid after login<BR>");
				driver.findElement(By.linkText("SIGN-OFF")).click();
				return true;
				}
			else {
				Reporter.log("POM_Lib.Register: Page invalid after login<BR>");
				return false;
				}
			}
		catch (Exception ex){
			System.out.println(ex);
			return false;
		}
	}
	public static boolean LoginHome(WebDriver driver, String strUser, String strPassword){
		try{
			driver.get("http://newtours.demoaut.com/");
			Reporter.log("POM_Lib.LoginHome: Home loging Page initiated<BR>");
			driver.findElement(By.name(element.txtUserName)).sendKeys(strUser);
			driver.findElement(By.name(element.txtPassword)).sendKeys(strPassword);
			driver.findElement(By.name(element.btnLogin)).click();
			if(driver.getTitle().contains("Find a Flight:")){
				Reporter.log("POM_Lib.LoginHome: Page valid after login<BR>");
				driver.findElement(By.linkText("ITINERARY")).click();
				driver.findElement(By.linkText("PROFILE")).click();
				driver.findElement(By.linkText("SUPPORT")).click();
				driver.findElement(By.linkText("CONTACT")).click();
				
				driver.findElement(By.linkText("Home")).click();
				driver.findElement(By.linkText("Flights")).click();
				driver.findElement(By.linkText("Hotels")).click();
				driver.findElement(By.linkText("Car Rentals")).click();
				driver.findElement(By.linkText("Cruises")).click();
				driver.findElement(By.linkText("Destinations")).click();
				driver.findElement(By.linkText("Vacations")).click();
				
				driver.findElement(By.linkText(element.lnkSignOff)).click();
				return true;
				}
				Reporter.log("POM_Lib.LoginHome: Page invalid after login<BR>");
				return false;
			}
		catch (Exception ex){
		System.out.println(ex);
		return false;
		}
	}
	public static boolean BookFlight(WebDriver driver, String strUser, String strPassword) {
		try{
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(strUser);
			driver.findElement(By.name("password")).sendKeys(strPassword);
			driver.findElement(By.name("login")).click();
			//Flight details
			Utility.SelectRadioButton("//input[@value='oneway']");
			Utility.SelectDropDown("passCount", "2");
			Utility.SelectDropDown("fromPort", "London");
			Utility.SelectDropDown("toPort", "New York");
			Utility.SelectDropDown("airline", "Unified Airlines");
			Utility.SelectRadioButton("//input[@value='First']");
			driver.findElement(By.name("findFlights")).click();
			//Select Flight
			driver.findElement(By.name("reserveFlights")).click();
			//Passenger Details
			driver.findElement(By.name("passFirst0")).sendKeys("Jim");		
			driver.findElement(By.name("passLast0")).sendKeys("Carrey");		
			driver.findElement(By.name("creditnumber")).sendKeys("76619411823");
			driver.findElement(By.name("buyFlights")).click();
			
			driver.findElement(By.linkText("SIGN-OFF")).click();
			driver.quit();
			return true;
			}
		catch (Exception ex){
		System.out.println(ex);
		return false;
		}
	}
}
