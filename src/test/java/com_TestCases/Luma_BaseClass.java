package com_TestCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com_Utilities.Reading_Login_Data;
import com_Utilities.Reading_Luma_Data;

public class Luma_BaseClass {
	
	public static WebDriver driver;
//	public ResourceBundle RB;
	public Logger Log;
	
	
	Reading_Luma_Data rld = new Reading_Luma_Data();
	
	public String FName = rld.getFirstName(); 
	public String LName = rld.getLastName();
	public String EmailAdd = rld.getEmailAddress();
	public String Password = rld.getPassword();
	public String CPassword = rld.getCPassword();
	
/*	
	Reading_Login_Data ld = new Reading_Login_Data();
	
	public String LoginEmail = ld.getEmail();
	public String LoginPassword = ld.getPassword();
*/
	@BeforeSuite
	@Parameters({"browser", "url"})
	public void Luma_BaseClass(String br, String URL) {
//		RB= ResourceBundle.getBundle("ElementProperties_forRegistrationPage");
		
		if(br.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Log = Logger.getLogger("Hybrid_Framework_01");
		PropertyConfigurator.configure("Log4j.properties");
	}
/*
	@AfterClass
	public void CloseApplication() {
		driver.close();
	}
*/

	public String capturescreen(String tname) {
		String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot screenshort = ((TakesScreenshot)driver);
		File source = screenshort.getScreenshotAs(OutputType.FILE);
		
		String Destination = System.getProperty("user.dir")+"\\Screenshorts\\"+tname+"_"+timestamp+".png";
	
	try {
		FileUtils.copyFile(source, new File(Destination));
	}catch (Exception e) {
		e.getMessage();
	}
	return Destination;
	
	}
	
}
