package com.david.test;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.david.source.*;
import com.thoughtworks.selenium.SeleneseTestCase;

public class DSRDownload extends SeleneseTestCase{

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		/*FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        profile.setPreference("network.automatic-ntlm-auth.trusteduris","ecm-sso.cisco.com");
        driver = new FirefoxDriver(profile); */
		driver = new FirefoxDriver();
		baseUrl = "http://ciscodocs.cisco.com/";
		//selenium = new WebDriverBackedSelenium(driver, baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCiscoSearchWd() throws Exception {
		
		
		String day = getDayofWeek();
		int dateAlone = getDateAlone();
		
		String fileLoc = "C:\\david\\autoDSR\\";
		
		if (day == "Monday")
		{
			dateAlone = dateAlone - 3;
		}
		else
		{
			dateAlone = dateAlone - 1;
		}
		
		
		
		String monthAlone = getMonthAlone();
		
		String linkToClick = "Q2FY13_TCB_DSR_REPORT_"+ monthAlone + dateAlone ;
		System.out.println("Link to click is " + linkToClick);
		
		String[] commands = new String[]{};
		String fileName = "Q2FY13_TCB_DSR_REPORT_" + monthAlone + dateAlone + ".xlsm";
		System.out.println("FileName is " + fileName);
		
		 commands = new String[]{"C:\\david\\autoDSR\\authentication.exe"};
		 System.out.println("Executing Authentication AutoIT ");
		 Runtime.getRuntime().exec(commands);
		driver.get("http://ciscodocs.cisco.com/ciscodocs/listFolder?action=listFolder&folderId=0b0dcae1837aec96&folderTitle=TCB&rootFolderId=0b0dcae18324fac6&parentFolderId=0b0dcae1837aec94&parentFolderTitle=Daily%2bDSR%2bFiles");
		//driver.get("http://davisolo:password@wwwin-sso.cisco.com");
//		driver.get("http://davisolo:Bless26_09G@wwwin-sso.cisco.com");
		
		Select droplist = new Select(driver.findElement(By.id("noRecords")));
		droplist.selectByVisibleText("100");
		
		WebElement dsrlink = driver.findElement(By.linkText(linkToClick));
		//dsrlink.submit();
		//dsrlink.click();
		//Actions moveTo = new Actions(driver);
		//moveTo.moveToElement(dsrlink).click().build().perform();
		dsrlink.sendKeys(Keys.ENTER);
		//selenium.click("link=" + linkToClick);
		
		System.out.println("Executing FileDownload AutoIT ");
		commands = new String[]{"C:\\david\\autoDSR\\FileDownload.exe"};
		Runtime.getRuntime().exec(commands);
		Thread.sleep(600000);
		//Thread.sleep(30000);
		//driver.findElement(By.id("c-directory-field")).sendKeys("davisolo");
		//driver.findElement(By.id("ext-gen142")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPr
		
		
		try{
			 
	    	   File afile =new File("C:\\Documents and Settings\\davisolo\\My Documents\\Downloads\\" + fileName);
	 
	    	   if(afile.renameTo(new File(fileLoc + afile.getName()))){
	    		System.out.println("File is moved successful!");
	    	   }else{
	    		System.out.println("File is failed to move!");
	    	   }
	 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	commands = new String[]{"C:\\david\\autoDSR\\MsgBoxClick.exe"};
			Runtime.getRuntime().exec(commands);
			System.out.println("Executing MsgBox AutoIt");
	    	runDSR(fileLoc + fileName);
			System.out.println("Executing OpenDSR.vbs ");
			Thread.sleep(490000);
			System.out.println("Sending the mail now");
			SendEmail2.sendDSR(fileLoc + fileName);
			
			//Thread.sleep(120000);
	}
	
	public void runDSR(String fileLocation)
	{
		Runtime runtime = Runtime.getRuntime();
		 try {
		     Process p1 = runtime.exec("cmd /c start C:\\david\\autoDSR\\OpenDSR.bat " + fileLocation);
		     /*InputStream is = p1.getInputStream();
		     int i = 0;
		     while( (i = is.read() ) != -1) {
		         System.out.print((char)i);
		     }*/
		 } catch(IOException ioException) {
		     System.out.println(ioException.getMessage() );
		 }
	}
	
	public String getDayofWeek()
	{
			String dayNames[] = new DateFormatSymbols().getWeekdays();
			Calendar date2 = Calendar.getInstance();
			System.out.println("Today is a " 
	        + dayNames[date2.get(Calendar.DAY_OF_WEEK)]);
			String day = dayNames[date2.get(Calendar.DAY_OF_WEEK)];
			return day;
	}
	
	public int getDateAlone()
	{
			Date todaysDate = new java.util.Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd");
			String formattedDate = formatter.format(todaysDate);
			
			System.out.println("Formatted date is ==>"+formattedDate);
			
			int date = Integer.parseInt(formattedDate);
			
			return date;
		  
	}
	
	public String getMonthAlone()
	{
			Date todaysDate = new java.util.Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMM");
			String formattedDate = formatter.format(todaysDate);
			
			System.out.println("Formatted date is ==>"+formattedDate);
			
			
			
			return formattedDate;
		  
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		
	}


	
	
}
