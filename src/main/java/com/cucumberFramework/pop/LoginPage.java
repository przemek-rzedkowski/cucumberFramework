package com.cucumberFramework.pop;


import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id = 'user_email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'user_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//span[@class = 'eye hidden']")
    private WebElement showPasswordButtonHidden;

    @FindBy(xpath = "//span[@class = 'eye visible']")
    private WebElement showPasswordButtonVisible;

    @FindBy(xpath = "//div[contains(text(), \"Invalid Email or password\")]")
    private WebElement invalidCredentialsMessage;

    @FindBy(xpath = "//a[contains(text(),'Demo-Version!')]")
    private WebElement demoButton;

    @FindBy(xpath = "//a[contains(@href, 'forgot')]")
    private WebElement forgotPasswordButton;
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() {
        return element.isDisplayed(loginField);
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        return element.isDisplayed(invalidCredentialsMessage);
    }

    public void enterUserName(String userName){
        element.type(loginField, userName);
    }
    public void enterPassword(String password){
        element.type(passwordField, password);
    }
    public void clickLoginButton(){
        element.clickWithJS(loginSubmitButton);
    }

    public void showPassword() {
        element.click(showPasswordButtonHidden);
    }

    public boolean canUserSeePassword() {
        return passwordField.getAttribute("value").equals("passwd");
    }

    public void goToDemoFromLogin() { element.click(demoButton);}

    public void goToForgotPassword() { element.click(forgotPasswordButton);}

    public void enterCredentialsAs(String arg0, String arg1) {
        element.type(loginField, arg0);
        element.type(passwordField, arg1);
    }

}
