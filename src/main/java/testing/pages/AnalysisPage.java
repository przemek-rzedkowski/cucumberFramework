package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;

public class AnalysisPage extends BasePage{

    TestBase testBase = new TestBase();

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(dayChartHeader);
        return dayChartHeader.isDisplayed();
    }

    @FindBy(xpath = "//div[contains(text(), \"Your day chart\")]")
    private WebElement dayChartHeader;
}
