package com.Automation.pages.policyCenter;

import com.Automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"Desktop-DesktopMenuActions\"]/div[1]")
    public WebElement actionsButton;
    @FindBy(how = How.ID, using = "Desktop-DesktopMenuActions-DesktopMenuActions_Create-DesktopMenuActions_NewSubmission")
    public WebElement newSubmissionButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public NewSubmissionPage goToNewSubmissionPage(){
        click(actionsButton);
        click(newSubmissionButton);
        return getInstance(NewSubmissionPage.class);
    }


}


