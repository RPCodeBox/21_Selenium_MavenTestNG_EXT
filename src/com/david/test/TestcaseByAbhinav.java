package com.david.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestcaseByAbhinav {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://wwwin.cisco.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testIngTestAutomation() throws Exception {
		driver.get(baseUrl + "it/qa/index.shtml");
		driver.findElement(By.id("ext-gen347")).click();
		assertEquals("Testing / Test Automation - CEC - Cisco Confidential", driver.getTitle());
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		driver.findElement(By.id("ext-gen7")).click();
		assertEquals("Test Automation - CEC - Cisco Confidential", driver.getTitle());
		driver.findElement(By.xpath("(//a[contains(text(),'Testing / Test Automation')])[3]")).click();
		driver.findElement(By.id("ext-gen6")).click();
		driver.findElement(By.id("referringpage")).click();
		driver.findElement(By.id("ext-gen16")).click();
		assertEquals("Functional Testing Component", driver.findElement(By.id("ext-gen16")).getText());
		driver.findElement(By.id("ext-gen17")).click();
		assertEquals("Managing Functional Testing", driver.findElement(By.id("ext-gen17")).getText());
		driver.findElement(By.id("ext-gen18")).click();
		assertEquals("Functional Testing Matrix", driver.findElement(By.id("ext-gen18")).getText());
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		driver.findElement(By.id("ext-gen8")).click();
		assertEquals("Return to Top", driver.findElement(By.id("ext-gen8")).getText());
		driver.findElement(By.id("ext-gen10")).click();
		assertEquals("Return to Top", driver.findElement(By.id("ext-gen8")).getText());
		assertEquals("Return to Top", driver.findElement(By.id("ext-gen10")).getText());
		assertEquals("Return to Top", driver.findElement(By.id("ext-gen15")).getText());
		driver.findElement(By.id("ext-gen15")).click();
		driver.findElement(By.id("ext-gen11")).click();
		driver.findElement(By.id("referringpage")).click();
		driver.findElement(By.id("ext-gen13")).click();
		assertEquals("Test Automation - CEC - Cisco Confidential", driver.getTitle());
		driver.findElement(By.xpath("(//a[contains(text(),'Testing / Test Automation')])[3]")).click();
		driver.findElement(By.id("ext-gen12")).click();
		assertEquals("QualityCenter - CEC - Cisco Confidential", driver.getTitle());
		driver.findElement(By.id("ext-gen84")).click();
		driver.findElement(By.id("ext-gen14")).click();
		assertEquals("WinRunner / QuickTest Professional - CEC - Cisco Confidential", driver.getTitle());
		driver.findElement(By.id("ext-gen72")).click();
		assertEquals("Testing / Test Automation - CEC - Cisco Confidential", driver.getTitle());
		driver.close();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
