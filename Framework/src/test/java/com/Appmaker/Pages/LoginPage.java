package com.Appmaker.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginPage {
	
	WebDriver  driver;

			
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="email") WebElement email;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(name="submitbtn") WebElement loginBtn;
	
	@FindBy(className="toast-message") WebElement Terminateaccountvalidation;
	
	@FindBy(className="auto-login-dialog-btn-yes") WebElement loginYesbtn;
	
	
	
	@Test(priority = 1)
	public void checkValidationTerminateAccoount(String username, String appmakerpassword) throws InterruptedException
	{
		
		Thread.sleep(4000);
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(appmakerpassword);
		loginBtn.click();
		Thread.sleep(2000);
		
		String actual_msg =  Terminateaccountvalidation.getAttribute("innerHTML");
		String expect = "Access denied. Your trying to login from an account that has been terminated";

		if (actual_msg.contains(expect)) {
			
			System.out.println("Validation passed = " + actual_msg);
		} else {
			
			System.out.println("Test Case Failed = " + actual_msg);
		}
		Thread.sleep(5000);
	
		
	}
	

	@Test(priority = 2)
	public void checkValidationForIncorrectEmail(String username, String appmakerpassword) throws InterruptedException
	{
		
		Thread.sleep(4000);
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(appmakerpassword);
		loginBtn.click();
		Thread.sleep(2000);
		
		
		String actual_msg =  Terminateaccountvalidation.getAttribute("innerHTML");
		String expect = "Please check your Email/Password";

		if (actual_msg.contains(expect)) {
			System.out.println("Validation passed = " + actual_msg);
		} else {
			System.out.println("Test Case Failed = " + actual_msg);
		}
		Thread.sleep(5000);
	}
	@Test(priority = 3)
	public void checkValidationForIncorrectPassword(String username, String appmakerpassword) throws InterruptedException
	{
		Thread.sleep(4000);
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(appmakerpassword);
		loginBtn.click();
		Thread.sleep(1000);
		
		
		List<WebElement> x = driver.findElements(By.className("auto-login-dialog-btn-yes"));

		if (x.size() > 0)
		{
		    x.get(0).click();
		} else {
			
			System.out.println("Button not found");
	
	}	
		Thread.sleep(1000);
		
		String actual_msg =  Terminateaccountvalidation.getAttribute("innerHTML");
		String expect = "You have 9 tries left before the account is locked out";

		if (actual_msg.contains(expect)) {
			System.out.println("Validation passed = " + actual_msg);
		} else {
			System.out.println("Test Case Failed = " + actual_msg);
		}
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void loginToAppmaker(String username, String appmakerpassword) throws InterruptedException
	{
		Thread.sleep(4000);
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(appmakerpassword);
		loginBtn.click();
		Thread.sleep(1000);
		
		List<WebElement> x = driver.findElements(By.className("auto-login-dialog-btn-yes"));

		if (x.size() > 0)
		{
		    x.get(0).click();
		} else {
			
			System.out.println("Button not found");
	}	
		Thread.sleep(2000);
		
		String actual_msg =  Terminateaccountvalidation.getAttribute("innerHTML");
		String expect = "Login Successful";

		if (actual_msg.contains(expect)) {
			System.out.println("Validation passed = " + actual_msg);
		} else {
			System.out.println("Test Case Failed = " + actual_msg);
		}
		Thread.sleep(30000);
		
	}

}
