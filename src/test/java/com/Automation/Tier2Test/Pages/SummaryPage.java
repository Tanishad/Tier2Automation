package com.Automation.Tier2Test.Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {
    public WebDriver driver;

    public String messageLocator = "//p[text()='Message could not be delivered.']";
    public String textLocator = "//h1[text()='Contact Us']";


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }


    public void isErrorMessgeDisplayed() {

        WebElement summaryMessage =driver.findElement(By.xpath(messageLocator));

        String textInElement = summaryMessage.getText();

        if(textInElement.equals("Message could not be delivered..")) {
            System.out.println("test passes");
        }
        else {
            System.out.println("test fails");
        }

    }


    public boolean isErrorMessageDisplyedUsingAssertLibrary() {
        WebElement summaryMessage =driver.findElement(By.xpath(messageLocator));

        String textInElement = summaryMessage.getText();
        boolean check;

        if(textInElement.equals("Message could not be delivered.")) {
            check = true;
        }
        else {
           check= false;
        }
        return check;
    }

    public boolean isErrorMessageDisplayed(DataTable dataTable) {
        String message = dataTable.cell(0,0);
        WebElement summaryMessage =driver.findElement(By.xpath(messageLocator));

        String textInElement = summaryMessage.getText();
        boolean check;

        if(textInElement.equals(message)) {
            check = true;
        }
        else {
            check= false;
        }
        return check;
    }

    public void repositionForScreenShot() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-900)");

    }
}
