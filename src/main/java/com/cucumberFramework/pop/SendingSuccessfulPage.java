package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        waitHelper.justWaitForEmail(5000);
        return element.isDisplayed(sendingSuccessfulHeader);
    }

}
