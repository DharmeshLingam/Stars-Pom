package com.example.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.example.driver.DriverFactory;
import com.example.page.AuditLogPage;
import com.example.page.ClientUserPage;
import com.example.page.CompaniesPage;
import com.example.page.FinancePage;
import com.example.page.HomePage;
import com.example.page.LoginPage;
import com.example.page.SitesMandatorypage;
import com.example.page.SitesPage;
import com.example.report.ReportListener;

import static com.example.utils.PropertyLoader.returnConfigValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    protected static WebDriver driver;
    protected AuditLogPage auditLogPage;
    protected ClientUserPage clientUserPage;
    protected CompaniesPage companiesPage;
    protected FinancePage financePage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SitesPage sitesPage;
    protected SitesMandatorypage sm;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(returnConfigValue("url.base"));
        auditLogPage = new AuditLogPage(driver);
        clientUserPage = new ClientUserPage(driver);
        companiesPage = new CompaniesPage(driver);
        financePage = new FinancePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        sitesPage = new SitesPage(driver);
        sm = new SitesMandatorypage(driver); 
    }

    @AfterMethod
    public void postCondition(){
        driver.quit();
    }
}