package com.cisco.source.pomdemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PomDemo {
	
	private WebDriver driver;
	JavascriptExecutor js;
	private String baseUrl;
	

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//baseUrl = "http://wwwin.cisco.com/";
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set s = driver.getWindowHandles();
		
		Iterator i = s.iterator();
		
	}

	@Test
	public void testPomDemo() throws Exception {
		
		HomePage Hp = new HomePage(driver);
	
		SearchResultPage srp = Hp.searchUser();
		WhiteboxTestingPage wtp = srp.openWhiteBoxTesting();
		Thread.sleep(15000);
	}
	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		
	}
	
}
