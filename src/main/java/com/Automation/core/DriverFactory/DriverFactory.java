package com.Automation.core.DriverFactory;

import com.Automation.core.DriverType;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver provideRequest(DriverType driver) {
        return new DriverSupplier().supplyValue(driver);
    }

}






