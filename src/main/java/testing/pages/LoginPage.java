package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;
import testing.modals.UserMenu;

public class LoginPage extends BasePage{

    private static final String ANY_PASSWORD = "!@#$%^&*";

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(loginField);
        return loginField.isDisplayed();
    }

    @FindBy(xpath = "//span[contains(text(),'No, I´m a user already')]")
    private WebElement proceedToLoginButton;

    @FindBy(xpath = "//input[@id = 'user_email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'user_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//span[@class = 'eye hidden']")
    private WebElement showPasswordButtonHidden;

    @FindBy(xpath = "//span[@class = 'eye visible']")
    private WebElement showPasswordButtonVisible;

    @FindBy(xpath = "(//div[@class = 'c-icon-badge'][.//p[@class = 'c-icon-badge__label']])[2]")
    private WebElement showUserMenuButton;


    public DashboardPage login() {
        //testBase.elementHelper.type(loginField, user.getUsername());
        //testBase.elementHelper.type(passwordField, user.getPassword());
        testBase.elementHelper.type(loginField, "max-mustermann@example.com");
        testBase.elementHelper.type(passwordField, "123Sonnen");
        testBase.elementHelper.click(loginSubmitButton);

        return new DashboardPage();
    }

    public void tryToLogInWithIncorrectCredentials() {
        testBase.elementHelper.type(loginField, "!@#$%^&*");
        testBase.elementHelper.type(passwordField, "!@#$%^&*");
        testBase.elementHelper.click(loginSubmitButton);

    }

    public void enterPassword() {
        testBase.elementHelper.type(passwordField, ANY_PASSWORD);
    }

    public void showPassword() {
        testBase.elementHelper.click(showPasswordButtonHidden);
    }

    public boolean isPasswordVisible() {
        return passwordField.getAttribute("value").equals(ANY_PASSWORD);
    }

    public UserMenu showUserMenu() {
        testBase.elementHelper.click(showUserMenuButton);
        return new UserMenu();
    }


}
