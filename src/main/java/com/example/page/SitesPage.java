package com.example.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;

import com.example.selenium.SeleniumUtils;
import com.example.utils.TestUtil;
import com.github.javafaker.Faker;

public class SitesPage {

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger();

	// Initializing the Page Objects:

	public SitesPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	Faker faker = new Faker(new Locale("en-CA"));

	@FindBy(xpath = "//h1[normalize-space()='Sites']")
	WebElement sitesHeader;

	@FindBy(xpath = "//button[normalize-space()='Filters']")
	WebElement filtersBtn;

	@FindBy(xpath = "//button[normalize-space()='Columns']")
	WebElement columnsBtn;

	@FindBy(xpath = "//h1[normalize-space()='Sites']/..//*[text()='Density']")
	WebElement densityBtn;

	@FindBy(xpath = "//h1[normalize-space()='Sites']/..//*[text()='Export']")
	WebElement exportBtn;

	@FindBy(xpath = "//h1[normalize-space()='Sites']/..//*[text()='Add New']")
	WebElement addNewBtn;

	@FindBy(xpath = "//*[normalize-space()='Add New Company']")
	WebElement addNewCompany;
	
	@FindBy(xpath = "//*[contains(text(),'Creating new Site | Client Site ID: ')]")
	WebElement createNewSiteLabel;

	
	//New Contact 
	
	@FindBy(xpath = "//h2[contains(text(),'New Contact')]")
	WebElement newContactHeader;

	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-1gc9r04']//input[@id='name']")
	WebElement firstNameTxt;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastNameTxt;

	@FindBy(xpath = "//input[@id='phoneNumber']")
	WebElement phoneNumberTxt;
	
	@FindBy(xpath = "//input[@name='isCaller']")
	WebElement isCallerBtn;

	@FindBy(xpath = "//input[@name='isPrimary']")
	WebElement isPrimarytBtn;

	@FindBy(xpath = "//input[@name='isEmergency']")
	WebElement isEmergencyBtn;

	@FindBy(xpath = "//input[@name='isCloseSite']")
	WebElement isCloseSiteBtn;
	
	@FindBy(xpath = "//input[@name='isMoveSite']")
	WebElement isMoveSiteBtn;

