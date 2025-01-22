package com_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_TestCases.Luma_BaseClass;

// import com_TestCases.Luma_BaseClass;




public class Reports implements ITestListener {
	
	public ExtentSparkReporter report;
	
	public ExtentReports extent;
	
	public ExtentTest test;
	
	
	public void onStart(ITestContext context) {
		//ye
		String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		
		String repname="Luma_Test_Report_"+timestamp+".html";
		       //LumaTestReport2024.09.12.12.36.32.html		
		report=new ExtentSparkReporter("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hybrid_Framework_01\\FileReports\\"+repname);
		report.config().setDocumentTitle("Luma-Testing-Report");
		report.config().setReportName("Luma Registration & Login validation test");
		report.config().setTheme(Theme.DARK);
		
		//provide basic info user
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		
		extent.setSystemInfo("Hostname", "Local Host");
		extent.setSystemInfo("User", "Anwesh");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome,Edge,Firefox");	
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	
	}
	
	
	
	public void onTestFailure(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));	
	
		try {
			
			String imppath= new Luma_BaseClass().capturescreen(tr.getName());
			test.addScreenCaptureFromPath(imppath); // add screenshot into extent report
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush(); // ==> it will remove un-nessecary data
		
	}
	

}
