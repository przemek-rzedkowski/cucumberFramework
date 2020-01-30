package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveStatePage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(), \"Live energy flow\")]")
    private WebElement energyFlowHeader;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    private WebElement tutorialClosingButton;

    public LiveStatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() {
        return element.isDisplayed(energyFlowHeader);
    }

    public void shutDownTutorial() {
        tutorialClosingButton.click();
    }

    public boolean userCannotSeeTutorial() {
        return !tutorialClosingButton.isDisplayed();
    }
}
