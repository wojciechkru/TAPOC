package com.Automation.pages.policyCenter;

import com.Automation.pages.BasePage;
import com.Automation.pages.utils.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NewSubmissionPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@name = \"NewSubmission-NewSubmissionScreen-SelectAccountAndProducerDV-Account\"]")
    public WebElement accountNumber;
    @FindBy(how = How.XPATH, using = "//input[@name = \"NewSubmission-NewSubmissionScreen-SelectAccountAndProducerDV-ProducerSelectionInputSet-Producer\"]")
    public WebElement organizationNumber;
    @FindBy(how = How.XPATH, using = "//select[@name = \"NewSubmission-NewSubmissionScreen-SelectAccountAndProducerDV-ProducerSelectionInputSet-ProducerCode\"]")
    public WebElement producerCode;
    @FindBy(how = How.XPATH, using = "//table//table/tbody/tr[2]/td[1]")
    public WebElement businessownersSelectButton;


    public NewSubmissionPage (WebDriver driver){
        super(driver);
    }

    public Offerings provideNewSubmissionDetails(XSSFRow row){

        writeText(accountNumber, row.getCell(3).toString());
        writeText(organizationNumber, row.getCell(4).toString());
        selectFromDL(producerCode, row.getCell(5).toString());
        click(businessownersSelectButton);
        return getInstance(Offerings.class);
    }
}
