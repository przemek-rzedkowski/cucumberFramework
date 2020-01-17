package testing.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class LandingSteps extends BaseFunc{


    @Given("^Customer is on Landing Page$")
    public void userIsOnLandingPage() {
        //super.getLandingPage();
        assertTrue(landingPage.isLoaded());
    }

    @When("^Customer proceed to Demo mode$")
    public void userProceedToDemoMode() {
        //super.getLandingPage();
        landingPage.proceedToDemoMode();
        //super.getDemoModePage();
    }

    @Given("^Customer proceed to Register Page$")
    public void userProceedToRegisterPage() {
        //super.getLandingPage();
        landingPage.proceedToRegistrationPage();
    }

    @Given("^Customer proceed to Login Page$")
    public void userProceedToLoginPage() {
        //super.getLandingPage();
        landingPage.proceedToLoginPage();
    }

}
