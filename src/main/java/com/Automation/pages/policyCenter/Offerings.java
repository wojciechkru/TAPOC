package com.Automation.pages.policyCenter;

import com.Automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Offerings extends BasePage {

    @FindBy(how = How.XPATH, using = "//select[@name=\"SubmissionWizard-OfferingScreen-OfferingSelection\"]")
    public WebElement offeringSelection;

    public Offerings (WebDriver driver){super(driver);}

    public void selectOffering(){
        selectFromDL(offeringSelection, "Platinum");
    }



}
