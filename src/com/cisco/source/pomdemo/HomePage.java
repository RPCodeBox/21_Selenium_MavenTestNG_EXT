package com.cisco.source.pomdemo;


//import jxl.common.Assert;


import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class HomePage {
	
	JavascriptExecutor js;
	 public HomePage(WebDriver driver) {  
		         super();  
		         this.driver = driver;
		         
		         if (driver instanceof JavascriptExecutor) {
		 		    js = (JavascriptExecutor)driver;
		 		}
		    }  
	ElementDetails  ed = new ElementDetails();
	
	private WebDriver driver;  
	public String baseUrl = ed.BaseUrl;
	Selenium selenium;
	
	
	public SearchResultPage searchUser () throws Exception{
	
		driver.get(baseUrl);
	
		WebElement searchBox = driver.findElement(By.id(ed.searchBox));
		searchBox.clear();
		js.executeScript("arguments[0].style.border='3px solid red'", searchBox);
		//Thread.sleep(60000);
		searchBox.sendKeys(ed.nameToBeSearched);
		
		driver.findElement(By.id(ed.searchButton)).click();
			
		return new SearchResultPage(driver);
	}
	
}
