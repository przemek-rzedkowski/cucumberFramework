package testing.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class DemoModeSteps extends BaseFunc{


    @Then("^Customer sees welcoming page$")
    public void userSeedWelcomingPage() {
        assertTrue(demoModePage.isLoaded());
    }

    @When("^Customer goes to Dashboard Page$")
    public void userGoesToDashboard() {
        dashboardPage = demoModePage.proceedToDashboard();
    }

    @Then("^Customer sees demo Dashboard page$")
    public void userSeesDemoDashboard() {
        assertTrue(dashboardPage.isLoaded());
    }

    @When("^Customer switches to Live State$")
    public void userSwitchesToLiveState() {
        liveStatePage = demoModePage.proceedToLiveState();
    }

    @Then("^Customer sees demo Live State$")
    public void userSeesDemoLiveState() {
        assertTrue(liveStatePage.isLoaded());
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
        analysisPage = demoModePage.proceedToAnalysis();
    }

    @Then("^Customer sees demo Analysis page$")
    public void userSeesDemoAnalysis() {
        assertTrue(analysisPage.isLoaded());
    }

    @When("^Customer switches to sonnenCommunity$")
    public void userSwitchesToSonnenCommunity() {
        communityPage = demoModePage.proceedToCommunity();
    }

    @Then("^Customer sees demo sonnenCommunity page$")
    public void userSeesDemoSonnenCommunity() {
        assertTrue(communityPage.isLoaded());
    }

    @When("^Customer switches to sonnenFlat$")
    public void userSwitchesToSonnenFlat() {
        flatPage = demoModePage.proceedToFlat();
    }

    @Then("^Customer sees demo sonnenFlat page$")
    public void userSeesDemoSonnenFlat() {
        assertTrue(flatPage.isLoaded());
    }

    @When("^Customer switches to sonnenBatterie$")
    public void userSwitchesToSonnenBatterie() {
        batteriePage = demoModePage.proceedToBatterie();
    }

    @Then("^Customer sees demo sonnenBatterie page$")
    public void userSeesDemoSonnenBatterie() {
        assertTrue(batteriePage.isLoaded());
    }

    @When("^Customer leaves Demo mode$")
    public void userReturnsToLoginPage() {
        demoModePage.leaveDemo();
    }
}
