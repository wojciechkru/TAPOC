package com.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends PageGenerator{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
                driver.findElement((By) elementAttr).click();
            }
            catch (Exception e){
                System.out.println("Element not clickable");
            }
        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            ((WebElement) elementAttr).click();
        }
    }


    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T,String> void selectFromDL (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
                Select select = new Select(driver.findElement((By) elementAttr));
                select.selectByVisibleText((java.lang.String) text);

            }
            catch (Exception e){
                System.out.println("Element not clickable");
            }
        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));

            Select select = new Select((WebElement) elementAttr);
            select.selectByVisibleText((java.lang.String) text);
        }
    }

    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
            driver.findElement((By) elementAttr).sendKeys(text);
            driver.findElement((By.cssSelector("body"))).click();

        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            ((WebElement) elementAttr).sendKeys(text);
            driver.findElement((By.cssSelector("body"))).click();

        }
    }
    public <T> void selectFromTable (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
            driver.findElement((By) elementAttr).sendKeys(text);
            driver.findElement((By.cssSelector("body"))).click();

        } else {
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            ((WebElement) elementAttr).sendKeys(text);
            driver.findElement((By.cssSelector("body"))).click();

        }
    }



    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    //Close popup if exists
    public void handlePopup (By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if(!popup.isEmpty()){
            popup.get(0).click();
            Thread.sleep(200);
        }
    }

}