package com.smscustomerflow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class SMSHeaderPage extends TestBase {

	// Objects
	@FindBy(how = How.XPATH, using = "//div[text()='Swag Labs']")
	WebElement loggedInTitleVerification;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Sauce Labs Backpack']/following::button[text()='Add to cart'][1]")
	WebElement swagLabsBackpackAddToCartButton;
	
	@FindBy(how = How.ID, using = "shopping_cart_container")
	WebElement shopping_cart_container;
	
	// Initializing Page Objects
	public SMSHeaderPage() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void verifyTitlePostLogin(String expectedString) {
		Assert.assertEquals(loggedInTitleVerification.getText(), expectedString);
	}
	
	public void productAddToCart() {
		swagLabsBackpackAddToCartButton.click();
	}
	
	public void validateWhetherItemAddedToCart(String product) {
		driver.findElement(By.xpath("//div[text()='"+product+"']/following::button[text()='Remove'][1]")).isDisplayed();
	}
	
	public SMSYourCart goToShoppingCart() {
		shopping_cart_container.click();
		return new SMSYourCart();
	}
}
