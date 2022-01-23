package com.Appmaker.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Appmaker.Utility.BrowserFactory;
import com.Appmaker.Utility.ConfigDataProvider;
import com.Appmaker.Utility.ExcelDataProvider;
import com.Appmaker.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	@BeforeSuite
	public void setUpexcelSuite()
	{
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Appmaker"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done - Test can be started", true);
		
	}
	
	
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Tring to start Broswser and Getting application ready", true);
		
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getstringURL());
		System.out.println(driver.getTitle());
		
		Reporter.log("Browser and application is up and running ", true);
	}
	
/*	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	*/
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());

		}
		
		
		report.flush();
		
		Reporter.log("Test completed >> Report Generated", true);
	}
}
