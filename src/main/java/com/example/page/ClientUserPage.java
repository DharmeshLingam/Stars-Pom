package com.example.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.example.selenium.SeleniumUtils;

public class ClientUserPage  {

	@FindBy(xpath = "//h1[normalize-space()='Client Users']")
	WebElement clientUserHeader;
	
	@FindBy(xpath = "//button[normalize-space()='Filters']")
	WebElement filtersBtn;

	@FindBy(xpath = "//button[normalize-space()='Columns']")
	WebElement columnsBtn;

	@FindBy(xpath = "//*[text()='Density']")
	WebElement densityBtn;

	@FindBy(xpath = "//*[text()='Export']")
	WebElement exportBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Add New']")
	WebElement addNewBtn;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-columnsPanelRow css-fc3ngs']")
	List<WebElement> listColumns;
	
	
	// Initializing the Page Objects:
	private WebDriver driver;

	public ClientUserPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyClientUserLabel(){
		return clientUserHeader.isDisplayed();
	}
	
	public void verifyClientUserLabels() {
		filtersBtn.isDisplayed();
		columnsBtn.isDisplayed();
		densityBtn.isDisplayed();
		exportBtn.isDisplayed();
		addNewBtn.isDisplayed();
	}
	public void StartClientuser() {
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'CLIENT USERS')]")));
		WebElement Clientuser = driver.findElement(By.xpath("//li[contains(text(),'CLIENT USERS')]"));
		Clientuser.click();
		   if(Clientuser.isDisplayed()) {
		    	System.out.println("Clientuser Grid is Displayed");
		    	 }
		    else {
		    	System.out.println("Clientuser Grid is not Displayed");
		    }
		    
	}
	
	 public void verifyClientuserLabel() {		
			filtersBtn.isDisplayed();
			columnsBtn.isDisplayed();
			densityBtn.isDisplayed();
			exportBtn.isDisplayed();
	
		}
	 
		
	 public void verifyToastmessage() {
			WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement audit = driver.findElement(By.xpath("//div[@role='alert']"));
			audit.click();
			   if(audit.isDisplayed()) {
			    	System.out.println("Client user Toast is Displayed " + audit.getText());
			    	 }
			    else {
			    	System.out.println("Client user Toast not Displayed");
			    }
			   
		}
	 public void verifyClientuserColumnsList() {

			SeleniumUtils.click(driver, columnsBtn);
			List<String> expectedColumnsList = Arrays.asList("First Name", "Last Name", "Company", "Phone Number 1", "Extension",
					"Phone Number 2", "Extension 2", "Email", "Start Date", "End Date", "Active", "Force Password Reset",
					"Last Success full Login", "Disable Web Access", "Client ID");
			List<String> actualColumnsList = new ArrayList<String>();
			
			for (WebElement we : listColumns) {
				actualColumnsList.add(we.getText());
			}
			Collections.sort(expectedColumnsList);
			Collections.sort(actualColumnsList);
			
			Assert.assertEquals(actualColumnsList, expectedColumnsList, "Both list are equals");
			
		
		}

	
	

	
	
	

}
