package com.david.test;

import static org.testng.AssertJUnit.assertEquals;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class CiscoSearchWd {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://wwwin.cisco.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCiscoSearchWd() throws Exception {
		driver.get(baseUrl );
		driver.findElement(By.id("c-directory-field")).clear();
		driver.findElement(By.id("c-directory-field")).sendKeys("davisolo");
		driver.findElement(By.id("ext-gen142")).click();
		WebElement wbt = driver.findElement(By.linkText("White Box Testing"));
		wbt.click();
		Thread.sleep(15000);
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		
	}

	
}
