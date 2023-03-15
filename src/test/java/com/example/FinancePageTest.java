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


public class FinancePageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "ClientUser";
	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		homePage.clickOnFinanceLink();
		LOGGER.info("Login successfully");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1)
	public void verifyFinancePageTitleTest(){
		Assert.assertTrue(financePage.verifyBillingLabel());
		LOGGER.info("Verified finance page title successfully");

	}
	
	@Test(priority=2)
	public void verifyFinancePageColumnsTest(){
		financePage.verifyFinancePageLabels();
		LOGGER.info("Verified finance page columns successfully");

	}
	
	

}
