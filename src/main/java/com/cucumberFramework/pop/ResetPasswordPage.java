package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[@class='sw-page-subheadline sw-page-subheadline--no-border sw-page-subheadline--small-gap']")
    private WebElement resetPasswordHeader;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[@class='sw-button__label']")
    private WebElement submitButton;

    @FindBy(xpath = "(//div[contains(@class, 'c-validation-badge')])[1]")
    private WebElement tenCharactersBox;

    @FindBy(xpath = "(//div[contains(@class, 'c-validation-badge')])[2]")
    private WebElement numberBox;

    @FindBy(xpath = "(//div[contains(@class, 'c-validation')])[3]")
    private WebElement specialCharacterBox;

    @FindBy(xpath = "(//div[./p[contains(@class, 'c-form__alert')]])[1]")
    private WebElement newPasswordError;

    @FindBy(xpath = "(//div[./p[contains(@class, 'c-form__alert')]])[2]")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//input[@name = 'password']/parent::div/following-sibling::button")
    private WebElement newPasswordEye;

    @FindBy(xpath = "//input[@name = 'passwordConfirmation']/parent::div/following-sibling::button")
    private WebElement confirmPasswordEye;

    @FindBy(xpath = "//div[./p[contains(@class, 'c-form__alert')]]")
    private WebElement notMatchingError;


    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        return element.isDisplayed(resetPasswordHeader);
    }

    public void leaveFieldsBlank() {
        element.click(newPasswordField);
        element.click(confirmPasswordField);
        submitForm();
    }

    public void submitForm() {
        element.click(submitButton);
    }

    public boolean isSubmitAvailable() {
        submitForm();
        String url = driver.getCurrentUrl();
        if (url.equals("https://my-dev.sonnen.de/reset-password")) {
            return false;
        }
        return true;
    }

    public boolean areErrorsDisplayed() {
        if (element.isDisplayed(newPasswordError) && element.isDisplayed(confirmPasswordError)) {
            return true;
        }
        return false;
    }

    public boolean isNewPasswordErrorDisplayed() {
        return element.isDisplayed(newPasswordError);
    }

    public boolean isConfirmPasswordErrorDisplayed() {
        return element.isDisplayed(confirmPasswordError);
    }

    public boolean isNumberRestrictionFulfilled() {
        if (element.hasClass(numberBox, "is-active") &&
            element.hasNoClass(tenCharactersBox, "is-active") &&
            element.hasNoClass(specialCharacterBox, "is-active")) {
            return true;
        }
        return false;
    }

    public void enterPassword(String arg0) {
        element.type(newPasswordField, arg0);
        element.type(confirmPasswordField, arg0);
    }

    public boolean areLengthAndComplexityRestrictionsFulfilled() {
        if (element.hasNoClass(numberBox, "is-active") &&
                element.hasClass(tenCharactersBox, "is-active")&&
                element.hasClass(specialCharacterBox, "is-active")) {
            return true;
        }
        return false;
    }

    public boolean areAllRestrictionsFulfilled() {
        if (element.hasClass(numberBox, "is-active") &&
                element.hasClass(tenCharactersBox, "is-active")&&
                element.hasClass(specialCharacterBox, "is-active")) {
            return true;
        }
        return false;
    }

    public void clickEyeIcons() {
        element.click(confirmPasswordEye);
        element.click(newPasswordEye);
    }

    public boolean arePasswordsAs(String arg0) {
        if (newPasswordField.getAttribute("value").equals(arg0) &&
            confirmPasswordField.getAttribute("value").equals(arg0)) {
            return true;
        }
        return false;
    }

    public void enterNewPassword(String arg0) {
        element.type(newPasswordField, arg0);
    }

    public void enterConfirmPassword(String arg0) {
        element.type(confirmPasswordField, arg0);
    }

    public boolean isNotMatchingErrorDisplayed() {
        return element.isDisplayed(notMatchingError);
    }
}
