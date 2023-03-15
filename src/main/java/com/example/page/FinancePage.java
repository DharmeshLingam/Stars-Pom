package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage  {

	@FindBy(xpath = "//h1[normalize-space()='Billings']")
	WebElement billingHeader;
	
	@FindBy(xpath = "//button[normalize-space()='Filters']")
	WebElement filtersBtn;

	@FindBy(xpath = "//button[normalize-space()='Columns']")
	WebElement columnsBtn;

	@FindBy(xpath = "//*[text()='Density']")
	WebElement densityBtn;

	@FindBy(xpath = "//*[text()='Export']")
	WebElement exportBtn;
	
	
	
	// Initializing the Page Objects:
	private WebDriver driver;

	public FinancePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyBillingLabel(){
		return billingHeader.isDisplayed();
	}
	
	public void verifyFinancePageLabels() {
		filtersBtn.isDisplayed();
		columnsBtn.isDisplayed();
		densityBtn.isDisplayed();
		exportBtn.isDisplayed();
	}
	
	
	

	
	
	

}
