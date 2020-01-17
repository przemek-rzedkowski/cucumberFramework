package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;

public class RegistrationStep1Page extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(nameField);
        return nameField.isDisplayed();
    }


    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@name = \'first_name\']]//p")
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
    private  WebElement ppBoxError;

    @FindBy(xpath = "//span[contains(.,'Next')]")
    private WebElement submitButton;

    public RegistrationStep2Page registerUsingCorrectCredentials() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Szewc");
        testBase.elementHelper.type(mailField, "somemail@gmail.com");
        testBase.elementHelper.click(tncBox);
        testBase.elementHelper.click(ppBox);
        testBase.elementHelper.click(submitButton);

        return new RegistrationStep2Page();
    }

    public void leaveFieldsEmpty() {
        testBase.elementHelper.click(nameField);
        testBase.elementHelper.click(lastNameField);
        testBase.elementHelper.click(mailField);
        testBase.elementHelper.click(submitButton);
    }

    public boolean isSubmitAvailable() {
        return testBase.elementHelper.isEnabled(submitButton);
    }

    public boolean areThereThreeErrors() {
        if (testBase.elementHelper.isDisplayed(nameError)
                && testBase.elementHelper.isDisplayed(lastNameError)
                && testBase.elementHelper.isDisplayed(mailInvalidError)) {
            return true;
        }

        return false;
    }

    public void leaveNameBlank() {
        testBase.elementHelper.click(nameField);
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.type(mailField, "somemail@gmail.com");
        testBase.elementHelper.click(tncBox);
        testBase.elementHelper.click(ppBox);
    }

    public void leaveLastNameBlank() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.clear(lastNameField);
        testBase.elementHelper.click(lastNameField);
        testBase.elementHelper.type(mailField, "somemail@gmail.com");
        //testBase.elementHelper.click(tncBox);
        //testBase.elementHelper.click(ppBox);
    }

    public void leaveMailBlank() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.clear(mailField);
        testBase.elementHelper.click(mailField);
        //testBase.elementHelper.click(tncBox);
        //testBase.elementHelper.click(ppBox);
    }

    public void typeIncorrectEmailAddress() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.type(mailField, "!@#$%^&*");
        //testBase.elementHelper.click(tncBox);
        //testBase.elementHelper.click(ppBox);
    }

    public void typeEmailAlreadyTaken() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.type(mailField, "portal.sonnen@gmail.com");
        testBase.elementHelper.click(tncBox);
        testBase.elementHelper.click(ppBox);
    }

    public void doNotTickTNC() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.type(mailField, "somemaik@gmail.com");
        testBase.elementHelper.click(tncBox);
        //testBase.elementHelper.click(ppBox);
    }

    public void doNotTickPP() {
        testBase.elementHelper.type(nameField, "Marcin");
        testBase.elementHelper.type(lastNameField, "Maciak");
        testBase.elementHelper.type(mailField, "somemaik@gmail.com");
        //testBase.elementHelper.click(tncBox);
        testBase.elementHelper.click(ppBox);
    }

    public boolean isNameErrorDisplaying() {

        if (testBase.elementHelper.isDisplayed(nameError)) {
            return true;
        }
        return false;
    }

    public boolean isLastNameErrorDisplaying() {

        if (testBase.elementHelper.isDisplayed(lastNameError)) {
            return true;
        }
        return false;
    }

    public boolean isEmailErrorDisplaying() {

        if (testBase.elementHelper.isDisplayed(mailInvalidError)) {
            return true;
        }
        return false;
    }

    public boolean isTnCCheckboxRed() {
        if (testBase.elementHelper.hasClass(tncBoxError, "sw-form-checkbox--error")) {
            return true;
        }
        return false;
    }

    public boolean isPPCheckboxRed() {
        if (testBase.elementHelper.hasClass(ppBoxError, "sw-form-checkbox--error")) {
            return true;
        }
        return false;
    }

    public OnboardingConfirmationPage userSubmitsForm() {
        testBase.elementHelper.click(submitButton);
        return new OnboardingConfirmationPage();
    }
}
