package com.Automation.pages.policyCenter;

import com.Automation.core.PropertyManager;
import com.Automation.pages.BasePage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    String baseURL = PropertyManager.getInstance().getURL();

    @FindBy(how = How.NAME, using = "Login-LoginScreen-LoginDV-username")
    public WebElement username;

    @FindBy(how = How.NAME, using = "Login-LoginScreen-LoginDV-password")
    public WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "gw-action--inner")
    public WebElement loginButton;


    public void goToLoginPage (){
        driver.get(baseURL);
    }



    public MainPage loginToPC (XSSFRow row){
        //Enter Username(Email)
        writeText(username,row.getCell(1).toString());
        writeText(password, row.getCell(2).toString());
        click(loginButton);

        return getInstance(MainPage.class);
    }

}
