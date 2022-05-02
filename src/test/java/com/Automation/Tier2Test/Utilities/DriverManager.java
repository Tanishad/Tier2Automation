package com.Automation.Tier2Test.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverManager {
    public PropertyReader propertyReader;
    public Properties properties;
    public static WebDriver webDriver;



    public DriverManager() {
        propertyReader = new PropertyReader();
        properties = propertyReader.getDefaultPropertyFileObject();
    }
    

    public void setDriver() {
        String browser = getBrowser();
        WebDriver driver = null;
        if(browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();

            //Add chrome switch to disable notification - "**--disable-notifications**"
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "C:\\DownloadedTools\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\DownloadedTools\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();


        }
        webDriver=driver;

    }

    public String getBrowser() {
        String browser= properties.getProperty("browser");
        return browser;
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
