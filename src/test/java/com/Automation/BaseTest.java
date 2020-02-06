package com.Automation;

import com.Automation.core.DriverFactory.DriverFactory;
import com.Automation.core.DriverType;
import com.Automation.pages.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    DriverType type = DriverType.CHROME;

    public BaseTest() {
        driver = DriverFactory.provideRequest(type);
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        page = new PageGenerator(driver);
    }
}
