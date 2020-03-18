package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration1Page extends BasePage {
    
    WebDriver driver;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@name = 'firstName']]//p")
    private WebElement nameError;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[./input[@name = 'lastName']]//p")
    private WebElement lastNameError;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement mailField;

    @FindBy(xpath = "//div[./input[@name = 'email']]//p")
    private WebElement mailInvalidError;

    @FindBy(xpath = "//div[.//span[contains(.,'terms')]]/preceding-sibling::span")
    private WebElement tncBox;

    @FindBy(xpath = "//div[./input[@name = \"terms_accepted\"]]")
    private WebElement tncBoxError;

    @FindBy(xpath = "//div[.//span[contains(.,'policy')]]/preceding-sibling::span")
    private WebElement ppBox;

    @FindBy(xpath = "//div[./input[@name = \"privacy_accepted\"]]")
    public  WebElement ppBoxError;

    @FindBy(xpath = "//span[contains(.,'Next')]")
    private WebElement submitButton;

    public Registration1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() {
        return element.isDisplayed(nameField);
    }

    public void registerUsingCorrectCredentials() {
        element.type(nameField, "Dante");
        element.type(lastNameField, "Alighieri");
        element.type(mailField, "some.mail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
        element.click(submitButton);
    }

    public void leaveFieldsEmpty() {
        element.click(nameField);
        element.click(lastNameField);
        element.click(mailField);
        element.click(submitButton);
    }

    public boolean isSubmitAvailable() {
        return element.isEnabled(submitButton);
    }

    public boolean areThereThreeErrors() {
        return element.isDisplayed(nameError)
                && element.isDisplayed(lastNameError)
                && element.isDisplayed(mailInvalidError);
    }

    public void typeIncorrectEmailAddress() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "!@#$%^&*");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void typeEmailAlreadyTaken() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "portal.sonnen@gmail.com");
    }

    public boolean isEmailErrorDisplaying() {
        return element.isDisplayed(mailInvalidError);
    }

    public void userSubmitsForm() {
        element.click(submitButton);
    }

    public void leaveFieldBlank(String arg1) {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);

        if (arg1.equals("name")) {
            element.clearFields(nameField);
        } else if (arg1.equals("last name")) {
            element.clearFields(lastNameField);
        } else if (arg1.equals("mail")) {
            element.clearFields(mailField);
        }
    }

    public boolean isErrorDisplaying(String arg1) {
        if (arg1.equals("name")) {
            return element.isDisplayed(nameError);
        } else if (arg1.equals("last name")) {
            return element.isDisplayed(lastNameError);
        } else if (arg1.equals("mail")){
            return element.isDisplayed(mailInvalidError);
        }
        return false;
    }

    public void doNotTick(String arg1) {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);

        if (arg1.equals("TnC")) {
            element.click(tncBox);
        } else if (arg1.equals("PP")) {
            element.click(ppBox);
        }
    }

    public boolean isCheckboxRed(String arg1) {
        if (arg1.equals("TnC")) {
            return element.hasClass(tncBoxError, "sw-form-checkbox--error");
        } else if (arg1.equals("PP")) {
            return element.hasClass(ppBoxError, "sw-form-checkbox--error");
        }
        return false;
    }

    public boolean isMailUnique() {
        return mailField.getAttribute("value").equals("some.mail@gmail.com");
    }

    public boolean areFieldsFilled() {
        element.click(ppBox);
        element.click(tncBox);
        if (nameField.getAttribute("value").equals("Dante") &&
            lastNameField.getAttribute("value").equals("Alighieri") &&
            mailField.getAttribute("value").equals("some.mail@gmail.com") &&
            element.hasClass(tncBoxError, "sw-form-checkbox--error") &&
            element.hasClass(ppBoxError, "sw-form-checkbox--error")) {
                return true;
        }
        return false;
    }

    public void typeEmailAlreadyInSF() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "test.sonnen@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }
}
