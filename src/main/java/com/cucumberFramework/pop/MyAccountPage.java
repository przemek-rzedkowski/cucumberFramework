package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyAccountPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'About me')]")
    private WebElement aboutMeButton;

    @FindBy(xpath = "//a[@href = '/my-account/password']")
    private WebElement passwordButton;

    @FindBy(xpath = "//a[@href = '/my-account/settings']")
    private WebElement settingsButton;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    private WebElement backButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@id='permission']]")
    private WebElement privacyPermissionsBox;

    @FindBy(xpath = "//input[@id='permission']")
    private WebElement privacyPermissionsStateIndicator;

    @FindBy(xpath = "//h2/div[contains(text(), \"Privacy permissions\")]")
    private WebElement privacyPermissionsHeader;

    @FindBy(xpath = "//input[@name='previousPassword']")
    private WebElement oldPasswordField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement passwordConfirmationField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitPasswordChangeButton;

    @FindBy(xpath = "(//div[@class = 'c-string-complexity-checker__item'])[1]/div")
    private WebElement tenCharactersBox;

    @FindBy(xpath = "(//div[@class = 'c-string-complexity-checker__item'])[2]/div")
    private WebElement numberBox;

    @FindBy(xpath = "(//div[@class = 'c-string-complexity-checker__item'])[3]/div")
    private WebElement specialCharacterBox;

    @FindBy(xpath = "//div[./input[@name='password']]/following-sibling::div/p")
    private WebElement newPasswordError;

    @FindBy(xpath = "//div[./input[@name='passwordConfirmation']]/following-sibling::div/p")
    private WebElement passwordConfirmationError;

    @FindBy(xpath = "//div[./input[@name='previousPassword']]/following-sibling::div/p")
    private WebElement oldPasswordError;

    private boolean privacyPermissionsStatus;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(nameField); }

    public void goBack() { element.click(backButton);}

    public void switchToSettings() { element.click(settingsButton); }

    public boolean isSettingsTabDisplayed() { return element.isDisplayed(privacyPermissionsHeader); }

    public void changePrivacySettings() {
        privacyPermissionsStatus = privacyPermissionsStateIndicator.isSelected();
        element.click(privacyPermissionsBox);
    }

    public boolean hasStatusChanged() {
        return waitHelper.getFluentWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return privacyPermissionsStateIndicator.isSelected() != privacyPermissionsStatus;
            }
        });
    }

    public void switchToPassword() { element.click(passwordButton); }

    public boolean isPasswordTabDisplayed() { return element.isDisplayed(oldPasswordField); }

    public void fillChangePasswordForm() {
        element.type(oldPasswordField, "123Sonnen!");
        element.type(newPasswordField, "123Sonnen!");
        element.type(passwordConfirmationField, "123Sonnen!");
    }

    public void submitChangePasswordForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitPasswordChangeButton);
    }

    public void typeNewPassword(String arg0) {
        element.type(newPasswordField, arg0);
        element.type(passwordConfirmationField, arg0);
    }

    public boolean isOldPasswordErrorDisplayed() { return element.isDisplayed(oldPasswordError); }

    public void typeOldPassword(String arg0) { element.type(oldPasswordField, arg0); }

    public boolean areNewPasswordErrorsDisplayed() {
        if (element.isDisplayed(newPasswordError) &&
            element.isDisplayed(passwordConfirmationError)) {
            return true;
        }
        return false;
    }

    public boolean arePasswordFieldsEmpty() {
         return waitHelper.getFluentWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (oldPasswordField.getAttribute("value").equals("") &&
                        newPasswordField.getAttribute("value").equals("") &&
                        passwordConfirmationField.getAttribute("value").equals("")) {
                    return true;
                }
                return false;
            }
        });
    }

    public void refreshPasswordPage() { driver.navigate().refresh(); }
}
