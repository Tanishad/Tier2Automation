package com.Automation.Tier2Test.Pages;

import com.Automation.Tier2Test.Utilities.StringLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    public WebDriver driver;
    public StringLibrary stringLibrary;

    public String nameLocator = "//input[@type='text'][@name='name']";
    public ContactUsPage( WebDriver driver)
    {
        this.driver= driver;
        stringLibrary = new StringLibrary();
    }


    public void fillForm() {




        fillName();

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        emailElement.sendKeys(stringLibrary.getRandomEmail());

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='Development_Support_Requirement']"));
        checkBox1.click();

        WebElement queryBox = driver.findElement(By.xpath("//textarea[@name='Help']"));
        queryBox.sendKeys("something");

        WebElement acceptAllCookiesBox = driver.findElement(By.xpath("//button[text()='Allow all cookies']"));
        acceptAllCookiesBox.click();
        //button[text()='Allow all cookies']

        WebElement submitElement = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitElement.click();



    }

    public void fillName() {
        WebElement nameElement = driver.findElement(By.xpath(nameLocator));
        nameElement.sendKeys(stringLibrary.getRandomAphabets(5));
    }






}
