package com.Automation.Tier2Test.StepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs extends BaseDefs  {


    @Given("User reaches Contact us Screen")
    public void userReachesContactUsScreen() {
        System.out.println("Given");
        basePage.openTier2WebSite();
        basePage.reachContactUs();
    }

    @When("User submits ContactUs Form without captcha")
    public void userSubmitsContactUsFormWithoutCaptcha() {
        System.out.println("When");
        contactUsPage.fillForm();
    }

    @Then("Error below Message is displayed")
    public void errorBelowMessageIsDisplayed(DataTable dataTable) {

        System.out.println("Then");
        Assert.assertTrue(summaryPage.isErrorMessageDisplayed(dataTable));
        summaryPage.repositionForScreenShot();
    }
}