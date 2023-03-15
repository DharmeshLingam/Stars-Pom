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



public class ClientUsersPageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "ClientUser";
	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		homePage.clickOnClientUserLink();
		LOGGER.info("Login successfully");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1)
	public void verifyClientUserPageTitleTest(){
		Assert.assertTrue(clientUserPage.verifyClientUserLabel());
		LOGGER.info("Verified client User page title successfully");

	}
	
	@Test(priority=2)
	public void verifyClientUserPageColumnsTest(){
		clientUserPage.verifyClientUserLabels();
		LOGGER.info("Verified client user page columns successfully");

	}
	
	@Test (priority=3)
	public void ClientusergridTest() {
	clientUserPage.verifyClientuserLabel();
	Assert.assertTrue(clientUserPage.verifyClientUserLabel());
	LOGGER.info("Verified client User Labels successfully");
	
	}	
	@Test (priority=4)
	public void verifytoast() {
		clientUserPage.StartClientuser();
		clientUserPage.verifyToastmessage();
		Assert.assertTrue(clientUserPage.verifyClientUserLabel());
		LOGGER.info("Verified client User Toast Message displayed successfully");
}
	
	
	@Test (priority=5)
	public void verifygridcontainsTest() {
		clientUserPage.verifyClientuserColumnsList();
		LOGGER.info("Verified client User grid list successfully");
	}
	
	
	

}
