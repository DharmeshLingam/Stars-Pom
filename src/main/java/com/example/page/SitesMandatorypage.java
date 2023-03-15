package com.example.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.example.selenium.SeleniumUtils;

public class SitesMandatorypage {
	private WebDriver driver;

	public SitesMandatorypage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),'Safety')]")
	WebElement safetybtn;
	
	@FindBy(xpath = "(//span[@class='MuiSwitch-root MuiSwitch-sizeMedium css-ecvcn9'])[17]")
	WebElement h2schkbx;
	
	@FindBy(xpath = "//button[contains(text(),'H2S Monitor')]")
	WebElement h2smonitorchkbx;
	
	@FindBy(xpath = "//button[contains(text(),'Flammable Liquids')]")
	WebElement flammablechkbx;
	
	@FindBy(xpath = "(//button[normalize-space()='High Pressure Lines'])")
	WebElement highpressurechkbx;
	
	@FindBy(xpath = "//button[contains(text(),'Corrosives')]")
	WebElement corrosivechkbx;
	
	@FindBy(xpath = "//*[@placeholder='Additional Crew Hazards']")
	WebElement Additionalcrewtxtbx;
	
	@FindBy(xpath = "//button[contains(text(),'MTC ')]")
	WebElement mtcchckbx;
	
	@FindBy(xpath = "//button[contains(text(),'AED')]")
	WebElement aedchkbx;
	
	@FindBy(xpath="//textarea[@placeholder='Medical Training Available on Site']")
	WebElement Medicaltraintxtbx;
	
	public void startBilling() {
		safetybtn.click();
		boolean l1 = h2schkbx.isDisplayed();
		System.out.println(l1 +  " H2S checkbox  is Displayed");
		boolean s1 = h2smonitorchkbx.isDisplayed();
		System.out.println(s1 +  " H2S monitor checkbox is Displayed");
		boolean b1 = flammablechkbx.isDisplayed();;
		System.out.println(b1 +  " Flammable checkbox is Displayed");
		boolean l2 = highpressurechkbx.isDisplayed();
		System.out.println(l2 +  " High Pressure checkbox is Displayed");
		boolean s2 = corrosivechkbx.isDisplayed();
		System.out.println(s2 +  " Corrosive checkbox is Displayed");
		boolean l3 = Additionalcrewtxtbx.isDisplayed();
		System.out.println(l3 +  " Additional crew text box  is Displayed");
		boolean s3 = mtcchckbx.isDisplayed();
		System.out.println(s3 +  " Mtc checkbox is Displayed");
		boolean b3 = aedchkbx.isDisplayed();;
		System.out.println(b3 +  " AED checkbox is Displayed");
		boolean l4 = Medicaltraintxtbx.isDisplayed();
		System.out.println(l4 +  " Medical Training textbox is Displayed");
		
	
		
	}	
	
	
	private String randomNumber;

	String column = "name";
	String operator = "contains";

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}
	
	public void Startsites() {
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'SITES')]")));
		WebElement sites = driver.findElement(By.xpath("//li[contains(text(),'SITES')]"));
		   sites.click();
		   if(sites.isDisplayed()) {
		    	System.out.println("Sites Grid is Displayed");
		    	 }
		    else {
		    	System.out.println("Sites Grid not Displayed");
		    }
		   
		   
	}
	@FindBy(xpath = "(//input[@id='name'])[4]")
	WebElement fname;
	
	@FindBy(xpath = "(//input[@id='lastName'])[1]")
	WebElement lname;
	
	@FindBy(xpath = "//button[text()='Add New']")
	WebElement addNew;
	
	@FindBy(xpath = "//h2[text()='New Contact - ']")
	WebElement newContactid;
	
	@FindBy(xpath = "(//select[@class='form-select'])[12]")
	WebElement medTranlevel;
	
	@FindBy(xpath = "//input[@name='isPrimary']")
	WebElement Primary;
	
	@FindBy(xpath = "//input[@name='isCloseSite']")
	WebElement closeSite;
	
	@FindBy(xpath = "//input[@name='isEmergency']")
	WebElement emergency;
	
	@FindBy(xpath = "(//textarea[@id='notes'])[3]")
	WebElement notes;
	
	@FindBy(xpath = "//input[@id='phoneNumber']")
	WebElement phoneNum;
	
	@FindBy(xpath = "//button[@type='button'][normalize-space()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "(//div[@class='Toastify'])[1]")
	WebElement toast;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement Cancel;
	
	@FindBy(xpath = "(//button[normalize-space()='Yes.'])[1]")
	WebElement yesCancel;
	
	@FindBy(xpath = "(//div[@class='Toastify'])[1]")
	WebElement deleteToast;
	
	
	public void addNewcontact() {
		addNew.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New Contact - ']")));
		newContactid.isDisplayed();
		   if(newContactid.isDisplayed()) {
		    	System.out.println("newContactid is Displayed");
		    	 }
		    else {
		    	System.out.println("newContactid not Displayed");
		    }
		   
	
	}
	public void addContactinfo() {
		
		fname.sendKeys("rnane");
		lname.sendKeys("mew");
		Primary.click();
		closeSite.click();
		emergency.click();
		notes.sendKeys("Filled by automation");
		phoneNum.sendKeys("9874563210");
		submit.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='Toastify'])[1]")));
		toast.isDisplayed();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
 		By.xpath("(//div)[8]")));
 		WebElement text = driver.findElement(By.xpath("(//div)[8]"));
    	System.out.println(text.getText());
		 if(toast.isDisplayed()) {
		    	System.out.println("Newcontact alert is Displayed");
		    	 }
		    else {
		    	System.out.println("Newcontact alert not Displayed");
		    }
	}
	public void selectContactToEdit() {
	//	LOGGER.info("Record to be edit is " + companyName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//div[contains(text(),'" + fname + "')]/../preceding-sibling::div[2]")));
		driver.findElement(By.xpath("//div[contains(text(),'" + fname + "')]/../preceding-sibling::div[2]"))
				.click();
	}

	
     public void deleteSite() {
    	 Cancel.click();
    	 WebDriverWait wait = new WebDriverWait(driver, 30);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(
 		By.xpath("(//button[normalize-space()='Yes.'])[1]")));
 		yesCancel.click();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(
 		By.xpath("(//div[@class='Toastify'])[1]")));
 		deleteToast.isDisplayed();
 		wait.until(ExpectedConditions.visibilityOfElementLocated(
 				By.xpath("//*[contains(text(),'Process for Add new Site canceled. Site Deleted')]")));
 		WebElement tex = driver.findElement(By.xpath("//*[contains(text(),'Process for Add new Site canceled. Site Deleted')]"));
    	System.out.println(tex.getText());
		 if(toast.isDisplayed()) {
		    	System.out.println("deleteToast is Displayed");
		    	 }
		    else {
		    	System.out.println("deleteToast not Displayed");
		    	
		    	
		    
}
     }
	 public void validateNewcontact() {
		 Startsites();
		 addNewcontact();
		 submit.click();
		 WebElement firstname = driver.findElement(By.xpath("(//p[@id='name-helper-text'])[1]"));
		 String ftext = firstname.getText();
		 System.out.println(ftext);
		 
		 WebElement lastname = driver.findElement(By.xpath("(//p[@id='lastName-helper-text'])[1]"));
		 String ltext = lastname.getText();
		 System.out.println(ltext);
		 
		 WebElement phonenum = driver.findElement(By.xpath("(//p[@id='phoneNumber-helper-text'])[1]"));
		 String ptext = phonenum.getText();
		 System.out.println(ptext);
		 
		 WebElement checkbox = driver.findElement(By.xpath("(//h5[contains(text(),'At least one of the Caller, Primary, Emergency or ')])[1]"));
		 String c = checkbox.getText();
		 System.out.println(c);
		 
		            boolean l1 = Phne2.isDisplayed();
					System.out.println(l1 +  " Phone number-2  is Displayed");
					boolean s1 = extnsntxtbx.isDisplayed();
					System.out.println(s1 +  " Extension box is Displayed");
					boolean b1 = companytxtbx.isDisplayed();;
					System.out.println(b1 +  " Company text box is Displayed");
					boolean l2 = position.isDisplayed();
					System.out.println(l2 +  " Position textbox is Displayed");
					boolean s2 = notestxtbox.isDisplayed();
					System.out.println(s2 +  " Notes textbox is Displayed");
					PhonenumType1drpdown();
					PhonenumType2drpdown();
					Preferreddrpdown();
					Medicaltrainingdrpdown();
					
		 

}
	 public void filtersites(String column, String operator, String value) {
		 Startsites();
		 WebDriverWait wait = new WebDriverWait(driver, 30);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(
	 		By.xpath("//button[@aria-label='Show filters']")));
	 		filtersBtn.click();
	 		SeleniumUtils.click(driver, filtersBtn);
			SeleniumUtils.selectByValue(driver, filterColumnsDropdown, column);
			SeleniumUtils.selectByValue(driver, filterOperatorDropdown, operator);
			SeleniumUtils.enterText(driver, filterValueTxt, value);
			SeleniumUtils.click(driver, companiesHeader);
		}
	 @FindBy(xpath = "//button[@aria-label='Show filters']")
		WebElement filtersBtn;
		
		@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[1]")
		WebElement filterColumnsDropdown;
		
		@FindBy(xpath = "(//select[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe'])[2]")
		WebElement filterOperatorDropdown;
		
		@FindBy(xpath = "//input[@placeholder='Filter value']")
		WebElement filterValueTxt;
		
		@FindBy(xpath = "//h1[normalize-space()='Sites']")
		WebElement companiesHeader;
		
		public void verifyToastmessage() {
			WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement audit = driver.findElement(By.xpath("//div[@role='alert']"));
			audit.click();
			   if(audit.isDisplayed()) {
			    	System.out.println("Sites Toast is Displayed " + audit.getText());
			    	 }
			    else {
			    	System.out.println("Sites Toast not Displayed");
			    }
		}
		@FindBy(xpath = "(//input[@id='clientSiteId'])[1]")
		WebElement clientid;
		
		@FindBy(xpath ="(//button[@type='button'][normalize-space()='Cancel'])[4]")
		WebElement cancel;
		
		@FindBy(xpath = "(//button[normalize-space()='Submit'])[1]")
		WebElement Submit1;
		@FindBy(xpath = "//*[@id=\"sites-tabs-tabpane-0\"]/form/div[1]/div[5]/label/button/button")
		WebElement addcontact;
		@FindBy(xpath = "//h2[starts-with(text(),'Creating new Site | Client Site ID: ')]")
		WebElement sitetittle;
