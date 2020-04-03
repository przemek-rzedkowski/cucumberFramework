package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPasswordPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Password complexity:')]")
    private WebElement passwordComplexityFrame;

    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//div[.//span[contains(.,'terms')]]/preceding-sibling::span")
    private WebElement TnCBox;

    @FindBy(xpath = "//div[.//span[contains(.,'policy')]]/preceding-sibling::span")
    private WebElement ppBox;

    @FindBy(xpath = "//span[@class='sw-button__label']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[./input[@name = 'password']]/following-sibling::div/p")
    private WebElement newPasswordError;

    @FindBy(xpath = "//div[./input[@name = 'passwordConfirmation']]/following-sibling::div/p")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//div[./input[@name = \"termsAccepted\"]]")
    private WebElement TnCBoxError;

    @FindBy(xpath = "//div[./input[@name = \"privacyAccepted\"]]")
    private WebElement ppBoxError;

    @FindBy(css = "button[type=submit]:not(disabled)")
    private WebElement submitButtonEnabled;

    public SettingPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(newPasswordField); }

    public void setNewPassword() { element.type(newPasswordField, "123Sonnen!"); }

    public boolean isComplexityFrameDisplayed() {
        element.click(newPasswordField);
        return element.isDisplayed(passwordComplexityFrame);
    }

    public void confirmPassword() { element.type(confirmPasswordField, "123Sonnen!"); }

    public void checkBoxes() {
        element.click(ppBox);
        element.click(TnCBox);
    }

    public void submitForm() { element.click(submitButton); }

    public void leaveNewPasswordEmpty() {
        element.click(newPasswordField);
        element.click(confirmPasswordField);
    }

    public boolean isNewPasswordErrorDisplayed() {
        return element.isDisplayed(newPasswordError);
    }

    public void leaveConfirmPasswordEmpty() {
        element.click(confirmPasswordField);
        element.click(newPasswordField);
    }

    public boolean isConfirmPasswordErrorDisplayed() {
        return element.isDisplayed(confirmPasswordError);
    }

    public void providePasswords(String arg0) {
        element.type(newPasswordField, arg0);
        element.type(confirmPasswordField, arg0);
    }

    public void checkTnCCheckbox() { element.click(TnCBox); }

    public void checkPPCheckbox() { element.click(ppBox); }

    public boolean areCheckboxesErrorsDisplayed() {
        if (element.hasClass(TnCBoxError, "sw-form-checkbox--error") &&
            element.hasClass(ppBoxError, "sw-form-checkbox--error")) {
            return true;
        }
        return false;
    }
}
