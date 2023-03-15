package com.example;

import static com.example.utils.PropertyLoader.returnConfigValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.utils.BaseTest;

public class LoginPageTest extends BaseTest{
	private static final Logger LOGGER = LogManager.getLogger();

	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "");
		LOGGER.info("Verified login page title");

	}
	
	@Test(priority=2)
	public void starsVigilantLogoImageTest(){
		boolean flag = loginPage.validateStarsVigilantImage();
		Assert.assertTrue(flag,"Logo verified successfully");
		LOGGER.info("Logo verified successfully");

	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.login(returnConfigValue("username"), returnConfigValue("password"));
		LOGGER.info("Login successfully");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
