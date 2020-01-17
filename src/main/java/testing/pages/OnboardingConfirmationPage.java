package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingConfirmationPage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(onboardingConfirmationHeader);
        return onboardingConfirmationHeader.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(., \"You already have an account\")]")
    private WebElement onboardingConfirmationHeader;
}
