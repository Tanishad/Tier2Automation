package com.Automation.Tier2Test.StepDefs;

import com.Automation.Tier2Test.Pages.BasePage;
import com.Automation.Tier2Test.Pages.ContactUsPage;
import com.Automation.Tier2Test.Pages.SummaryPage;
import com.Automation.Tier2Test.Utilities.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseDefs {
    BasePage basePage;
    ContactUsPage contactUsPage;
    SummaryPage summaryPage;
    WebDriver driver;


    public BaseDefs() {
        driver = DriverManager.webDriver;
        basePage = new BasePage(driver);
        contactUsPage = new ContactUsPage(driver);
        summaryPage = new SummaryPage(driver);

    }
}
