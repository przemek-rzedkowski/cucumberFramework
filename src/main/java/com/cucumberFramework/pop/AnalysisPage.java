package com.cucumberFramework.pop;

import com.cucumberFramework.baseTest.BasePage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.support.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalysisPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), \"Your day chart\")]")
    private WebElement dayChartHeader;

    public AnalysisPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        element = new WebElementHelper(waitHelper, driver);
    }

    public boolean isPageDisplayed() {
        return element.isDisplayed(dayChartHeader);
    }
}
