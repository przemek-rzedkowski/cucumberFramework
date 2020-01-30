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

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@name = 'first_name']]//p")
    private WebElement nameError;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[./input[@name = 'last_name']]//p")
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
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
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

    public void leaveNameBlank() {
        element.click(nameField);
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void leaveLastNameBlank() {
        element.type(nameField, "Marcin");
        element.clearFields(lastNameField);
        element.click(lastNameField);
        element.type(mailField, "somemail@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void leaveMailBlank() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.clearFields(mailField);
        element.click(mailField);
    }

    public void typeIncorrectEmailAddress() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "!@#$%^&*");
    }

    public void typeEmailAlreadyTaken() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "portal.sonnen@gmail.com");
        element.click(tncBox);
        element.click(ppBox);
    }

    public void doNotTickTNC() {

        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
        //element.click(tncBox);
        element.click(ppBox);
    }

    public void doNotTickPP() {
        element.type(nameField, "Marcin");
        element.type(lastNameField, "Szewc");
        element.type(mailField, "somemail@gmail.com");
       // element.click(tncBox);
        element.click(ppBox);
    }

    public boolean isNameErrorDisplaying() {
        return element.isDisplayed(nameError);
    }

    public boolean isLastNameErrorDisplaying() {
        return element.isDisplayed(lastNameError);
    }

    public boolean isEmailErrorDisplaying() {
        return element.isDisplayed(mailInvalidError);
    }

    public boolean isTnCCheckboxRed() {
        return element.hasClass(tncBoxError, "sw-form-checkbox--error");
    }

    public boolean isPPCheckboxRed() {
        return element.hasClass(ppBoxError, "sw-form-checkbox--error");
    }

    public void userSubmitsForm() {
        element.click(submitButton);
    }


}
