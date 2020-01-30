package com.cucumberFramework.pop;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cucumberFramework.support.WaitHelper;

public class LoginPage extends BasePage {

    private WebDriver driver;

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

    @FindBy(xpath = "(//div[@class = 'c-icon-badge'][.//p[@class = 'c-icon-badge__label']])[2]")
    private WebElement showUserMenuButton;

    @FindBy(xpath = "//div[contains(text(), \"Invalid E-mail or password\")]")
    private WebElement invalidCredentialsMessage;

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
        element.click(loginSubmitButton);
    }

    public void showPassword() {
        element.click(showPasswordButtonHidden);
    }

    public boolean canUserSeePassword() {
        return passwordField.getAttribute("value").equals("passwd");
    }

    public void openUserMenu() {
        element.click(showUserMenuButton);
    }
}
