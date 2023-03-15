package com.example;

import static com.example.utils.PropertyLoader.returnConfigValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.BaseTest;
import com.example.utils.TestUtil;


public class CompaniesPageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "Companies";
	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		homePage.clickOnCompaniesLink();
		LOGGER.info("Login successfully");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1)
	public void verifyCompaniesPageTitleTest(){
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
		LOGGER.info("Verified companies page title successfully");

	}
	
	@Test(priority=2)
	public void verifyCompaniesPageColumnsTest(){
	    companiesPage.verifyCompaniesColumnsLabels();
		LOGGER.info("Verified companies page columns successfully");

	}
	
	@Test(priority=3,dataProvider="getTestData")
	public void createNewCompanyTest(String companyName, String firstName,String lastName,String companyUrl,String email,String address,String phone,String city,String province,String postalCode){
		companiesPage.createNewCompany(companyName, firstName,lastName,companyUrl,email, address, phone, city, province, postalCode);
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
		LOGGER.info("New Company created successfully");
	}
	
	@Test(priority=4,dataProvider="getTestData")
	public void editCompanyTest(String companyName, String firstName,String lastName,String companyUrl,String email,String address,String phone,String city,String province,String postalCode){
		companiesPage.createNewCompany(companyName, firstName,lastName,companyUrl,email, address, phone, city, province, postalCode);
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
		LOGGER.info("New Company created successfully");
		companiesPage.editCompany(companyName, firstName,lastName,companyUrl,email, address, phone, city, province, postalCode);
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
		LOGGER.info("New Company edited successfully");
	}
	
	@Test(priority=5)
	public void verifyColumnsValuesTest(){
	    companiesPage.verifyColumnsList();
		LOGGER.info("Verified columns Values in columns tab successfully");

	}
	@Test(priority=6,dataProvider="getTestData")
	public void mergeCompanyTest(String companyName, String firstName,String lastName,String companyUrl,String email,String address,String phone,String city,String province,String postalCode){
		companiesPage.createNewCompany(companyName, firstName,lastName,companyUrl,email, address, phone, city, province, postalCode);
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
		LOGGER.info("New Company created successfully");
		companiesPage.mergeCompanies(companyName);
	}
	

}
