package com.cisco.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class SeleniumGridDemo {
	
public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) throws MalformedURLException {
		DesiredCapabilities capability=null;
			
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("firefox");
			capability= DesiredCapabilities.firefox();
			capability.setBrowserName("firefox"); 
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			//capability.setVersion("");
		}
	
		if(browser.equalsIgnoreCase("iexplore")){
			System.out.println("iexplore");
			capability= DesiredCapabilities.internetExplorer();
			capability.setBrowserName("iexplore"); 
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			//capability.setVersion("");
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		driver.navigate().to("http://google.com");
		
	}
	
	@Test
	public void test_first() throws InterruptedException{
		Thread.sleep(3000);
		WebElement search_editbox	=	driver.findElement(By.name("q"));
		WebElement search_button	=	driver.findElement(By.name("btnG"));
		search_editbox.clear();
		search_editbox.sendKeys("first");
		search_button.click();
	}
	
	@Test
	public void test_second(){
		WebElement search_editbox	=	driver.findElement(By.name("q"));
		WebElement search_button	=	driver.findElement(By.name("btnG"));
		search_editbox.clear();
		search_editbox.sendKeys("second");
		search_button.click();
	}
	
	@AfterSuite
	public void tearDown(){
        driver.quit();
        driver.close();
	}

}
