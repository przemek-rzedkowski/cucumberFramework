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

    @When("^Customer switches to \"([^\"]*)\"$")
    public void userGoesToPage(String arg1) {
        demoModePage.proceedToPage(arg1);
    }

    @Then("^Customer sees demo \"([^\"]*)\" page$")
    public void userSeesPage(String arg1) {
        if (arg1.equals("Dashboard")) {
            assertTrue(dashboardPage.isPageDisplayed());
        } else if (arg1.equals("Live State")) {
            assertTrue(liveStatePage.isPageDisplayed());
        } else if (arg1.equals("Analysis")) {
            assertTrue(analysisPage.isPageDisplayed());
        } else if (arg1.equals("sonnenCommunity")) {
            assertTrue(communityPage.isPageDisplayed());
        } else if (arg1.equals("sonnenFlat")) {
            assertTrue(flatPage.isPageDisplayed());
        } else if (arg1.equals("sonnenBatterie")) {
            assertTrue(batteriePage.isPageDisplayed());
        }
    }

    @Then("^Customer sees welcoming page$")
    public void userSeesWelcomingPage() {
        assertTrue(demoModePage.isPageDisplayed());
    }

    @When("^Customer shuts down tutorial message on \"([^\"]*)\"$")
    public void userShutsDownTutorial(String arg1) {
        if (arg1.equals("Live State")) {
            liveStatePage.shutDownTutorial();
        } else {
            return;
        }
    }

    @Then("^Customer can't see tutorial message on \"([^\"]*)\"$")
    public void userCannotSeeTutorial(String arg1) {
        if (arg1.equals("Live State")) {
            assertTrue(liveStatePage.userCannotSeeTutorial());
        } else {
            assertTrue(true);
        }
    }

    @When("^Customer leaves Demo mode$")
    public void userReturnsToLoginPage() {
        demoModePage.leaveDemo();
    }

    @When("^Customer goes back to registration$")
    public void userGoesRegister() {
        demoModePage.goToRegistration();
    }
}