	@FindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthXl css-hppdow']//textarea[@id='notes']")
	WebElement notesTxt;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "(//button[text()='Cancel'])[4]")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[contains(text(),'New Contact created successfully')]")
	WebElement contactCreatedPopUp;

	@FindBy(xpath = "//button[contains(text(),'Location')]")
	WebElement locationBtn;
	
	@FindBy(xpath = "//input[@id='lsd1']")
	WebElement lsd1Txt;
	
	@FindBy(xpath = "//input[@id='lsd2']")
	WebElement lsd2Txt;
	
	@FindBy(xpath = "//input[@id='lsd3']")
	WebElement lsd3Txt;
	
	@FindBy(xpath = "//input[@id='lsd4']")
	WebElement lsd4Txt;
	
	@FindBy(xpath = "//input[@id='lsd5']")
	WebElement lsd5Txt;

	@FindBy(xpath = "//button[contains(text(),'Safety')]")
	WebElement safetyBtn;

	@FindBy(xpath = "//button[contains(text(),'Billing')]")
	WebElement billingBtn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement siteSubmitBtn;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement siteCancelBtn;
	
	@FindBy(xpath = "//img[@alt='stars logo']")
	@CacheLookup
	WebElement homePageLogo;

	@FindBy(xpath = "//input[@id='billing-company']")
	WebElement billingCompanyTxt;
	
	@FindBy(xpath = "//div//li[text()='Alberta Safety Control Ltd.']")
	WebElement selectList;

	@FindBy(xpath = "//input[@name='verifiedLeaseHolder']")
	WebElement verifiedLeaseHolderText;

	@FindBy(xpath = "//input[@id='lease-company']") //Jan van Haastert 
	WebElement leaseCompanyDropdown;

	@FindBy(xpath = "//div[@class='MuiDataGrid-columnsPanel css-esvwh7']//div//span[contains(@class,'MuiTypography-root MuiTypography-body')]")
	List<WebElement> listColumns;
	
	@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[1]")
	WebElement filterColumnsDropdown;

	@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[2]")
	WebElement filterOperatorDropdown;

	@FindBy(xpath = "//input[@placeholder='Filter value']")
	WebElement filterValueTxt;
	
	@FindBy(xpath = "//div[contains(text(),'Site was Modified Successfully. Client Site ID:')]")
	WebElement siteModifiedPopUp;
	
	@FindBy(xpath = "//button[normalize-space()='Yes.']")
	WebElement yesBtn;
	
	@FindBy(xpath = "//button[@type='button']//button[@type='button'][normalize-space()='Add New']")
	WebElement addNewContactBtn;
	
	@FindBy(xpath = "//span[text()='Client Site Id:']//following-sibling::span")
	WebElement clientSiteId;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']//div[1]//div[1]")
	WebElement selectClientSiteId;
	
	@FindBy(xpath = "//*[@data-field='deleteContact' and @role='cell']")
	WebElement deleteContactBtn;
		
	

	private String randomNumber;
	
	private String clientSiteIdValue;

	public String getClientSiteIdValue() {
		return clientSiteIdValue;
	}

	public void setClientSiteIdValue(String clientSiteIdValue) {
		this.clientSiteIdValue = clientSiteIdValue;
	}

	String column = "clientSiteId";
	String operator = "contains";

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public boolean verifySitesLabel() {
		return sitesHeader.isDisplayed();
	}

	public void verifyColumnsList() {

		SeleniumUtils.click(driver, columnsBtn);
		List<String> expectedColumnsList = Arrays.asList("AFE Project Code", "Accessible By Ground", "Accessible By Ground Details", "Allocated Billing Company ID", "AltLandingDetails", "Billing Company Id", "Billing Company Name", "Billing Group", "Call Back Comment", "Call Back Performed", "Call Back Performed By", "Client Site", "Client Site ID", "Close Site Comment", "Contact Company", "Contact Email", "Contact Name", "Contact Phone Number", "Contacts", "Driving Directions Posted", "End Date", "GPS", "Has AED", "Has H2S", "Has H2S Monitor", "Has MTC", "HasDesignatedLandingZone", "Industry Type", "Industry Type Id", "Is 24 Hour", "Is Billing Company Selected", "Is Permanent", "Is Project", "LSD", "Last Updated", "Latitude", "Lease Holder Company Name", "Lease Holder CompanyId", "License Type", "License Type ID", "Location Description", "Location Group", "Longitude", "Los Service Area Id", "Los ems ProviderId", "Max People", "Medical Training Available", "Nearest Town", "Nearest Town Validated", "No Match Verified", "Not To Be Billed", "Notes", "Other Activity", "Other Hazards", "Other Location Info", "PNG", "Primary Location Type", "Region", "Region ID", "Rig Number", "Safety Documents", "Safety Group", "Site Action Id", "Site Status", "Sites Group", "Start Date", "Temp Activity Activity", "Temp Activity Additional Crew Hazards", "Temp Activity End Date", "Temp Activity Has AED", "Temp Activity Has H2S", "Temp Activity Has H2S Monitor", "Temp Activity Has MTC", "Temp Activity Medical Training Id", "Temp Activity Name", "Temp Activity Notes", "Temp Activity Phone Number", "Temp Activity Start Date", "Verified Lease Holder", "Verified License", "activityType", "activityTypeId", "other Industry Type Desc");
		List<String> actualColumnsList = new ArrayList<String>();
		for (WebElement we : listColumns) {
			actualColumnsList.add(we.getText());
		}
		Collections.sort(expectedColumnsList);
		Collections.sort(actualColumnsList);
		LOGGER.info("Actual columns list " + actualColumnsList);
		LOGGER.info("Expected columns list " + expectedColumnsList);
		Assert.assertEquals(actualColumnsList, expectedColumnsList, "Both list are equals");

	}

	public void verifySitesColumnsLabels() {
		filtersBtn.isDisplayed();
		columnsBtn.isDisplayed();
		densityBtn.isDisplayed();
		exportBtn.isDisplayed();
		addNewBtn.isDisplayed();
	}

	public void filterCompany(String column, String operator, String value) {
		SeleniumUtils.click(driver, filtersBtn);
		SeleniumUtils.selectByValue(driver, filterColumnsDropdown, column);
		SeleniumUtils.selectByValue(driver, filterOperatorDropdown, operator);
		SeleniumUtils.enterText(driver, filterValueTxt, value);
		SeleniumUtils.click(driver, sitesHeader);
	}

	public void selectValueFromDropdown(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='" + name + "']")));
		driver.findElement(By.xpath("//li[normalize-space()='" + name + "']")).click();
	}

	public void createNewSite(String firstName, String lastName, String phone, String isCaller,
			String notes,String billingCompany,String leaseHolder,String leaseHolderCompany) {
		SeleniumUtils.clickUsingJs(driver, addNewBtn);
		createContact(firstName, lastName, phone);
		Assert.assertTrue(contactCreatedPopUp.isDisplayed(), "Contact created successfully");
		SeleniumUtils.clickUsingJs(driver, locationBtn);
		fillLSD();
		SeleniumUtils.clickUsingJs(driver, safetyBtn);
		SeleniumUtils.clickUsingJs(driver, billingBtn);
		SeleniumUtils.enterText(driver, billingCompanyTxt, billingCompany);
		selectValueFromDropdown(billingCompany);
		SeleniumUtils.enterText(driver, verifiedLeaseHolderText, leaseHolder);
		SeleniumUtils.enterText(driver, leaseCompanyDropdown, leaseHolderCompany);
		selectValueFromDropdown(leaseHolderCompany);
		SeleniumUtils.clickUsingJs(driver, siteSubmitBtn);
		Assert.assertTrue(siteModifiedPopUp.isDisplayed(), "Sites modified successfully");
		SeleniumUtils.clickCoordinates(driver);	
		
	}

	
	private void createContact(String firstName, String lastName, String phone) {
		String randomNumber = TestUtil.getRandomString();
		setRandomNumber(randomNumber);
		firstName = firstName + randomNumber;
		Assert.assertTrue(newContactHeader.isDisplayed(), "User is on new contact creation screen");
		String clientId=clientSiteId.getText();
		System.out.println("clientId "+clientId);
		setClientSiteIdValue(clientId);
		SeleniumUtils.enterText(driver, firstNameTxt, firstName);
		SeleniumUtils.enterText(driver, lastNameTxt, lastName);
		SeleniumUtils.enterText(driver, phoneNumberTxt, phone);
		SeleniumUtils.clickUsingJs(driver, isCallerBtn);
		SeleniumUtils.enterText(driver, notesTxt, phone);
		SeleniumUtils.clickUsingJs(driver, submitBtn);
	}
	public void fillLSD() {
		SeleniumUtils.enterText(driver, lsd1Txt, "12");
		SeleniumUtils.enterText(driver, lsd2Txt, "12");
		SeleniumUtils.enterText(driver, lsd3Txt, "12");
		SeleniumUtils.enterText(driver, lsd4Txt, "12");
		SeleniumUtils.enterText(driver, lsd5Txt, "12");
	}

	public void selectRecordToEdit(String companyName) {
		LOGGER.info("Record to be edit is " + companyName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'" + companyName + "')]/../preceding-sibling::div[2]")));
		driver.findElement(By.xpath("//div[contains(text(),'" + companyName + "')]/../preceding-sibling::div[2]"))
				.click();
	}

	public void editSites(String firstName, String lastName, String phone) {
		filterCompany(column, operator, getClientSiteIdValue());
		SeleniumUtils.clickUsingJs(driver, selectClientSiteId);
		SeleniumUtils.clickUsingJs(driver, deleteContactBtn);
		SeleniumUtils.clickUsingJs(driver, addNewContactBtn);
		createContact(firstName, lastName, phone);
		SeleniumUtils.clickUsingJs(driver, siteSubmitBtn);
		Assert.assertTrue(siteModifiedPopUp.isDisplayed(), "Sites modified successfully");

	}
}
