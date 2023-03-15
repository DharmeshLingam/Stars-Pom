package com.example;

import static com.example.utils.PropertyLoader.returnConfigValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.page.SitesMandatorypage;
import com.example.utils.BaseTest;
import com.example.utils.TestUtil;

public class SitesMandatorypageTest extends BaseTest{
	private static final Logger LOGGER = LogManager.getLogger();
	String sheetName = "AuditLog";
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		LOGGER.info("Login successfully");
	}	 
	
	@Test(priority =1)
	public void AddnewContact() {
		sm.Startsites();
		sm.addNewcontact();
		sm.addContactinfo();
		sm.deleteSite();
		LOGGER.info("New Site added page title successfully");

}
	@Test(priority =2)
	public void mandatorytest() {
		sm.validateNewcontact();
		LOGGER.info("Verified New Contact Mandatory Fields successfully");
	}
	@Test(priority =3)
	public void verifyToastTest() {
		
		sm.Startsites();
		sm.Startsites();
		sm.verifyToastmessage();
		LOGGER.info("Verified Sites Toast Message successfully");
	}
	
	@Test (priority =4)
	public void addnewsite() {
	sm.validatesitemandatoryfields();
	LOGGER.info("Verified New site Mandatory Fields successfully");
	}
	
	@Test (priority =5)
	public void newsiteidTest() {
		sm.validatesitemandatoryfields();
		sm.newSitetest();
		LOGGER.info("Verified New Site id Test successfully");
}
	
	
	@Test (priority =6)
	public void startBilling() {
		
		sm.validatesitemandatoryfields();
		sm.startBilling();
		LOGGER.info("Verified New Billing Mandatory Fields successfully");
	}
	@Test (priority =7)
	public void startlocation() {
		sm.validatesitemandatoryfields();
		sm.Startlocationt();
		sm.Regiondrpdown();
		sm.Industrydrpdown();
		sm.Licencetypedrpdown();
		sm.ActivityTypedrpdown();
		sm.PrimaryTypedrpdown();
		LOGGER.info("Verified Location Drop down Fields successfully");
	}
	
	@Test (priority =8)
	public void safetytest() {
		sm.validatesitemandatoryfields();
		sm.startSafety();
		LOGGER.info("Verified Safety list successfully");
	}
}
