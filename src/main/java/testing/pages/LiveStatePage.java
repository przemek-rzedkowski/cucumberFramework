package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;

public class LiveStatePage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(energyFlowHeader);
        return energyFlowHeader.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(text(), \"Live energy flow\")]")
    private WebElement energyFlowHeader;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    private WebElement tutorialClosingButton;

    public void shutDownTutorial() {
        testBase.elementHelper.click(tutorialClosingButton);
    }

    public boolean userCannotSeeTutorial() {
        return !testBase.elementHelper.isDisplayed(tutorialClosingButton);
    }
}
