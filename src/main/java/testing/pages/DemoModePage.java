package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testing.baseTest.TestBase;

public class DemoModePage  extends BasePage{

    @Override
    public boolean isLoaded() {
        testBase.waitHelper.waitForElementToAppear(demoBanner);
        return demoBanner.isDisplayed();
    }


    @FindBy(xpath = "//span[contains(text(), \"DEMO\")]")
    private WebElement demoBanner;

    @FindBy(xpath = "//a[./span[contains(text(), \"Dashboard\")]]")
    private WebElement dashboardButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Live State\")]]")
    private WebElement liveStateButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"Analysis\")]]")
    private WebElement analysisButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenCommunity\")]]")
    private WebElement communityButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenFlat\")]]")
    private WebElement flatButton;

    @FindBy(xpath = "//a[./span[contains(text(), \"sonnenBatterie\")]]")
    private WebElement batterieButton;

    @FindBy(xpath = "//span[contains(text(),'Leave Demo')]")
    private WebElement leavingButton;

    public DashboardPage proceedToDashboard() {
        testBase.elementHelper.click(dashboardButton);
        return new DashboardPage();
    }

    public LiveStatePage proceedToLiveState() {
        testBase.elementHelper.click(liveStateButton);
        return new LiveStatePage();
    }

    public AnalysisPage proceedToAnalysis() {
        testBase.elementHelper.click(analysisButton);
        return new AnalysisPage();
    }

    public CommunityPage proceedToCommunity() {
        testBase.elementHelper.click(communityButton);
        return new CommunityPage();
    }

    public FlatPage proceedToFlat() {
        testBase.elementHelper.click(flatButton);
        return new FlatPage();
    }

    public BatteriePage proceedToBatterie() {
        testBase.elementHelper.click(batterieButton);
        return new BatteriePage();
    }

    public LoginPage leaveDemo() {
        testBase.elementHelper.click(leavingButton);
        return new LoginPage();
    }
}
