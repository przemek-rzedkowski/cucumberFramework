package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResendInvitationPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement mailField;

    @FindBy(xpath = "//span[@class='sw-button__label']")
    private WebElement submitButton;

    public ResendInvitationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(mailField); }

    public void insertMail() {
        element.type(mailField, "alighieri.dante1508@gmail.com");
    }

    public void submitForm() {
        element.click(submitButton);
    }
}
