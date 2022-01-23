package com.Appmaker.TestCases;
import org.testng.annotations.Test;

import org.openqa.selenium.support.PageFactory;
import com.Appmaker.Pages.BaseClass;
import com.Appmaker.Pages.CreateNewApp;
import com.Appmaker.Pages.LoginPage;
import com.Appmaker.Utility.Helper;


public class CRM_Template extends BaseClass {

	@Test(priority = 1)
	public void LogintoApplication() throws InterruptedException
	{
		
		logger= report.createTest("Login to Appmaker");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");
		
		loginPage.checkValidationTerminateAccoount(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		
		logger.pass("Validation pass: Terminate account");
		
		loginPage.checkValidationForIncorrectEmail(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		
		logger.pass("Validation pass: Incorrect email account");
		
		loginPage.checkValidationForIncorrectPassword(excel.getStringData("Login", 2, 0), excel.getStringData("Login", 2, 1));
		
		logger.pass("Validation pass: Incorrect password");
		
		loginPage.loginToAppmaker(excel.getStringData("Login", 3, 0), excel.getStringData("Login", 3, 1));
		
		logger.pass("Login success");
		
		Helper.captureScreenshots(driver);
		
		
	}
	
	@Test(priority = 2)
	public void createNewCRMapp() throws InterruptedException
	{
		
		logger= report.createTest("create new CRM App");
		
		CreateNewApp createappnew = PageFactory.initElements(driver, CreateNewApp.class);
		
		logger.info("Creating new CRM app");
		
		createappnew.createappcrm();
		
		
		createappnew.enterExistingappname(excel.getStringData("Login", 4, 0));
		
		logger.pass("Validation pass: existing app name validation");
		
		createappnew.enterNamewithSpecialCharacter(excel.getStringData("Login", 5, 0));
		
		logger.pass("Validation pass: Special character validation");

		
		createappnew.entercorrectAppName("CRM");
		
		logger.pass("New app created");

		
		Helper.captureScreenshots(driver);
	}
}
