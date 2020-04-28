package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class AccountSteps extends TestBase {

    UserMenu userMenu = new UserMenu(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    LandingPage landingPage = new LandingPage(driver);

    @Given("^Customer is logged in as \"([^\"]*)\"$")
    public void customerIsLoggedIn(String arg0) {
        landingPage.proceedToLoginPage();
        loginPage.enterCredentialsAs(arg0, "123Sonnen!");
        loginPage.clickLoginButton();
    }

    @When("^Customer switches to account info$")
    public void customerSwitchesToAccountInfo() {
        dashboardPage.openUserMenu();
        userMenu.switchToMyAccountPage();
    }

    @Then("^Customer sees Personal Data page$")
    public void customerSeesPersonalDataPage() { assertTrue(myAccountPage.isPageDisplayed()); }

    @When("^Customer goes back$")
    public void customerGoesBack() { myAccountPage.goBack(); }

    @When("^Customer switches to Settings tab$")
    public void customerSwitchesToSettingsTab() { myAccountPage.switchToSettings(); }

    @Then("^Customer sees Settings page$")
    public void customerSeesSettingsPage() { assertTrue(myAccountPage.isSettingsTabDisplayed()); }

    @When("^Customer changes some setting$")
    public void customerChangesSomeSetting() { myAccountPage.changePrivacySettings(); }

    @Then("^Customer sees setting's status changed$")
    public void customerSeesSettingSStatusChanged() { assertTrue(myAccountPage.hasStatusChanged());}

}
