package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;

public class LandingPage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(proceedToLoginButton);
        return proceedToLoginButton.isDisplayed();
    }


    @FindBy(xpath = "//span[contains(text(),'No, I´m a user already')]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//span[contains(text(),'Yes, it´s first time')]")
    private WebElement proceedToRegistrationButton;

    @FindBy(xpath = "//span[contains(.,'Demo')]")
    private WebElement demoButton;

    public LoginPage proceedToLoginPage() {
        testBase.elementHelper.click(proceedToLoginButton);
        return new LoginPage();
    }

    public RegistrationStep1Page proceedToRegistrationPage() {
        testBase.elementHelper.click(proceedToRegistrationButton);
        return new RegistrationStep1Page();
    }

    public DemoModePage proceedToDemoMode() {
        testBase.elementHelper.click(demoButton);
        return new DemoModePage();
    }
}
