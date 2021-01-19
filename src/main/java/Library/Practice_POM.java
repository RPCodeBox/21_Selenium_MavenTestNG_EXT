package Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import ObjectLibrary.PracticeLoginPage;
import Utilities.BrowserUtility;


public class Practice_POM {
	//public static WebDriver driver;
	BrowserUtility util = new BrowserUtility();
	
	public static boolean UserLogin(WebDriver driver, String username, String password) {
		PracticeLoginPage loginPage = PageFactory.initElements(driver, PracticeLoginPage.class);
		
		driver.get("http://automationpractice.com/index.php");
		Reporter.log("UserLogin: Navigated to application<BR>");
		BrowserUtility.highLightElement(loginPage.SignIn);
		loginPage.SignIn.click();

		Reporter.log("UserLogin: Navigated to Login page<BR>");
		
		loginPage.EnterUserName("testuser1@gmail.com");
		loginPage.EnterPassword("testuser1");
		BrowserUtility.highLightElement(loginPage.SubmitLogin);
		loginPage.SubmitLogin.click();
		Reporter.log("UserLogin: Login with valid credentials<BR>");

		if (loginPage.SignOut.isDisplayed()) {
			BrowserUtility.highLightElement(loginPage.SignOut);
			loginPage.SignOut.click();
			Reporter.log("UserLogin: Page valid after login<BR>");
			return true;
		} else {
			Reporter.log("UserLogin: Page invalid after login<BR>");
			return false;
		}
	}
}
