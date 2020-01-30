package com.cucumberFramework.stepDefinitions;


import com.cucumberFramework.pop.DashboardPage;
import com.cucumberFramework.pop.LandingPage;
import com.cucumberFramework.pop.UserMenu;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.pop.LoginPage;
import com.cucumberFramework.baseTest.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.*;

import static org.testng.AssertJUnit.assertTrue;


public class LoginSteps extends TestBase {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    WaitHelper waitHelper = new WaitHelper(driver);
    LandingPage landingPage = new LandingPage(driver);
    UserMenu userMenu = new UserMenu(driver);


    @Then("^Customer should see Email input$")
    public void i_should_see_Email_Input() throws Throwable {
        assertTrue(loginPage.isPageDisplayed());
    }

    @When("^Customer enters username as \"([^\"]*)\"$")
    public void i_enter_username_as(String arg1) throws Throwable {
        loginPage.enterUserName(arg1);
    }

    @And("^Customer enters password as \"([^\"]*)\"$")
    public void i_enter_password_as(String arg1) throws Throwable {
        loginPage.enterPassword(arg1);
    }

    @And("^Customer clicks on login button$")
    public void click_on_login_button() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("^Customer should see PV System Name$")
    public void i_should_see_PV_System_Name() throws Throwable {
        assertTrue(dashboardPage.isPageDisplayed());
    }

    @Then("^Customer is unable to log in$")
    public void userIsUnableToLogIn() {
        assertTrue(loginPage.isInvalidCredentialsMessageDisplayed());
    }

    @And("^Customer enables display password feature$")
    public void userEnablesPasswordDisplaying() {
        loginPage.showPassword();
    }

    @Then("^Customer can see the password$")
    public void userCanSeePassword() {
        assertTrue(loginPage.canUserSeePassword());
    }

    @Given("^Customer is on Dashboard page$")
    public void userIsOnDashboard() {
        landingPage.proceedToLoginPage();
        loginPage.enterUserName("max-mustermann@example.com");
        loginPage.enterPassword("123Sonnen");
        loginPage.clickLoginButton();
        assertTrue(dashboardPage.isPageDisplayed());
    }

    @When("^Customer goes to User Menu$")
    public void userGoesToUserMenu() {
        loginPage.openUserMenu();
    }

    @And("^Customer logs out$")
    public void userLogsOut() {
        userMenu.logOut();
    }
}
