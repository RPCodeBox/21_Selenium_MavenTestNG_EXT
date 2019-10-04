package com.david.test;

import org.testng.annotations.*;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import java.io.File;
import java.util.regex.Pattern;


import static org.testng.Assert.*;
import java.util.regex.Pattern;



public class DSRDownloadSel extends SeleneseTestCase{

	HttpCommandProcessor proc;
	SeleniumServer server ;
	RemoteControlConfiguration rcc ;

	@Before
	public void setUp() throws Exception {

	rcc = new RemoteControlConfiguration();
	//File userExtn = new File("C:\\david\\selenium-remote-control-1.0.3\\selenium-server-1.0.3\\user-extensions.js");

	//rcc.setUserExtensions(userExtn);
	
	proc = new HttpCommandProcessor("localhost", 4444, "*chrome", "http://ciscodocs.cisco.com");
	selenium = new DefaultSelenium(proc);
	server = new SeleniumServer(false, rcc);
	server.boot();
	server.start();
	selenium.start();
	}


@Test 
public void testCiscoSearch() throws Exception {
	 String[] commands = new String[]{};
	 commands = new String[]{"C:\\david\\Selenium\\authentication.exe"};
	 System.out.println("Executing AutoIT");
	 Runtime.getRuntime().exec(commands);
	selenium.open("http://ciscodocs.cisco.com/ciscodocs/listFolder?action=listFolder&folderId=0b0dcae18324fac6&folderTitle=Q2O-QA%2BTesting");
	//selenium.open("http://davisolo:Bless26_09G@wwwin-sso.cisco.com");
	selenium.waitForPageToLoad("30000");
	selenium.type("id=c-directory-field", "davisolo");
	selenium.click("id=ext-gen142");
	selenium.waitForPageToLoad("30000");
	assertTrue(selenium.isTextPresent("David Thangaraj Solomon Raja"));
	assertTrue(selenium.isTextPresent("8861583888"));
	assertTrue(selenium.isTextPresent("Rajkumar Gell (rgell)"));
	verifyEquals(selenium.getText("link=Shell Scripting"), "Shell Scripting");
	verifyEquals(selenium.getText("xpath=/html/body/div[12]/div[2]/div/div/div[4]/div[4]/div/div/table/tbody/tr/td/table/tbody/tr/td/a"), "Selenium Automation");
}


@After
public void tearDown() throws Exception {
	selenium.stop();
	server.stop();
}

	
}
