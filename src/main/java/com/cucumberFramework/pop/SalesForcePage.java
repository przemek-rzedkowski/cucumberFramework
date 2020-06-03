package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static com.cucumberFramework.support.PropertiesHelper.properties;


public class SalesForcePage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-id = 'Account']")
    private WebElement accountTab;

    @FindBy(xpath = "//input[@placeholder = 'Search Accounts and more...']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(text(),'Delete User')]")
    private WebElement deleteUserButton;

    @FindBy(xpath = "(//a[@title = 'Show 4 more actions'])[2]/ancestor::li")
    private WebElement expandMenuToDeleteAccount;

    @FindBy(xpath = "//a[@title = 'Delete']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//button[@title = 'Delete']")
    private WebElement confirmDelete;

    @FindBy(xpath = "//div[@class = 'slds-context-bar']")
    private WebElement SFHeader;

    @FindBy(xpath = "//button[contains(text(),'Create User')]")
    private WebElement createUserButton;

    @FindBy(xpath = "//input[@id = 'emc']")
    private WebElement verficationCodeField;

    @FindBy(xpath = "//input[@title = 'Verify']")
    private WebElement verifyCodeButton;


    public SalesForcePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(SFHeader); }

    public void logIn() {
        driver.get("https://sonnen--external.my.salesforce.com/");
        element.type(loginField, "przemyslaw.rzedkowski@boldare.com.external");
        element.type(passwordField, "123Sonnen!");
        element.click(loginButton);
    }

    public boolean deleteUsers() {
        String accountId;
        for (int i = 0; i < 3; i++) {
            accountId = "config.accounts." + i;
            driver.get("https://sonnen--external.lightning.force.com/lightning/r/Account/" + properties.getProperty(accountId) + "/view");
            waitHelper.getFluentWait().until(ExpectedConditions.visibilityOf(deleteUserButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteUserButton);
            waitHelper.getFluentWait().until(ExpectedConditions.visibilityOf(createUserButton));
            if (!element.isDisplayed(createUserButton)) return false;
        }
        return true;
    }

    public void confirmLogin(String code) {
        element.type(verficationCodeField, code);
        element.click(verifyCodeButton);
    }
}
