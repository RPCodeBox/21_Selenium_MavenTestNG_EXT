package TestScript;

import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import Library.Practice_POM;
import Utilities.BrowserUtility;
import static org.testng.Assert.assertTrue;

public class Automation_Practice {
	public WebDriver driver;
	
	@Test
	public void TS01_ValidLogin() {
		Reporter.log("Scenario: Verify login to application with valid credentials");
		assertTrue(Practice_POM.UserLogin(driver, "testuser1@gmail.com", "testuser1"));
	}

	@BeforeTest //Setup browser
	public void setUp() throws Exception {
		driver = BrowserUtility.SetBrowser();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		//driver.close();
		//Reporter.log("Browser closed");
	}
}
