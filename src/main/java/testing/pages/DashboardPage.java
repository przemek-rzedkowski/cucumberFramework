package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(PVSystemName);
        return PVSystemName.isDisplayed();
    }

    @FindBy(xpath = "//p[@class='c-icon-badge__label'][contains(text(),'Max Mustermann')]")
    private WebElement mainPageChecker;

    @FindBy(xpath = "//h2[contains(text(),'PV System')]")
    private WebElement PVSystemName;
}
