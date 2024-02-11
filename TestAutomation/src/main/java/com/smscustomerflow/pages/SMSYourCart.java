package com.smscustomerflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.base.TestBase;

public class SMSYourCart extends TestBase {

	// Objects
	@FindBy(how = How.XPATH, using = "//div[@class='header_secondary_container']")
	WebElement verifyHeaderTitle;

	@FindBy(how = How.ID, using = "checkout")
	WebElement checkoutButton;

	// Initializing Page Objects
	public SMSYourCart() {
		PageFactory.initElements(driver, this);
	}

	public void verifyHeaderTitle(String expectedHeaderTitle) {
		Assert.assertEquals(verifyHeaderTitle.getText(), expectedHeaderTitle);
	}

	public SMSCheckoutPage clickOnCheckoutButtton() {
		checkoutButton.click();
		return new SMSCheckoutPage();
	}
}
