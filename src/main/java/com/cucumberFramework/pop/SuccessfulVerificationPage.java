package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import com.google.common.base.Function;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;
import java.time.Duration;

public class SuccessfulVerificationPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Successfully verified!')]")
    private WebElement successfulHeader;

    @FindBy(xpath = "//button[contains(text(), \"You didn't receive an email?\")]")
    private WebElement troubleshootingButton;

    @FindBy(xpath = "//h2[contains(text(),\"You didn't receive an email?\")]")
    private WebElement troubleshootingPageHeader;

    public SuccessfulVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement elem = wait.until(ExpectedConditions.visibilityOf(successfulHeader));
        return true;
    }

    public void clickDontReceiveEmail() { element.click(troubleshootingButton); }

    public boolean isTroubleshootingDisplayed() { return element.isDisplayed(troubleshootingPageHeader); }
}
