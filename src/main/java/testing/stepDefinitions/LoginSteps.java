package testing.stepDefinitions;

import cucumber.api.java.en.*;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseFunc{


    @When("^Customer is on Login Page$")
    public void userIsOnLoginPage() {
        assertTrue(loginPage.isLoaded());
    }

    @And("^Customer uses Correct Credentials to log in$")
    public void userUsesCorrectCredentials() {
        dashboardPage = loginPage.login();
    }

    @Then("^Customer is able to log in$")
    public void userIsAbleToLogIn() {
        assertTrue(dashboardPage.isLoaded());
    }

    @And("^Customer uses Incorrect Credentials to log in$")
    public void userUsesIncorrectCredentials() {
        loginPage.tryToLogInWithIncorrectCredentials();
    }

    @Then("^Customer is unable to log in$")
    public void userIsUnableToLogIn() {
        assertTrue(loginPage.isLoaded());
    }

    @And("^Customer enters any password$")
    public void userEntersAnyPassword() {
        loginPage.enterPassword();
    }

    @And("^Customer enables display password feature$")
    public void userEnablesPasswordDisplaying() {
        loginPage.showPassword();
    }

    @Then("^Customer can see the password$")
    public void userCanSeePassword() {
        assertTrue(loginPage.isPasswordVisible());
    }

    @Given("^Customer is on Dashboard page$")
    public void userIsOnDashboard() {
        //super.getLandingPage();
        landingPage.proceedToLoginPage();
        dashboardPage = loginPage.login();
        assertTrue(dashboardPage.isLoaded());
    }

    @When("^Customer goes to User Menu$")
    public void userGoesToUserMenu() {
        userMenu = loginPage.showUserMenu();
    }

    @And("^Customer logs out$")
    public void userLogsOut() {
        userMenu.logOut();
    }

}
