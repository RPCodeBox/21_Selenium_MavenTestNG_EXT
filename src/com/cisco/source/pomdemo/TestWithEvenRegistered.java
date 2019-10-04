package com.cisco.source.pomdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/***
 * Class registers the Event listern class we created 
 * @author gshah
 *
 */
public class TestWithEvenRegistered {
 
 WebDriver driver = new FirefoxDriver();
 EventFiringWebDriver eventFiringWebDriver;
 @BeforeClass
 public void setup() {
  eventFiringWebDriver = new EventFiringWebDriver(driver);
  eventFiringWebDriver.register(new WebDriverEventListenerDemo());
  eventFiringWebDriver.get("http://google.com");
  
 }
 
 /**
  * "qq" is wrong element id and so NoElementFound Exception will 
  * be generated, which will call our overridden method of WebDriverEventListenerDemo
  * class and will take the screenshot. 
  */
 @Test
 public void test(){
  eventFiringWebDriver.navigate().to("http://google.com");
  eventFiringWebDriver.findElement(By.name("qq"));
  
 }
}