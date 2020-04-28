package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenu extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private WebElement myAccountButton;

    public UserMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return false;
    }

    public void logOut() {
        element.click(logoutButton);
    }

    public void switchToMyAccountPage() { element.click(myAccountButton); }
}
