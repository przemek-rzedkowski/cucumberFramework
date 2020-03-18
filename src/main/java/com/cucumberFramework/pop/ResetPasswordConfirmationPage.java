package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordConfirmationPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//button[.//span[@class='sw-button__label']]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//h2[contains(@class, 'sw-page-subheadline')]")
    private WebElement successHeader;

    public ResetPasswordConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return element.isDisplayed(successHeader);
    }

    public void goToLogin() {
        element.click(proceedToLoginButton);
    }
}
