package com.Automation.core.DriverFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.Automation.core.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


class DriverSupplier {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return (WebDriver) new ChromeDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    };


    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
    }

    WebDriver supplyValue(DriverType type){
        return driverMap.get(type).get();
    }

}
