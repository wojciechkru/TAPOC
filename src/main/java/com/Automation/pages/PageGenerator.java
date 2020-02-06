package com.Automation.pages;
import com.Automation.pages.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//Note (OB):
//Without Page Factory we can generate and return a new instance of a page by using below line.
//return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);

public class PageGenerator {

    public WebDriver driver;
    public WebDriverWait wait;
    public ExcelUtils data;

    //Constructor
    public PageGenerator(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}