package com.Automation.Tier2Test.StepDefs;

//import com.Automation.Tier2Test.RawCode.Utilities.DriverManager;
import com.Automation.Tier2Test.Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;

public class Hooks {
    DriverManager driverManager; //driverManager - ref variable
    WebDriver driver;
    Scenario scenario;

    @Before
    public void Before(Scenario scenario) {
        System.out.println("Before");
        driverManager = new DriverManager();// created object DriverManager
        driverManager.setDriver();
        driver = driverManager.getWebDriver(); // have a local refrence to the globally set driver.
        this.scenario = scenario;

    }

    @After
    public void After() {
        scenario.log(driver.getCurrentUrl());//+" "+commonFunction.getCurrentDate());
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", screenshotName); //attach not embed it to the report
        TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();

        System.out.println("After");
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
