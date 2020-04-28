package com.cucumberFramework.pop;

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

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'PV System')]")
    private WebElement PVSystemName;

    @FindBy(xpath = "(//div[@class = 'c-icon-badge'][.//p[@class = 'c-icon-badge__label']])[2]")
    private WebElement showUserMenuButton;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() {
        return element.isDisplayed(PVSystemName);
    }

    public void openUserMenu() { element.click(showUserMenuButton); }
}
