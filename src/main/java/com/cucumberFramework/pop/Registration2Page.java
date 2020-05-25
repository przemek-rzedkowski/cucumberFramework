package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration2Page extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='batterySerialNumber']")
    private WebElement serialNumberField;

    @FindBy(xpath = "//button[contains(text(),'Go back')]")
    private WebElement goBackButton;

    @FindBy(xpath = "//button[contains(text(), 'Serial number:')]")
    private WebElement serialNumberTab;

    @FindBy(xpath = "//button[contains(text(), 'Customer number')]")
    private WebElement customerNumberTab;

    @FindBy(xpath = "//button[contains(text(),'Where to find Serial number?')]")
    private WebElement serialNumberLocation;

    @FindBy(xpath = "//input[@id='batteryPassword']")
    private WebElement legitimationPasswordField;

    @FindBy(xpath = "//button[(contains(@disabled, '')) and contains(@type, 'submit')]")
    private WebElement verifyButton;

    @FindBy(xpath = "//button[contains(text(),\"Let's go to login page\")]")
    private WebElement goToLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Where to find customer number?')]")
    private WebElement customerNumberLocation;

    @FindBy(xpath = "//input[@id='customerNumber']")
    private WebElement customerNumberField;

    @FindBy(xpath = "//input[@id='zipCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//p[contains(text(),\"You couldn't find your credentials?\")]")
    private WebElement serialNumberClue;

    @FindBy(xpath = "//p[contains(text(),'Where can I find my customer number?')]")
    private WebElement customerNumberClue;

    @FindBy(xpath = "//p[contains(text(), 'The serial number or the password is wrong. Please try again.')]")
    private WebElement wrongSerialNumberOrPasswordError;

    @FindBy(xpath = "//p[contains(text(), 'The customer number or the zip code is wrong. Please try again.')]")
    private WebElement wrongCustomerNumberOrZipCodeError;

    @FindBy(xpath = "//div[./label[contains(text(), 'Legitimation password')]]//p[contains(text(), 'This field cannot be empty.')]")
    private WebElement emptyLegitimationPasswordError;

    @FindBy(xpath = "//div[./label[contains(text(), 'Serial number')]]//p[contains(text(), 'This field cannot be empty.')]")
    private WebElement emptySerialNumberError;

    @FindBy(xpath = "//div[./label[contains(text(), 'Customer number')]]//p[contains(text(), 'This field cannot be empty.')]")
    private WebElement emptyCustomerNumberError;

    @FindBy(xpath = "//div[./label[contains(text(), 'Zip code')]]//p[contains(text(), 'This field cannot be empty.')]")
    private WebElement emptyZipCodeError;

    @FindBy(xpath = "//div[@class='c-popup is-open']//button[@class='c-popup__close-button']")
    private WebElement closeHintButton;



    public Registration2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() { return element.isDisplayed(serialNumberField); }

    public void useCorrectCredentials(String arg0) {
        if (arg0.equals("serial number")) {
            element.type(serialNumberField, "58029");
            element.type(legitimationPasswordField, "8aptErgiM2");
        } else if(arg0.equals("customer number")) {
            element.type(customerNumberField, "DE20012896");
            element.type(zipCodeField, "55555");
        }
    }

    public void submitForm() {
        element.click(verifyButton);
    }

    public void useIncorrectSerialNumberAndLegitimationPassword() {
        element.type(serialNumberField, "!@#$%^&*");
        element.type(legitimationPasswordField, "!@#$%^&*");
    }

    public boolean isWrongSerialNumberOrPasswordErrorDisplayed() {
        return element.isDisplayed(wrongSerialNumberOrPasswordError);
    }

    public boolean isWrongCustomerNumberOrZipCodeErrorDisplayed() {
        return element.isDisplayed(wrongCustomerNumberOrZipCodeError);
    }

    public boolean isSubmitButtonActive() {
        //System.out.println(element.isClickable(verifyButton));
        return element.isClickable(verifyButton);
    }

    public void leaveFieldBlank(String arg0) {
        if (arg0.equals("serial number")) {
            element.clearFields(serialNumberField);
            element.type(legitimationPasswordField, "!@#$%^&*");
        } else if (arg0.equals("legitimation password")) {
            element.clearFields(legitimationPasswordField);
            element.type(serialNumberField, "!@#$%^&*");
        } else if (arg0.equals("zip code")) {
            element.clearFields(zipCodeField);
            element.type(customerNumberField, "!@#$%^&*");
        } else if (arg0.equals("customer number")) {
            element.clearFields(customerNumberField);
            element.type(zipCodeField, "11111");
        }
    }

    public boolean isEmptyFieldErrorDisplayed(String arg0) {
        if (arg0.equals("serial number")) {
            return element.isDisplayed(emptySerialNumberError);
        } else if (arg0.equals("legitimation password")) {
            return element.isDisplayed(emptyLegitimationPasswordError);
        } else if (arg0.equals("zip code")) {
            return element.isDisplayed(emptyZipCodeError);
        } else if (arg0.equals("customer number")) {
            return element.isDisplayed(emptyCustomerNumberError);
        }
        return false;
    }

    public void switchToAnotherWayOfRegistration() {
        element.click(customerNumberTab);
    }

    public void useIncorrectZipAndId() {
        element.type(zipCodeField, "11111");
        element.type(customerNumberField, "!@#$%^&*");
    }

    public void goBackToFirstStep() { element.click(goBackButton); }

    public void goBackToLogin() {
        element.click(goToLoginButton);
    }

    public void switchToAnotherTab(String arg0) {
        if (arg0.equals("serial number")) {
           //do nothing, you are on valid tab
        } else if (arg0.equals("customer number")) {
            element.click(customerNumberTab);
        }
    }

    public void clickOnHint(String arg0) {
        if (arg0.equals("serial number")){
            element.click(serialNumberLocation);
        } else if (arg0.equals("customer number")) {
            element.click(customerNumberLocation);
        }
    }

    public boolean isHintDisplayed(String arg0) {
        if (arg0.equals("serial number")){
            return element.isDisplayed(serialNumberClue);
        } else if (arg0.equals("customer number")) {
            return element.isDisplayed(customerNumberClue);
        }
        return false;
    }

    public void closeHint() {
        element.click(closeHintButton);
    }

    public boolean isTabDisplayed(String arg0) {
        if (arg0.equals("serial number")){
            return element.isDisplayed(serialNumberField);
        } else if (arg0.equals("customer number")) {
            return element.isDisplayed(customerNumberField);
        }
        return false;
    }

}
