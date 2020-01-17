package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlatPage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(contractNumberField);
        return contractNumberField.isDisplayed();
    }

    @FindBy(xpath = "//p[contains(text(),'Contract number')]/following-sibling::div")
    private WebElement contractNumberField;
}
