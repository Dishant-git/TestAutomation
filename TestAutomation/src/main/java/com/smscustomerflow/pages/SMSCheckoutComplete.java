package com.smscustomerflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class SMSCheckoutComplete extends TestBase {

	// Objects
	@FindBy(how = How.XPATH, using = "//h2[@class='complete-header']")
	WebElement successMsg;

	// Initializing Page Objects
	public SMSCheckoutComplete() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateSuccessMsg(String expectedSuccessMsg) {
		Assert.assertEquals(successMsg.getText(), expectedSuccessMsg);
	}
}
