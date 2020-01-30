package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.*;
import com.cucumberFramework.support.WaitHelper;
import cucumber.api.java.en.*;

import static org.testng.Assert.assertTrue;

public class DemoModeSteps extends TestBase {

    DemoModePage demoModePage = new DemoModePage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    LiveStatePage liveStatePage = new LiveStatePage(driver);
    AnalysisPage analysisPage = new AnalysisPage(driver);
    FlatPage flatPage = new FlatPage(driver);
    CommunityPage communityPage = new CommunityPage(driver);
    BatteriePage batteriePage = new BatteriePage(driver);


    @Then("^Customer sees welcoming page$")
    public void userSeesWelcomingPage() {
        assertTrue(demoModePage.isPageDisplayed());
    }

    @When("^Customer goes to Dashboard Page$")
    public void userGoesToDashboard() {
        demoModePage.proceedToDashboard();
    }

    @Then("^Customer sees demo Dashboard page$")
    public void userSeesDemoDashboard() {
        assertTrue(dashboardPage.isPageDisplayed());
    }

    @When("^Customer switches to Live State$")
    public void userSwitchesToLiveState() {
        demoModePage.proceedToLiveState();
    }

    @Then("^Customer sees demo Live State$")
    public void userSeesDemoLiveState() {
        assertTrue(liveStatePage.isPageDisplayed());
    }

    @When("^Customer shuts down tutorial message$")
    public void userShutsDownTutorial() {
        liveStatePage.shutDownTutorial();
    }

    @Then("^Customer can't see tutorial message$")
    public void userCannotSeeTutorial() {
        assertTrue(liveStatePage.userCannotSeeTutorial());
    }

    @When("^Customer switches to Analysis$")
    public void userSwitchesToAnalysis() {
        demoModePage.proceedToAnalysis();
    }

    @Then("^Customer sees demo Analysis page$")
    public void userSeesDemoAnalysis() {
        assertTrue(analysisPage.isPageDisplayed());
    }

    @When("^Customer switches to sonnenCommunity$")
    public void userSwitchesToSonnenCommunity() {
        demoModePage.proceedToCommunity();
    }

    @Then("^Customer sees demo sonnenCommunity page$")
    public void userSeesDemoSonnenCommunity() {
        assertTrue(communityPage.isPageDisplayed());
    }

    @When("^Customer switches to sonnenFlat$")
    public void userSwitchesToSonnenFlat() {
        demoModePage.proceedToFlat();
    }

    @Then("^Customer sees demo sonnenFlat page$")
    public void userSeesDemoSonnenFlat() {
        assertTrue(flatPage.isPageDisplayed());
    }

    @When("^Customer switches to sonnenBatterie$")
    public void userSwitchesToSonnenBatterie() {
        demoModePage.proceedToBatterie();
    }

    @Then("^Customer sees demo sonnenBatterie page$")
    public void userSeesDemoSonnenBatterie() {
        assertTrue(batteriePage.isPageDisplayed());
    }

    @When("^Customer leaves Demo mode$")
    public void userReturnsToLoginPage() {
        demoModePage.leaveDemo();
    }
}
