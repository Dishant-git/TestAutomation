package com.smscustomerflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class SMSCheckoutOverview extends TestBase {

	// Objects
	@FindBy(how = How.XPATH, using = "//div[@class='summary_info_label summary_total_label']")
	WebElement totalCartValue;
	
	@FindBy(how = How.ID, using = "finish")
	WebElement finishButton;
	
	// Initializing Page Objects
	public SMSCheckoutOverview() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateTotalCartValue(String expectedTotalCartValue) {
		Assert.assertEquals(totalCartValue.getText(), expectedTotalCartValue);
	}
	
	public SMSCheckoutComplete clickOnFinishButton() {
		finishButton.click();
		return new SMSCheckoutComplete();
	}
}