//		@FindBy(xpath = "//h1[normalize-space()='Sites']")
//		WebElement
//		@FindBy(xpath = "//h1[normalize-space()='Sites']")
//		WebElement
//		
		
		public void validatesitemandatoryfields() {
			WebDriverWait wait = new WebDriverWait(driver,30);
			Startsites();
			addNewcontact();
//			wait.until(ExpectedConditions.visibilityOf(fname));
//			fname.click();
//			lname.click();
//			Primary.click();
			submit.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'][normalize-space()='Cancel'])[4]")));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Cancel']"))).click();
			
			if (cancel.isDisplayed()) {
				System.out.println("cancel displayed");
				cancel.click();
			}else {
				System.out.println("cancel not displayed");
			}			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[2]")));
			WebElement clid = driver.findElement(By.xpath("//h2[2]"));
			 String ftext = clid.getText();
			 System.out.println(ftext);
			 WebElement clientid = driver.findElement(By.xpath("(//input[@id='clientSiteId'])[1]"));
			 String ftext1 = clientid.getText();
		     System.out.println(ftext1);
		      Submit1.click();
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
			WebElement audit = driver.findElement(By.xpath("//div[@role='alert']"));
			audit.click();
			   if(audit.isDisplayed()) {
			    	System.out.println("Sites Toast is Displayed " + audit.getText());
			    	 }
			    else {
			    	System.out.println("Sites Toast not Displayed");
			    }
			   wait.until(ExpectedConditions.visibilityOfElementLocated(
				 		By.xpath("//*[@id=\"sites-tabs-tabpane-0\"]/form/div[1]/div[5]/label/button/button")));
			   addcontact.click();
			   addContactinfo();
			   newSitetest();
		// Assert.assertEquals(ftext, ftext1);
			 
			
		}
		
		@FindBy(xpath = "//h2[2]")
		WebElement sitetittle1;
		
		@FindBy(xpath = "(//input[@id='clientSiteId'])[1]")
		WebElement cid;
		
		@FindBy(xpath = "(//button[contains(text(),'Location')])[1]")
		WebElement locationbtn;
		
		@FindBy(xpath = "(//button[contains(text(),'Safety')])[1]")
		WebElement safetybtn1;
		
		@FindBy(xpath = "(//button[@role='tab'][normalize-space()='Billing'])[1]")
		WebElement billingbtn;
	
		@FindBy(xpath = "//input[@id='phoneNumber2']")
		WebElement Phne2;
		
		@FindBy(xpath = "(//input[@id='extension2'])[1]")
		WebElement extnsntxtbx;
		
		@FindBy(xpath = "//input[@id='company']")
		WebElement companytxtbx;
		
		@FindBy(xpath = "(//input[@id='position'])[2]")
		WebElement position;
		
		@FindBy(xpath = "(//textarea[@id='notes'])[3]")
		WebElement notestxtbox;
		
		public void newSitetest() {
		//	validatesitemandatoryfields();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[2]")));
			
			String expectedid = sitetittle1.getText();
			String actualid = cid.getText();
			System.out.println(actualid + expectedid );
			
			boolean l1 = locationbtn.isDisplayed();
			System.out.println(l1 +  " location is Displayed");
			boolean s1 = safetybtn.isDisplayed();
			System.out.println(s1 +  " Safety is Displayed");
			boolean b1 = billingbtn.isDisplayed();;
			System.out.println(b1 +  " Billing is Displayed");
				
			
			//Assert.assertEquals(expectedid, actualid);
		}
		public void PhonenumType1drpdown() {
			String arr[] = { "Cell", "MTC", "Landline", "Satellite"};
			WebElement dropDown = driver.findElement(By.xpath("(//select[@aria-label='Default select example'])[2]"));
			Select s = new Select(dropDown);
			List<WebElement> options=  s.getOptions();
			boolean match  = false;
			for (int i=0; i<options.size(); i++) {
				System.out.println(options.get(i).getText()+" == "+ arr[i]);
				if(options.get(i).getText().equals(arr[i])) {
					
					match = true;
				}
				Assert.assertTrue(match);
		}
	}

	public void PhonenumType2drpdown() {
			String arr[] = { "Cell", "MTC", "Landline", "Satellite"};
			WebElement dropDown = driver.findElement(By.xpath("(//select[@aria-label='Default select example'])[3]"));
			Select s = new Select(dropDown);
			List<WebElement> options=  s.getOptions();
			boolean match  = false;
			for (int i=0; i<options.size(); i++) {
				System.out.println(options.get(i).getText()+" == "+ arr[i]);
				if(options.get(i).getText().equals(arr[i])) {
					
					match = true;
				}
				Assert.assertTrue(match);
		}
	}
	public void Preferreddrpdown() {
			String arr[] = { "Email", "Phone"};
			WebElement dropDown = driver.findElement(By.xpath("(//select[@aria-label='Default select example'])[4]"));
			Select s = new Select(dropDown);
			List<WebElement> options=  s.getOptions();
			boolean match  = false;
			for (int i=0; i<options.size(); i++) {
				System.out.println(options.get(i).getText()+" == "+ arr[i]);
				if(options.get(i).getText().equals(arr[i])) {
					
					match = true;
				}
				Assert.assertTrue(match);
		}
	}
	public void Medicaltrainingdrpdown() {
			String arr[] = { "", "Standard First Aid", "OFA 3", "EMR", "SEMT(PCP)", "EMT-A(ACP)", "EMT-A", "EMT-P(ACP)", "EMT-P", "RN", "PA"};
			WebElement dropDown = driver.findElement(By.xpath("(//select[@aria-label='Default select example'])[5]"));
			Select s = new Select(dropDown);
			List<WebElement> options=  s.getOptions();
			boolean match  = false;
			for (int i=0; i<options.size(); i++) {
				System.out.println(options.get(i).getText()+" == "+ arr[i]);
				if(options.get(i).getText().equals(arr[i])) {
					
					match = true;
				}
				Assert.assertTrue(match);
		}
	}
	public void Regiondrpdown() {
		String arr[] = {  "AB", "BC", "SASK", "MB", "NWT", "Other" };
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='regionID']"));
		Select s = new Select(dropDown);
		List<WebElement> options=  s.getOptions();
		boolean match  = false;
		for (int i=0; i<options.size(); i++) {
			System.out.println(options.get(i).getText()+" == "+ arr[i]);
			if(options.get(i).getText().equals(arr[i])) {
				
				match = true;
			}
			Assert.assertTrue(match);
	}
	}	
	public void Industrydrpdown() {
		String arr[] = {  "None", "Oil & Gas", "Electricity", "Mining", "Logging", "Other" };
		WebElement dropDown = driver.findElement(By.xpath("(//select[@name='industryTypeId'])[1]"));
		Select s = new Select(dropDown);
		List<WebElement> options=  s.getOptions();
		boolean match  = false;
		for (int i=0; i<options.size(); i++) {
			System.out.println(options.get(i).getText()+" == "+ arr[i]);
			if(options.get(i).getText().equals(arr[i])) {
				
				match = true;
			}
			Assert.assertTrue(match);
	}
}
	public void Licencetypedrpdown() {
		String arr[] = {  "Well", "Facility", "Pipeline", "No License" };
		WebElement dropDown = driver.findElement(By.xpath("(//select[@class='form-select'])[5]"));
		Select s = new Select(dropDown);
		List<WebElement> options=  s.getOptions();
		boolean match  = false;
		for (int i=0; i<options.size(); i++) {
			System.out.println(options.get(i).getText()+" == "+ arr[i]);
			if(options.get(i).getText().equals(arr[i])) {
				
				match = true;
			}
			Assert.assertTrue(match);
	}
}
	public void ActivityTypedrpdown() {
		String arr[] = {  "Other Construction", "Environmental Study", "Seismic", "Survey", "Abandonment", "Completions/Servicing", "Drilling/Servicing", "Frac", "Lease Construction", "Logging", "Rig Move", "Reclamation",
				"Remediation", "Turnaround", "Facility Construction", "Maintenance/Repair", "Battery", "Compressor Station", "Tie-in", "Pipeline Construction", "Pigging","Integrity digs", "Maintenance/Repair", "Facility"	};
		WebElement dropDown = driver.findElement(By.xpath("(//select[@name='activityTypeId'])[1]"));
		Select s = new Select(dropDown);
		List<WebElement> options=  s.getOptions();
		boolean match  = false;
		for (int i=0; i<options.size(); i++) {
			System.out.println(options.get(i).getText()+" == "+ arr[i]);
			if(options.get(i).getText().equals(arr[i])) {
				
				match = true;
			}
			Assert.assertTrue(match);
	}
}
	public void PrimaryTypedrpdown() {
		String arr[] = { "LSD", "PNG", "GPS"};
		WebElement dropDown = driver.findElement(By.xpath("(//select)[7]"));
		Select s = new Select(dropDown);
		List<WebElement> options=  s.getOptions();
		boolean match  = false;
		for (int i=0; i<options.size(); i++) {
			System.out.println(options.get(i).getText()+" == "+ arr[i]);
			if(options.get(i).getText().equals(arr[i])) {
				
				match = true;
			}
			Assert.assertTrue(match);
	}
}
	@FindBy(xpath = "(//button[contains(text(),'Location')])[1]")
	WebElement locationbtn1;
	
	@FindBy(xpath = "//button[normalize-space()='Show Temporary Activity']//input[@aria-label='Switch demo']")
	WebElement showtempchkbx;
	
	@FindBy(xpath = "(//label[normalize-space()='Region'])[1]")
	WebElement regiondrpdwnbtn;
	
	@FindBy(xpath = "(//label[normalize-space()='Industry Type'])[1]")
	WebElement industrydrpdwn;
	
	@FindBy(xpath = "(//input[@id='rigNumber'])[1]")
	WebElement rigtxtbx;
	
	@FindBy(xpath = "(//label[normalize-space()='License Type'])[1]")
	WebElement licencedrpdwn;
	
	@FindBy(xpath = "(//button[contains(text(),'Location')])[1]")
	WebElement activitydrpdwn;
	
	@FindBy(xpath = "//input[@name='isAccessibleByGround']")
	WebElement accesiblechckbx;
	
	@FindBy(xpath = "//button[normalize-space()='Designated Landing Zone']//input[@aria-label='Switch demo']")
	WebElement designatedchkbx;
	
	@FindBy(xpath = "//*[@id='accessibleByGroundDetails']")
	WebElement accessibletxtbx;
	
	@FindBy(xpath = "//*[@id='altLandingDetails']")
	WebElement landingtxtbx;
	
	@FindBy(xpath = "//*[@id='otherActivity']")
	WebElement otheractivitytxtbx;
	
	@FindBy(xpath = "//button[normalize-space()='Driving Directions']//input[@aria-label='Switch demo']")
	WebElement drivingchkbx;
	
	@FindBy(xpath = "//button[normalize-space()='Nearest Town Verified']//input[@aria-label='Switch demo']")
	WebElement nearestchkbx;
	
	@FindBy(xpath = "(//label[normalize-space()='Primary Type'])[1]")
	WebElement primarydrpdwn;
	
	@FindBy(xpath = "(//button[normalize-space()='Fill GPS / PNG from this LSD'])[1]")
	WebElement fillgpsbtn;
	
	@FindBy(xpath = "(//button[normalize-space()='Load Verification Table'])[1]")
	WebElement loadverifbtn;
	
	
	
	
	
	public void Startlocationt() {
		locationbtn.click();
		boolean l1 = showtempchkbx.isDisplayed();
		System.out.println(l1 +  " Show temperorary activity checkbox is Displayed");
		boolean s1 = regiondrpdwnbtn.isDisplayed();
		System.out.println(s1 +  " Region dropdown is Displayed");
		boolean b1 = industrydrpdwn.isDisplayed();;
		System.out.println(b1 +  " Industry dropdown is Displayed");
		boolean l2 = rigtxtbx.isDisplayed();
		System.out.println(l2 +  " Rignumber text box is Displayed");
		boolean s2 = licencedrpdwn.isDisplayed();
		System.out.println(s2 +  " Licence dropdown is Displayed");
		boolean b2 = activitydrpdwn.isDisplayed();;
		System.out.println(b2 +  " activity dropdown is Displayed");
		boolean l3 = accesiblechckbx.isDisplayed();
		System.out.println(l3 +  " Accessible checkbox is Displayed");
		boolean s3 = designatedchkbx.isDisplayed();
		System.out.println(s3 +  " Designated checkbox is Displayed");
		boolean b3 = accessibletxtbx.isDisplayed();;
		System.out.println(b3 +  " Accessible text box is Displayed");
		boolean l4 = landingtxtbx.isDisplayed();
		System.out.println(l4 +  " Landing zone is Displayed");
		boolean s4 = otheractivitytxtbx.isDisplayed();
		System.out.println(s4 +  " other activity is Displayed");
		boolean b4 = drivingchkbx.isDisplayed();;
		System.out.println(b4 +  " Driving direction checkbox is Displayed");
		boolean l5 = nearestchkbx.isDisplayed();
		System.out.println(l5 +  " Nearest town is Displayed");
		boolean s5 = primarydrpdwn.isDisplayed();
		System.out.println(s5 +  " Primary type dropdown is Displayed");
		boolean b5 = fillgpsbtn.isDisplayed();;
		System.out.println(b5 +  " Fill gps button is Displayed");
		boolean l6 = loadverifbtn.isDisplayed();;
		System.out.println(l6 +  " Load verification button is Displayed");
	}
	
	
	@FindBy(xpath = "(//button[@role='tab'])[4]")
	WebElement billingbtn1;
	
	@FindBy(xpath = "//input[@name='billingCompanyNewId']")
	WebElement billingcompanytxtbx;
	
	@FindBy(xpath = "//button[contains(text(),'Not to be Billed ')]")
	WebElement nottobillchkbx;
	
	@FindBy(xpath = "//button[contains(text(),'Is Billing Company Selected')]")
	WebElement isbillingchkbx;
	
	@FindBy(xpath = "//button[contains(text(),'No Match Verified ')]")
	WebElement nomatchchkbx;
	
	@FindBy(xpath = "//input[@name='verifiedLeaseHolder']")
	WebElement verifyleasetxtbx;
	
	@FindBy(xpath = "//input[@name='leaseHolderCompanyNewId']")
	WebElement leaseholdertxtbx;
	
	@FindBy(xpath = "(//input[@id='name'])[2]")
	WebElement licencetxtbx;
	
	@FindBy(xpath = "(//input[@id='name'])[3]")
	WebElement projectafetxtbx;
	
	
	
	
	public void startSafety() {
		billingbtn.click();
		boolean l1 = billingcompanytxtbx.isDisplayed();
		System.out.println(l1 +  " Billing company  is Displayed");
		boolean s1 = nottobillchkbx.isDisplayed();
		System.out.println(s1 +  " Not to be billed checkbox is Displayed");
		boolean b1 = isbillingchkbx.isDisplayed();;
		System.out.println(b1 +  " Is billing checkbox is Displayed");
		boolean l2 = nomatchchkbx.isDisplayed();
		System.out.println(l2 +  " No match verified checkbox is Displayed");
		boolean s2 = verifyleasetxtbx.isDisplayed();
		System.out.println(s2 +  " Verified lease holder textbox is Displayed");
		boolean l3 = leaseholdertxtbx.isDisplayed();
		System.out.println(l3 +  " Lease holder text box  is Displayed");
		boolean s3 = licencetxtbx.isDisplayed();
		System.out.println(s3 +  " Licence textbox is Displayed");
		boolean b3 = projectafetxtbx.isDisplayed();;
		System.out.println(b3 +  " Project afe textbox is Displayed");
		
		
	
		
	}
	
	
	
	
	
	
}
