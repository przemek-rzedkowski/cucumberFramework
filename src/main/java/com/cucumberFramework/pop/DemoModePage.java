package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class DemoModePage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), \"DEMO\")]")
    private WebElement demoBanner;

    @FindBy(xpath = "//a[./span[contains(text(), \"Dashboard\")]]")
    private WebElement dashboardButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Live State\")]]")
    private WebElement liveStateButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Analysis\")]]")
    private WebElement analysisButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenCommunity\")]]")
    private WebElement communityButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenFlat\")]]")
    private WebElement flatButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenBatterie\")]]")
    private WebElement batterieButton;

    @FindBy(xpath = "//span[contains(text(),'Leave Demo')]")
    private WebElement leavingButton;

    @FindBy(xpath = "//span[contains(text(),'Register')]")
    private WebElement registerButton;

    public DemoModePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return element.isDisplayed(demoBanner);
    }

    public void proceedToPage(String arg1) {
        if (arg1.equals("Dashboard")) {
            element.click(dashboardButton);
        } else if (arg1.equals("Live State")) {
            element.click(liveStateButton);
        } else if (arg1.equals("Analysis")) {
            element.click(analysisButton);
        } else if (arg1.equals("sonnenCommunity")) {
            element.click(communityButton);
        } else if (arg1.equals("sonnenFlat")) {
            element.click(flatButton);
        } else if (arg1.equals("sonnenBatterie")) {
            element.click(batterieButton);
        }
    }

    public void leaveDemo() {
        element.click(leavingButton);
    }

    public void goToRegistration() { element.click(registerButton); }

}
