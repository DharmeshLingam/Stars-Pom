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


public class SitesPageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "Sites";
	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		homePage.clickOnSitesLink();
		LOGGER.info("Login successfully");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1)
	public void verifySitesPageTitleTest(){
		Assert.assertTrue(sitesPage.verifySitesLabel());
		LOGGER.info("Verified sites page title successfully");

	}
	
	@Test(priority=2)
	public void verifySitesPageColumnsTest(){
		sitesPage.verifySitesColumnsLabels();
		LOGGER.info("Verified sites page columns successfully");

	}
	
	@Test(priority=3,dataProvider="getTestData")
	public void createNewSiteTest(String firstName,String lastName,String isCaller,String notes,String billingCompany,String phone,String leaseHolder,String leaseHolderCompany){
		sitesPage.createNewSite(firstName,lastName,phone,isCaller, notes, billingCompany, leaseHolder, leaseHolderCompany);
		Assert.assertTrue(sitesPage.verifySitesLabel());
		LOGGER.info("New Site created successfully");
	}
	
	@Test(priority=4,dataProvider="getTestData")
	public void editSiteTest(String firstName,String lastName,String isCaller,String notes,String billingCompany,String phone,String leaseHolder,String leaseHolderCompany){
		sitesPage.createNewSite(firstName,lastName,phone,isCaller, notes, billingCompany, leaseHolder, leaseHolderCompany);
		Assert.assertTrue(sitesPage.verifySitesLabel());
		LOGGER.info("New Site created successfully");
		sitesPage.editSites(firstName,lastName,phone);
		Assert.assertTrue(sitesPage.verifySitesLabel());
		LOGGER.info("New Site edited successfully");
	}
	
	@Test(priority=5)
	public void verifyColumnsValuesTest(){
		sitesPage.verifyColumnsList();
		LOGGER.info("Verified columns Values in columns tab successfully");

	}
	

}
