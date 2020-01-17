package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatteriePage extends BasePage{


    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(stateOfCharge);
        return stateOfCharge.isDisplayed();
    }

    @FindBy(xpath = "//div[contains(text(),'State of charge')]/following-sibling::div")
    private WebElement stateOfCharge;


}
