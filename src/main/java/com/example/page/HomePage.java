package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	private WebDriver driver;

	// Initializing the Page Objects:

	public HomePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='stars logo']")
	@CacheLookup
	WebElement homePageLogo;
	
	@FindBy(xpath = "//span[normalize-space()='User 1']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//li[normalize-space()='SITES']")
	@CacheLookup
	WebElement sitesLink;

	@FindBy(xpath = "//li[normalize-space()='COMPANIES']")
	WebElement companiesLink;
	
	@FindBy(xpath = "//li[normalize-space()='CLIENT USERS']")
	WebElement clientUsersLink;
	
	@FindBy(xpath = "//li[normalize-space()='AUDIT LOG']")
	WebElement auditLogLink;

	@FindBy(xpath = "//li[normalize-space()='FINANCE']")
	WebElement financeLink;
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public SitesPage clickOnSitesLink(){
		sitesLink.click();
		return new SitesPage(driver);
	}
	
	public CompaniesPage clickOnCompaniesLink(){
		companiesLink.click();
		return new CompaniesPage(driver);
	}
	
	public ClientUserPage clickOnClientUserLink(){
		clientUsersLink.click();
		return new ClientUserPage(driver);
	}
	
	public AuditLogPage clickOnAuditLogLink(){
		auditLogLink.click();
		return new AuditLogPage(driver);
	}
	
	public FinancePage clickOnFinanceLink(){
		financeLink.click();
		return new FinancePage(driver);
	}
	
	public void verifyHeaders() {
		sitesLink.isDisplayed();
		companiesLink.isDisplayed();
		clientUsersLink.isDisplayed();
		auditLogLink.isDisplayed();
		financeLink.isDisplayed();
	}
	
	
	
	
	
	
	
	

}
