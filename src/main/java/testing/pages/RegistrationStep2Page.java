package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationStep2Page extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(serialNumberField);
        return serialNumberField.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='battery_serial_number']")
    private WebElement serialNumberField;
}
