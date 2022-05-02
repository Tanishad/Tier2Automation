package com.Automation.Tier2Test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    public WebDriver driver;

    public String nameLocator = "//input[@type='text'][@name='name']";
    public ContactUsPage( WebDriver driver)
    {
        this.driver= driver;
    }


    public void fillForm() {




        fillName();

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        emailElement.sendKeys("Random@abc.com");

        WebElement emailCheckBox1 = driver.findElement(By.xpath("//input[@name='Development_Support_Requirement']"));
        emailCheckBox1.click();

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
        nameElement.sendKeys("Random");
    }






}
