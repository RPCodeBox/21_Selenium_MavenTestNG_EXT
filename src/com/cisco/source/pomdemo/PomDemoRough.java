package com.cisco.source.pomdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PomDemoRough {
	
	private WebDriver driver;
	EventFiringWebDriver eventFiringWebDriver;
	JavascriptExecutor js;
	private String baseUrl;
	

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//baseUrl = "http://wwwin.cisco.com/";
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new WebDriverEventListenerDemo());
		eventFiringWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPomDemo() throws Exception {
		
		HomePage Hp = new HomePage(eventFiringWebDriver);
		SearchResultPage srp = Hp.searchUser();
		WhiteboxTestingPage wtp = srp.openWhiteBoxTesting();
		Thread.sleep(15000);
	}
	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		
	}
	
}
