package com.cisco.source.pomdemo;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PartnerSearch {
	private WebDriver driver;
	private String baseUrl;
	JavascriptExecutor js;
	private StringBuffer verificationErrors = new StringBuffer();
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		baseUrl = "http://tools-dev.cisco.com/ef/bsslp/getCurrentRoleHome.do";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testPartnerSearch() throws Exception {
		driver.get(baseUrl );
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys("eftest1234");
		driver.findElement(By.id("passwordInput")).clear();
		driver.findElement(By.id("passwordInput")).sendKeys("Cisco123");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(75000);
		//driver.findElement(By.cssSelector("#mainTabContainer_tablist_tab2 > span.tabLabel")).click();
		WebElement newAssignment = driver.findElement(By.xpath("//span[text() = 'New Assignment']"));
		js.executeScript("arguments[0].style.border='3px solid red'", newAssignment);
		newAssignment.click();
		Actions action = new Actions(driver);
		
		//newAssignment.findElements(By.tagName("tr"));
		System.out.println("New Assigment clicked " + newAssignment.isEnabled());
		WebElement sp = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/div[2]/table/tbody/tr/td[2]/div[2]/div/input"));
		js.executeScript("arguments[0].style.border='3px solid red'", sp);
		//Thread.sleep(10000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='widget_serviceSelect_pn']"));
		js.executeScript("arguments[0].style.border='3px solid red'", dropdown);
		dropdown.click();
		sp.click();
		sp.sendKeys(Keys.ENTER);
		//sp.sendKeys(Keys.ARROW_DOWN);
		//dropdown.sendKeys(Keys.ARROW_DOWN);
		//dropdown.sendKeys(Keys.ARROW_DOWN);
		//dropdown.sendKeys(Keys.ENTER);
		/*sp.click();
		sp.sendKeys(Keys.ARROW_DOWN);
		sp.sendKeys(Keys.ENTER);*/
		//action.keyDown(Keys.ARROW_DOWN);
		
		//driver.findElement(By.xpath("//div[@id='widget_currroleSelect_pn']/div")).click();
		driver.findElement(By.id("dojox_grid_EnhancedGrid_2_rowSelector_0")).click();
		driver.findElement(By.id("xwt_widget_form_TextButton_7")).click();
		driver.findElement(By.xpath("//div[@id='dojox_grid__View_13']/div/div/div/div/table/tbody/tr/td")).click();
		driver.findElement(By.id("xwt_widget_form_TextButton_10")).click();
		driver.findElement(By.id("xwt_widget_form_TextButton_35")).click();
	}

	@AfterTest
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
