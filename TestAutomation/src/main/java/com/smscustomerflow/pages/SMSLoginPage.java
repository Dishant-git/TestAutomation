package com.smscustomerflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.Environment;
import com.base.TestBase;


public class SMSLoginPage extends TestBase{

	//Objects
	@FindBy(how=How.NAME, using = "user-name")
	WebElement userName;

	@FindBy(how=How.NAME, using = "password")
	WebElement password;

	@FindBy(how=How.NAME, using = "login-button")
	WebElement submitButton;

	//Initializing Page Objects
	public SMSLoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Methods
	public boolean validateSubmitButtonExists(){
		return submitButton.isDisplayed();
	}

	public SMSHeaderPage setDefaultLoginDetails(String environment) throws InterruptedException {

		if(environment.equalsIgnoreCase("dev")) {
			userName.sendKeys("standard_user");
			password.sendKeys("secret_sauce");
		}
		submitButton.click();
		return new SMSHeaderPage();
	}

	public SMSHeaderPage login(String strusername, String strpassword){

		userName.sendKeys(strusername);
		password.sendKeys(strpassword);
		submitButton.click();
		return new SMSHeaderPage();
	}
}
