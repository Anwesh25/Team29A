package com_Utilities;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Login_Report {
	
	public ExtentSparkReporter document;
	
	public ExtentReports extent;
	
	public ExtentTest test;
	
	public void Onstart(ITestContext ll) {
		document = new ExtentSparkReporter("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hybrid_Framework_01\\FileReports\\LoginPage.html");
		
		document.config().setDocumentTitle("Login Report document");
		document.config().setReportName("Login Report");
		document.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(document);
	}

}
