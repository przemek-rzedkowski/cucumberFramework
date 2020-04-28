package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'About me')]")
    private WebElement aboutMeButton;

    @FindBy(xpath = "//span[contains(text(),'Password')]")
    private WebElement passwordButton;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement settingsButton;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    private WebElement backButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement nameField;

    @FindBy(xpath = "//div[./input[@id='permission']]")
    private WebElement privacyPermissionsBox;

    @FindBy(xpath = "//input[@id='permission']")
    private WebElement privacyPermissionsStateIndicator;

    @FindBy(xpath = "//h2/div[contains(text(), \"Privacy permissions\")]")
    private WebElement privacyPermissionsHeader;

    private boolean privacyPermissionsStatus;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() { return element.isDisplayed(nameField); }

    public void goBack() { element.click(backButton);}

    public void switchToSettings() { element.click(settingsButton);}

    public boolean isSettingsTabDisplayed() { return element.isDisplayed(privacyPermissionsHeader); }

    public void changePrivacySettings() {
        privacyPermissionsStatus = privacyPermissionsStateIndicator.isSelected();
        element.click(privacyPermissionsBox);
        waitHelper.justWaitForIt(5000);
    }

    public boolean hasStatusChanged() { return privacyPermissionsStateIndicator.isSelected() != privacyPermissionsStatus; }
}
