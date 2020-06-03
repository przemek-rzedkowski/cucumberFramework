package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendingSuccessfulPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "(//h2[contains(@class, 'sw-page-subheadline')])[1]")
    private WebElement sendingSuccessfulHeader;

    public SendingSuccessfulPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        waitHelper.getFluentWait().until(ExpectedConditions.visibilityOf(sendingSuccessfulHeader));
        return element.isDisplayed(sendingSuccessfulHeader);
    }

}
