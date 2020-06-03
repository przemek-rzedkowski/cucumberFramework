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


public class LandingPage extends BasePage {

    private WebDriver driver;


    @FindBy(xpath = "//span[contains(text(),'No, I´m a user already')]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//span[contains(text(),'Yes, it´s first time')]")
    private WebElement proceedToRegistrationButton;

    @FindBy(xpath = "//span[contains(.,'Demo')]")
    private WebElement demoButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(proceedToLoginButton); }

    public void proceedToLoginPage() {
        element.clickWithJS(proceedToLoginButton);
    }

    public void proceedToRegistrationPage() {
        element.click(proceedToRegistrationButton);
    }

    public void proceedToDemoPage() {
        element.click(demoButton);
    }

}
