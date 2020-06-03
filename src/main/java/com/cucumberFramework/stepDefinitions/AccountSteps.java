package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.*;

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
    public void customerSeesSettingSStatusChanged() { assertTrue(myAccountPage.hasStatusChanged()); }

    @When("^Customer switches to Password tab$")
    public void customerSwitchesToPasswordTab() { myAccountPage.switchToPassword(); }

    @Then("^Customer sees change password page$")
    public void customerSeesChangePasswordPage() { assertTrue(myAccountPage.isPasswordTabDisplayed()); }

    @When("^Customer fills change password form$")
    public void customerFillsChangePasswordForm() { myAccountPage.fillChangePasswordForm(); }

    @And("^Customer submits change password form$")
    public void customerSubmitsChangePasswordForm() { myAccountPage.submitChangePasswordForm(); }

    @Then("^Customer is able to log in using new password$")
    public void customerIsAbleToLogInUsingNewPassword() {
        dashboardPage.openUserMenu();
        userMenu.logOut();
        loginPage.enterUserName("max-mustermann@example.com");
        loginPage.enterPassword("123Sonnen!");
        loginPage.clickLoginButton();
        assertTrue(dashboardPage.isPageDisplayed());
    }

    @When("^Customer types \"([^\"]*)\" in new password fields$")
    public void customerTypesInNewPasswordFields(String arg0) { myAccountPage.typeNewPassword(arg0); }

    @Then("^Customer sees error message under old password field$")
    public void customerSeesErrorMessageUnderOldPasswordField() { assertTrue(myAccountPage.isOldPasswordErrorDisplayed()); }

    @When("^Customer types \"([^\"]*)\" into old password field$")
    public void customerTypesIntoOldPasswordField(String arg0) { myAccountPage.typeOldPassword(arg0); }

    @Then("^Customer sees errors below new password fields$")
    public void customerSeesErrorsBelowNewPasswordFields() { assertTrue(myAccountPage.areNewPasswordErrorsDisplayed()); }

    @Then("^Customer sees no data in password fields$")
    public void customerSeesNoDataInPasswordFields() { assertTrue(myAccountPage.arePasswordFieldsEmpty());}

    @When("^Customer refreshes site$")
    public void customerRefreshesSite() { myAccountPage.refreshPasswordPage(); }
}
