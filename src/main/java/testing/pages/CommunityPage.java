package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityPage extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(communityPageChecker);
        return communityPageChecker.isDisplayed();
    }

    @FindBy(xpath = "//h2[contains(text(),'The sonnenCommunity is balancing the grid')]")
    private WebElement communityPageChecker;
}
