package com.Automation.tests;

import com.Automation.BaseTest;
import com.Automation.pages.policyCenter.LoginPage;
import com.Automation.pages.utils.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginStepDefinitions extends BaseTest{
    XSSFRow data;
    public LoginStepDefinitions() {
        super();
    }

    @Before
    public void setupTestData(){
    ExcelUtils.setExcelFileSheet("LoginData");
        data = ExcelUtils.getRowData(1);
    }

    @Given("I am on the Login Page")
    public void i_am_on_the_Login_Page(){
        page.getInstance(LoginPage.class).goToLoginPage();
    }

    @When("I provide {string} and {string} and click login")
    public void i_provide_and_and_click_login(String user, String pswd){
        page.getInstance(LoginPage.class).loginToPC(data).goToNewSubmissionPage().provideNewSubmissionDetails(data).selectOffering();
    }

    @Then("I can see MySummary title")
    public void i_can_see_MySummary_title() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My Summary']")));
        //wait.until(ExpectedConditions.elementToBeClickable())
    }
    @After
    public void quiteDriver(){
        driver.quit();
    }



}
