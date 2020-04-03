package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.MailHelper;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationCompletedPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(), 'Registration completed')]")
    private WebElement completedHeader;

    @FindBy(xpath = "//span[@class='sw-button__label']")
    private WebElement loginButton;

    public RegistrationCompletedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return element.isDisplayed(completedHeader);
    }

    public void logIn() {
        element.click(loginButton);
    }

    public void providePasswords(String arg0) {

    }
}
