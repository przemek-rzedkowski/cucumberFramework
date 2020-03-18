package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulVerificationPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Successfully verified!')]")
    private WebElement successfulHeader;

    @FindBy(xpath = "//button[contains(text(), \"You didn't receive an e-mail?\")]")
    private WebElement troubleshootingButton;

    @FindBy(xpath = "//h2[contains(text(),\"You didn't receive an e-mail?\")]")
    private WebElement troubleshootingPageHeader;

    public SuccessfulVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return element.isDisplayed(successfulHeader);
    }

    public void clickDontReceiveEmail() {
        element.click(troubleshootingButton);
    }

    public boolean isTroubleshootingDisplayed() {
        return element.isDisplayed(troubleshootingPageHeader);
    }
}
