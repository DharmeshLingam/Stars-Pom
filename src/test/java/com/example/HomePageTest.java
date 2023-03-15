package com.example;

import static com.example.utils.PropertyLoader.returnConfigValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.utils.BaseTest;


public class HomePageTest extends BaseTest {
	private static final Logger LOGGER = LogManager.getLogger();

	
	@BeforeMethod
	public void setUp() {
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		LOGGER.info("Login successfully");
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("Title is "+homePageTitle);
		Assert.assertEquals(homePageTitle, "STARS Resq","Home page title not matched");
		LOGGER.info("Verified Home Page Title");

	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
		LOGGER.info("Verified Valid User login successfully");

	}
	
	@Test(priority=3)
	public void verifyHeadersLinkTest(){
		homePage.verifyHeaders();
		LOGGER.info("Verified headers on homepage successfully");

	}
	
	
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
