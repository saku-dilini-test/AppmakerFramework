package com.Appmaker.Pages;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateNewApp {

	WebDriver  driver;

	
	public CreateNewApp(WebDriver ldriver)
	{
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="Create_New_App") WebElement createappbtn;
	@FindBy(className="auto-btn-select-CRM-App") WebElement Crmtemplatebtn;
	@FindBy(name="New_Templates") WebElement templates;
	@FindBy(name="appName") WebElement appname;
	@FindBy(name="GetStarted_Btn") WebElement getstartedbtn;
	@FindBy(className="toast-message") WebElement validationmessag;
	@FindBy(xpath="/html/body/div[1]/ui-view/form/div[2]/fieldset[3]/span") WebElement validationmessag2;
	
	@FindBy(className="automation-auto-refresh") WebElement autorefreshbtn;
	
	
		public void createappcrm() throws InterruptedException
	{
		createappbtn.click();
		System.out.println("Select a app button clicked");
		Thread.sleep(9000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement crm = Crmtemplatebtn;
		js.executeScript("arguments[0].scrollIntoView();", crm);
		Thread.sleep(4000);

		WebElement crm1 = Crmtemplatebtn;
		JavascriptExecutor js1= (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", crm1); 
		Thread.sleep(5000);
	}
		public void createappastro() throws InterruptedException
		{
			createappbtn.click();
			System.out.println("Select a app button clicked");
			Thread.sleep(9000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement crm = Crmtemplatebtn;
			js.executeScript("arguments[0].scrollIntoView();", crm);
			Thread.sleep(4000);

			WebElement crm1 = Crmtemplatebtn;
			JavascriptExecutor js1= (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", crm1); 
			Thread.sleep(5000);
		}
		
		
		public void enterExistingappname(String appnameenter) throws InterruptedException {
//Check app naming window validation -----------------------------------------------------------------------------------------------------------
		
		appname.sendKeys(appnameenter);
		System.out.println("App name entered");
		Thread.sleep(5000);
		
		getstartedbtn.click();
		System.out.println("Get Started button clicked");
		Thread.sleep(2000);
		
		String actual_msg21 = validationmessag.getAttribute("innerHTML");
		String expect21 = "App name already exists!";

		if (actual_msg21.contains(expect21)) {
			System.out.println("Validation passed = " + actual_msg21);
		} else {
			System.out.println("Test Case Failed = " + actual_msg21);
		}
		Thread.sleep(7000);
		
	}	
	
	public void enterNamewithSpecialCharacter(String appnameenter) throws InterruptedException {
		
		appname.clear();
		appname.sendKeys(appnameenter);
		System.out.println("App name entered with special characters");
		Thread.sleep(5000);
		
		String actual_msg1 = validationmessag2.getAttribute("innerHTML");
		String expect1 = "You can only add english characters and numbers";

		if (actual_msg1.contains(expect1)) {
			System.out.println("Validation passed = " + actual_msg1);
		} else {
			System.out.println("Test Case Failed = " + actual_msg1);
		}
		Thread.sleep(7000);
	}		

	public void entercorrectAppName(String appName) throws InterruptedException
	{
		appname.clear();
		System.out.println("App naming window cleared");
		Thread.sleep(5000); 
		
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		WebElement App = appname;
		App.sendKeys(generatedString +appName);
		Thread.sleep(2000);

		WebElement Appname = appname;
		Appname.sendKeys(Keys.CONTROL + "a");

		Thread.sleep(1000);
		System.out.println("App name = " + Appname.getAttribute("value"));
		System.out.println("App name entered");

	/*	String copiedText = appname.getAttribute("value").toString();
		Thread.sleep(1000);

		File file = new File("/Users/sakunthaladilini/Desktop/Eclips/Automation_my_practicals/POM_Project/src/test/java/article/textWrite.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write(copiedText);
		writer.close();*/

		Thread.sleep(10000);

		getstartedbtn.click();
		System.out.println("Get Started button clicked");
		Thread.sleep(9000);
		
		WebElement confirmb = driver.findElement(By.cssSelector(".me-default-button:nth-child(2) > .ng-scope"));
		Actions actions = new Actions(driver);
		actions.moveToElement(confirmb).click().build().perform();
		System.out.println("Please note that app name cannot be changed after this step. Confirm to proceed with the current app name - Confirm clicked");
		Thread.sleep(5000);
		
		autorefreshbtn.click();
		System.out.println("Auto Refesh slider button clicked");
		Thread.sleep(4000);
	}
}
