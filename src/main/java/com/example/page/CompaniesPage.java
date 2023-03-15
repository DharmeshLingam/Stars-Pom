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

public class CompaniesPage {

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger();

	// Initializing the Page Objects:

	public CompaniesPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	Faker faker = new Faker(new Locale("en-CA"));

	@FindBy(xpath = "//h1[normalize-space()='Companies']")
	WebElement companiesHeader;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Filters']")
	WebElement filtersBtn;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Columns']")
	WebElement columnsBtn;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Density']")
	WebElement densityBtn;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Export']")
	WebElement exportBtn;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Add New']")
	WebElement addNewBtn;

	@FindBy(xpath = "//*[normalize-space()='Add New Company']")
	WebElement addNewCompany;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()=' Allocation']")
	WebElement allocationBtn;

	@FindBy(xpath = "//h1[text()='Companies']/..//*[text()='Merge']")
	WebElement mergeBtn;
	
	@FindBy(xpath = "//button[@data-rct-item-id='0 - 9']")
	WebElement numbersCompanies;
	
	@FindBy(xpath = "(//button[@data-rct-item-id='0 - 9'])[2]")
	WebElement seconnNumbersCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='A - C']")
	WebElement ACCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='D - F']")
	WebElement DFCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='G - I']")
	WebElement GICompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='J - L']")
	WebElement JLCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='M - O']")
	WebElement MOCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='P - R']")
	WebElement PRCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='S - U']")
	WebElement SUCompanies;
	
	@FindBy(xpath = "//button[@data-rct-item-id='V - Z']")
	WebElement VZCompanies;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeBtn;

	@FindBy(xpath = "//input[@id='free-solo-demo']")
	WebElement parentCompanyTxt;

	@FindBy(xpath = "//input[@id='name']")
	WebElement companyNameTxt;

	@FindBy(xpath = "//input[@id='billingContactFname']")
	WebElement firstNameTxt;

	@FindBy(xpath = "//input[@id='billingContact']")
	WebElement editFirstNameTxt;

	@FindBy(xpath = "//input[@id='billingContact']")
	WebElement lastNameTxt;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement addressTxt;

	@FindBy(xpath = "//input[@id='phone1']")
	WebElement phoneTxt;

	@FindBy(xpath = "//input[@id='city']")
	WebElement cityTxt;

	@FindBy(xpath = "//div[@id='mui-component-select-province']")
	WebElement provinceBtn;

	@FindBy(xpath = "//input[@id='postalCode']")
	WebElement postalCodeTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addBtn;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//input[@id='url']")
	WebElement companyUrlTxt;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTxt;

	@FindBy(xpath = "//input[@id='division']")
	WebElement divisionTxt;

	@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[1]")
	WebElement filterColumnsDropdown;

	@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[2]")
	WebElement filterOperatorDropdown;

	@FindBy(xpath = "//input[@placeholder='Filter value']")
	WebElement filterValueTxt;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[@class='MuiDataGrid-columnsPanel css-esvwh7']//div//span[contains(@class,'MuiTypography-root MuiTypography-body')]")
	List<WebElement> listColumns;
	
	@FindBy(xpath = "//div[contains(text(),'New company added successfully')]")
	WebElement successPopUp;

	private String randomNumber;

	String column = "name";
	String operator = "contains";

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public boolean verifyCompaniesLabel() {
		return companiesHeader.isDisplayed();
	}

	public void verifyColumnsList() {

		SeleniumUtils.click(driver, columnsBtn);
		List<String> expectedColumnsList = Arrays.asList("Address *", "Address 2 *", "Allocation", "Billing Contact *", "City *", "Company URL *", "Country *", "Created By", "Created Date", "Division", "ECC", "Edit", "Email", "Fixed Fee Billing", "Flat Fee Site Reg – Unlimited Perm and Temp (replaces current ‘Fixed Fee Billing)", "Invoice Notes", "Modified Date", "Name *", "Not To Be Billed", "Notes", "PO Number", "Parent Company", "Phone", "Phone Alt.", "Postal Code *", "Province *", "Requires AFE", "Requires Allocation", "Site Reg – Limited Perm and/or Temp", "Status", "Vigilant Suite (A combination of 3, 4 & 6 above)", "WAMS", "invoice Method");
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

	public void verifyCompaniesColumnsLabels() {
		filtersBtn.isDisplayed();
		columnsBtn.isDisplayed();
		densityBtn.isDisplayed();
		exportBtn.isDisplayed();
		addNewBtn.isDisplayed();
		mergeBtn.isDisplayed();
	}

	public void filterCompany(String column, String operator, String value) {
		SeleniumUtils.click(driver, filtersBtn);
		SeleniumUtils.selectByValue(driver, filterColumnsDropdown, column);
		SeleniumUtils.selectByValue(driver, filterOperatorDropdown, operator);
		SeleniumUtils.enterText(driver, filterValueTxt, value);
		SeleniumUtils.click(driver, companiesHeader);
	}

	public void selectProvince(String name) {
		SeleniumUtils.click(driver, provinceBtn);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='" + name + "']")));
		driver.findElement(By.xpath("//li[normalize-space()='" + name + "']")).click();
	}

	public void createNewCompany(String companyName, String firstName, String lastName, String companyUrl, String email,
			String address, String phone, String city, String province, String postalCode) {
		SeleniumUtils.clickUsingJs(driver, addNewBtn);
		String randomNumber = TestUtil.getRandomString();
		setRandomNumber(randomNumber);
		companyName = companyName + randomNumber;
		SeleniumUtils.enterText(driver, companyNameTxt, companyName);
		SeleniumUtils.enterText(driver, firstNameTxt, firstName);
		SeleniumUtils.enterText(driver, lastNameTxt, lastName);
		SeleniumUtils.enterText(driver, companyUrlTxt, companyUrl);
		SeleniumUtils.enterText(driver, emailTxt, email);
		SeleniumUtils.enterText(driver, addressTxt, address);
		SeleniumUtils.enterText(driver, phoneTxt, phone);
		SeleniumUtils.enterText(driver, cityTxt, city);
		selectProvince(province);
		SeleniumUtils.enterText(driver, postalCodeTxt, postalCode);
		SeleniumUtils.clickUsingJs(driver, addBtn);
		//Assert.assertTrue(successPopUp.isDisplayed(), "Company created successfully");
		SeleniumUtils.clickCoordinates(driver);
	}

	public void selectRecordToEdit(String companyName) {
		LOGGER.info("Record to be edit is " + companyName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'" + companyName + "')]/../preceding-sibling::div[2]")));
		driver.findElement(By.xpath("//div[contains(text(),'" + companyName + "')]/../preceding-sibling::div[2]"))
				.click();
	}

	public void editCompany(String companyName, String firstName, String lastName, String companyUrl, String email,
			String address, String phone, String city, String province, String postalCode) {
		filterCompany(column, operator, companyName + getRandomNumber());
		selectRecordToEdit(companyName + getRandomNumber());
		SeleniumUtils.enterText(driver, editFirstNameTxt, firstName);
		SeleniumUtils.enterText(driver, postalCodeTxt, postalCode);
		SeleniumUtils.clickUsingJs(driver, submitBtn);

	}

	public void mergeCompanies(String companyName ) {
		SeleniumUtils.clickUsingJs(driver, mergeBtn);
		companyName=companyName + getRandomNumber();
		  char ch=companyName.charAt(0);    
		    switch(ch)  
		    {  
		        case 'A':
		        case 'B':
		        case 'C':
		        	SeleniumUtils.clickUsingJs(driver, ACCompanies);
		            break;  
		        case 'D':
		        case 'E':
		        case 'F':
		        	SeleniumUtils.clickUsingJs(driver, DFCompanies); 
		            break;  
		        case 'G':
		        case 'H':
		        case 'I':   
		        	SeleniumUtils.clickUsingJs(driver, GICompanies); 
		            break;  
		        case 'J':
		        case 'K':
		        case 'L':   
		        	SeleniumUtils.clickUsingJs(driver, JLCompanies); 
		            break;  
		        case 'M':
		        case 'N':
		        case 'O': 
		        case 'P':
		        case 'Q':
		        case 'R':  
		        	SeleniumUtils.clickUsingJs(driver, MOCompanies);
		            break;  
		        case 'S':
		        case 'T':
		        case 'U':   
		        	SeleniumUtils.clickUsingJs(driver, SUCompanies); 
		            break;  
		        case 'W':
		        case 'X':
		        case 'Z': 
		        	SeleniumUtils.clickUsingJs(driver, SUCompanies); 
		            break;  
		        default:   
		            System.out.println("Name is not starting with alphabet"); 
		            SeleniumUtils.clickUsingJs(driver,numbersCompanies); 
		    }
		    SeleniumUtils.clickUsingJs(driver,seconnNumbersCompanies);
			Actions builder = new Actions(driver);		    
		    WebElement from = driver.findElement(By.xpath("(//div[@data-rct-tree='tree-1']/ul//li/ul/li[@role='treeitem'])[1]"));
		    WebElement to = driver.findElement(By.xpath("(//div[@data-rct-tree='tree-2']/ul//li/ul/li[@role='treeitem'])[1]"));
			 	
			try {
				//Perform drag and drop
				Thread.sleep(5000);
				// Click and hold the source element, move it to the target element, and release
				builder.clickAndHold(from).moveToElement(to).release().build().perform();
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			SeleniumUtils.clickUsingJs(driver,closeBtn);
	}
}
