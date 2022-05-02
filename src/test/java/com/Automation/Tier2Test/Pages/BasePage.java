package com.Automation.Tier2Test.Pages;

import com.Automation.Tier2Test.Utilities.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class BasePage {
    public WebDriver driver;
    public PropertyReader propertyReader;
    public Properties properties;

    public BasePage( WebDriver driver) {
        this.driver=driver;
        this.propertyReader = new PropertyReader();
        this.properties = this.propertyReader.getDefaultPropertyFileObject();

    }

    public void openTier2WebSite() {
        driver.get(properties.getProperty("url"));
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public void reachContactUs() {
        WebElement contactUsElement = driver.findElement(By.linkText("Contact Us"));
        contactUsElement.click();
    }

    public void visitEcommmerceWebsite() {
        driver.get(properties.getProperty("ecommerceUrl"));
    }
}