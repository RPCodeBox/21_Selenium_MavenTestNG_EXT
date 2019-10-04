package com.david.test;
import org.testng.annotations.*;


import com.thoughtworks.selenium.*;

import org.testng.annotations.*;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import java.io.File;
import java.util.regex.Pattern;


import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class CiscoSearchDP extends SeleneseTestCase{
	
		HttpCommandProcessor proc;
		SeleniumServer server ;
		RemoteControlConfiguration rcc ;
		Selenium selenium;
		
		@BeforeTest
		public void setUp() throws Exception {

		rcc = new RemoteControlConfiguration();
		//File userExtn = new File("C:\\david\\selenium-remote-control-1.0.3\\selenium-server-1.0.3\\user-extensions.js");

		//rcc.setUserExtensions(userExtn);
		
		proc = new HttpCommandProcessor("localhost", 4444, "*chrome", "http://wwwin.cisco.com");
		selenium = new DefaultSelenium(proc);
		server = new SeleniumServer(false, rcc);
		server.boot();
		server.start();
		selenium.start();
		}

	
	@org.testng.annotations.Test(dataProvider = "test1")
	public void testCiscoSearch(String searchStr) throws Exception {
		
		selenium.open("/");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=c-directory-field", searchStr);
		selenium.click("id=ext-gen142");
		selenium.waitForPageToLoad("30000");
		if (searchStr.equalsIgnoreCase("davisolo"))
		{
		assertTrue(selenium.isTextPresent("David Thangaraj Solomon Raja"));
		assertTrue(selenium.isTextPresent("8861583888"));
		assertTrue(selenium.isTextPresent("Rajkumar Gell (rgell)"));
		verifyEquals(selenium.getText("link=Shell Scripting"), "Shell Scripting");
		verifyEquals(selenium.getText("xpath=/html/body/div[12]/div[2]/div/div/div[4]/div[4]/div/div/table/tbody/tr/td/table/tbody/tr/td/a"), "Selenium Automation");
		}
		else  {
			
			assertTrue(selenium.isTextPresent("Diana Antonykurus"));
			assertTrue(selenium.isTextPresent("9731061025"));
			assertTrue(selenium.isTextPresent("Anand Raghava (anaragha)"));
			verifyEquals(selenium.getText("link=Oracle Workflow Builder"), "Oracle Workflow Builder");
			verifyEquals(selenium.getText("xpath=/html/body/div[12]/div[2]/div/div/div[4]/div[4]/div/div/table/tbody/tr/td/table/tbody/tr/td/a"), "Oracle Certified Associate");
			
		}
	}
	
	
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "davisolo" },
	   { "dantonyk"},
	 };
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		selenium.stop();
		server.stop();
	}

}
