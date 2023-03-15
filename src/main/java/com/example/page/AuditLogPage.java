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

public class AuditLogPage  {

	@FindBy(xpath = "//h1[normalize-space()='Audit Log']")
	WebElement auditLogHeader;
	
	@FindBy(xpath = "//button[normalize-space()='Filters']")
	WebElement filtersBtn;

	@FindBy(xpath = "//button[normalize-space()='Columns']")
	WebElement columnsBtn;

	@FindBy(xpath = "//*[text()='Density']")
	WebElement densityBtn;

	@FindBy(xpath = "//*[text()='Export']")
	WebElement exportBtn;
	
	
	
	// Initializing the Page Objects:
	private WebDriver driver;

	public AuditLogPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyAuditLogLabel(){
		return auditLogHeader.isDisplayed();
	}
	
	public void verifyAuditLogsLabels() {
		filtersBtn.isDisplayed();
		columnsBtn.isDisplayed();
		densityBtn.isDisplayed();
		exportBtn.isDisplayed();
	}
	
	
	
	
	@FindBy(xpath = "//h1[normalize-space()='Audit Log']")
	WebElement auditHeader;
	
	@FindBy(xpath = "(//div[@class='MuiDataGrid-columnHeaderTitleContainer'])")
	List<WebElement> listColumns;
	

	
	
		public void StartAuditlog() {
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'AUDIT LOG')]")));
		WebElement audit = driver.findElement(By.xpath("//li[contains(text(),'AUDIT LOG')]"));
		audit.click();
		   if(audit.isDisplayed()) {
		    	System.out.println("Auditlog is Displayed");
		    	 }
		    else {
		    	System.out.println("Auditlog not Displayed");
		    }
		   
		 
	}

		public void verifyauditLabel() {		
			filtersBtn.isDisplayed();
			columnsBtn.isDisplayed();
			densityBtn.isDisplayed();
			exportBtn.isDisplayed();
			
		
		}
		public boolean verifyAuditlog() {
			return auditHeader.isDisplayed();
		}
		public void verifyToastmessage() {
			WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement audit = driver.findElement(By.xpath("//div[@role='alert']"));
			audit.click();
			   if(audit.isDisplayed()) {
			    	System.out.println("Audit Toast is Displayed " + audit.getText());
			    	 }
			    else {
			    	System.out.println("Audit Toast not Displayed");
			    }
		}
	
		
		public void verifyAuditlogColumnsList() {

//			SeleniumUtils.click(driver, columnsBtn);
			List<String> expectedColumnsList = Arrays.asList("Type", "User", "Data Logged", "Date of Log", "RemoteIP",
					"LogID");
			List<String> actualColumnsList = new ArrayList<String>();
			for (WebElement we : listColumns) {
				actualColumnsList.add(we.getText());
			}
			Collections.sort(expectedColumnsList);
			Collections.sort(actualColumnsList);
			
			Assert.assertEquals(actualColumnsList, expectedColumnsList, "Both list are equals");
			
            System.out.println("Audit log Column contains Headers " + actualColumnsList);
		}
	

	
	
	

}
