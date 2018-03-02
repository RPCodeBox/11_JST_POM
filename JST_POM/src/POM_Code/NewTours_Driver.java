/* Script Name: NewTours_Driver.java
 * Author:	Rana Pratap
 * Data: Jan 2018 Version 1.0 */
package POM_Code;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.testng.annotations.*;
import Library.NewTours_POM;
import Library.Utility;

//New tours driver
public class NewTours_Driver{
	public WebDriver driver;
	String strBrowser = "chrome";
	private StringBuffer verificationErrors = new StringBuffer();
	@BeforeTest //Setup browser
	public void setUp() {
		driver = Utility.SetBrowser(strBrowser);
	}
	@DataProvider(name = "dp") //Test data
	public static Object[][] credentials(){
		return new Object[][] {
			new Object[] { "test1", "test1" }
	    };
	}
	//Verify to register a user
	@Test (dataProvider="dp", groups = {"sample", "Ready" })
	public void TS01_Register(String sUsername, String sPassword) {
		assertTrue(NewTours_POM.Register(driver, sUsername, sPassword));
	}
	//Verify login user from Home page
	@Test (dataProvider="dp", groups = {"sample1", "Ready"})
	public void TS02_LoginHome(String sUsername, String sPassword){
		assertTrue(NewTours_POM.LoginHome(driver, sUsername, sPassword));
	}
	//Verify login from sing-on page
	@Test (dataProvider="dp", groups = {"sample1", "Ready"})
	public void TS03_UserLogin(String sUsername, String sPassword) {
		assertTrue(NewTours_POM.UserLogin(driver, sUsername, sUsername));
	}
	@Test (dataProvider="dp", groups = {"sample1", "Ready"})
	public void TS04_BookFlight(String sUsername, String sPassword) {
		assertTrue(NewTours_POM.BookFlight(driver, sUsername, sPassword));
	}
	@AfterTest //Verify errors and close driver
	public void tearDown(){
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		} 
		driver.quit();
	}
}
