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



public class AuditLogPageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "AuditLog";
	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		homePage.clickOnAuditLogLink();
		LOGGER.info("Login successfully");
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1)
	public void verifyAuditLogPageTitleTest(){
		Assert.assertTrue(auditLogPage.verifyAuditLogLabel());
		LOGGER.info("Verified audit Logs page title successfully");

	}
	
	@Test(priority=2)
	public void verifyCompaniesPageColumnsTest(){
		auditLogPage.verifyAuditLogsLabels();
		LOGGER.info("Verified audit Log page columns successfully");

	}
	
	@Test (priority=3)
	public void openAuditlog() {
	auditLogPage.verifyauditLabel();
	Assert.assertTrue(auditLogPage.verifyAuditlog());
	LOGGER.info("Verified Audit label successfully");
}
	
	@Test (priority=4)
	public void verifytoast() {
		auditLogPage.StartAuditlog();
		auditLogPage.verifyToastmessage();
		Assert.assertTrue(auditLogPage.verifyAuditlog());
		LOGGER.info("Verified Audit Toast Message successfully");
	}
	@Test (priority=5)
	public void verifygridcontainsTest() {
	
		auditLogPage.StartAuditlog();
		auditLogPage.verifyAuditlogColumnsList();
		Assert.assertTrue(auditLogPage.verifyAuditlog());
		LOGGER.info("Verified Audit Grid Contains successfully");
	}
	

}
