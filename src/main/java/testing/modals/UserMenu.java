package testing.modals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;
import testing.pages.LoginPage;

public class UserMenu {

    TestBase testBase = new TestBase();

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private WebElement logoutButton;

    public LoginPage logOut() {
        testBase.elementHelper.click(logoutButton);
        return new LoginPage();
    }
}
