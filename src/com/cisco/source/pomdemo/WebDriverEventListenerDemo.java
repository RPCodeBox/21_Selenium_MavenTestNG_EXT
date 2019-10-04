package com.cisco.source.pomdemo;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverEventListenerDemo implements WebDriverEventListener {
 @Override
 public void onException(Throwable exception, WebDriver driver) {
  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  try {
   FileUtils.copyFile(screenShot, new File("c:\\tmp\\exception.png"));
  } catch (IOException e) {
   e.printStackTrace();
  }
  
 }

@Override
public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void afterClickOn(WebElement arg0, WebDriver arg1) {
	System.out.println(arg0.getTagName() + " has been clicked");
	System.out.println("Element has been clicked");
	
}

@Override
public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	// TODO Auto-generated method stub
	
}

@Override
public void afterNavigateBack(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void afterNavigateForward(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void afterNavigateTo(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void afterScript(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeClickOn(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
 System.out.println("TRYING TO FIND THE ELEMENT ........");
	
}

@Override
public void beforeNavigateBack(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeNavigateForward(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeNavigateTo(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeScript(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}
}