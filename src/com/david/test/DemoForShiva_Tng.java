package com.david.test;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class DemoForShiva_Tng extends SeleneseTestNgHelper {
	@Test public void testDemoForShiva_Tng() throws Exception {
		selenium.open("/");
		selenium.click("id=c-mylinks-tab");
		selenium.type("id=c-directory-field", "shiva nori");
		selenium.click("id=ext-gen142");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("7411056263"));
	}
}
