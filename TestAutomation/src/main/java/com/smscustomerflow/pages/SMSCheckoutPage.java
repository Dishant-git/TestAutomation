package com.smscustomerflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.base.TestBase;
import com.util.TestUtil;

public class SMSCheckoutPage extends TestBase {
	
	TestUtil testUtil;

	// Objects
	@FindBy(how = How.XPATH, using = "//div[@class='header_secondary_container']")
	WebElement verifyHeaderTitle;
	
	@FindBy(how = How.ID, using = "first-name")
	WebElement enterFirstName;
	
	@FindBy(how = How.ID, using = "last-name")
	WebElement enterLastName;
	
	@FindBy(how = How.ID, using = "postal-code")
	WebElement enterPinCode;
	
	@FindBy(how = How.ID, using = "continue")
	WebElement continueButton;
	
	// Initializing Page Objects
	public SMSCheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderTitle() {
		Assert.assertEquals(verifyHeaderTitle.getText(), "Checkout: Your Information");
	}
	
	public Object[][] getCartDetailsFromSheet(String sheetName) {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	public SMSCheckoutOverview enterCartDetails(String firstName, String lastName, String pincode) {
		enterFirstName.sendKeys(firstName);
		enterLastName.sendKeys(lastName);
		enterPinCode.sendKeys(pincode);
		continueButton.click();
		return new SMSCheckoutOverview();
	}
}