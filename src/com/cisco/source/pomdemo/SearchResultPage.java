package com.cisco.source.pomdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	
	public SearchResultPage(WebDriver driver) {  
        super();  
        this.driver = driver;  
   }
	ElementDetails  ed = new ElementDetails();
	private final WebDriver driver;
	
	
	public WhiteboxTestingPage openWhiteBoxTesting() throws Exception
	{
		WebElement wbt = driver.findElement(By.linkText(ed.whiteboxtestinglink));
		wbt.click();
		//driver.wait(30000);
		return new WhiteboxTestingPage(driver);
		
	}

}
