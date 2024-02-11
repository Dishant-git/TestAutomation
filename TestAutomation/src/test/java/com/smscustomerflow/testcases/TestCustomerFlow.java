package com.smscustomerflow.testcases;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.smscustomerflow.pages.SMSCheckoutComplete;
import com.smscustomerflow.pages.SMSCheckoutOverview;
import com.smscustomerflow.pages.SMSCheckoutPage;
import com.smscustomerflow.pages.SMSHeaderPage;
import com.smscustomerflow.pages.SMSLoginPage;
import com.smscustomerflow.pages.SMSYourCart;
import com.util.TestUtil;

public class TestCustomerFlow extends TestBase {

	//SMS Pages
	SMSLoginPage smsloginpage;
	SMSHeaderPage smsheaderpage;
	SMSYourCart smsyourcart;
	SMSYourCart cadomainlevelpage;
	SMSCheckoutPage smscheckoutpage;
	SMSCheckoutOverview smscheckoutoverview;
	SMSCheckoutComplete smscheckoutcomplete;

	TestUtil testUtil;
	public static ExtentTest logger;

	@Parameters({ "environment"})
	@Test
	public void testLoginAndCustomerFlow(String environment)
			throws InterruptedException, IOException, AWTException {

		//Test Step 1: Login to portal and test customer flow
		initialization(environment, "siteURL");
		smsloginpage = new SMSLoginPage();
		smsheaderpage = smsloginpage.setDefaultLoginDetails(environment);
		smsheaderpage.verifyTitlePostLogin("Swag Labs");
		smsheaderpage.productAddToCart();
		smsheaderpage.validateWhetherItemAddedToCart("Sauce Labs Backpack");
		smsyourcart = smsheaderpage.goToShoppingCart();
		smsyourcart.verifyHeaderTitle("Your Cart");
		smscheckoutpage = smsyourcart.clickOnCheckoutButtton();
		Object[][] data = smscheckoutpage.getCartDetailsFromSheet("CartDetails");
		smscheckoutoverview = smscheckoutpage.enterCartDetails((String)data[0][0], (String)data[0][1], (String)data[0][2]);
		smscheckoutoverview.validateTotalCartValue("Total: $32.39");
		smscheckoutcomplete = smscheckoutoverview.clickOnFinishButton();
		smscheckoutcomplete.validateSuccessMsg("Thank you for your order!");
//		driver.quit();
	}
}
