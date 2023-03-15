package com.example.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	private static final Logger LOGGER = LogManager.getLogger();

	public static void clickUsingJs(WebDriver driver, WebElement element) {
		//int timeWait = 5;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
		//WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
		//explicitWaitByElement.until(ExpectedConditions.visibilityOf(element));
		executor.executeScript("arguments[0].click();", element);
	}

	public static void enterText(WebDriver driver, WebElement webElement, String text) {
		int timeWait = 5;
		WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
		explicitWaitByElement.until(ExpectedConditions.visibilityOf(webElement));
		webElement.sendKeys(text);
		LOGGER.info("Entered Value for " + webElement.toString() + " is " + text);
	}

	public static void click(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(5000);
			int timeWait = 5;
			WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
			explicitWaitByElement.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView();", element);
			element.click();
		} catch (StaleElementReferenceException e) {
			int timeWait = 5;
			WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
			explicitWaitByElement.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView();", element);
			element.click();

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void selectByValue(WebDriver driver, WebElement element, String value) {
		int timeWait = 5;
		WebDriverWait explicitWaitByElement = new WebDriverWait(driver, timeWait);
		explicitWaitByElement.until(ExpectedConditions.visibilityOf(element));
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (StaleElementReferenceException ex) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
	}
	public static void clickCoordinates(WebDriver driver) {
		Actions actions = new Actions(driver); 
		actions.moveByOffset(10, 10).click(); 
		actions.build().perform();
	}


}
