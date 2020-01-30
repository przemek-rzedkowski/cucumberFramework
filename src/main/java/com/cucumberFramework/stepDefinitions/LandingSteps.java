package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.pop.DemoModePage;
import com.cucumberFramework.pop.LandingPage;
import com.cucumberFramework.support.WaitHelper;
import com.cucumberFramework.baseTest.TestBase;
import cucumber.api.java.en.*;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.assertTrue;


public class LandingSteps extends TestBase {

    LandingPage landingPage = new LandingPage(driver);


    @Given("^Customer is on Landing page$")
    public void userIsOnLandingPage() {
        assertTrue(landingPage.isPageDisplayed());
    }

    @When("^Customer proceed to Demo mode$")
    public void userProceedToDemoMode() {
        landingPage.proceedToDemoPage();
    }

    @Given("^Customer proceed to Register Page$")
    public void userProceedToRegisterPage() {
        landingPage.proceedToRegistrationPage();
    }

    @Given("^Customer proceed to Login Page$")
    public void userProceedToLoginPage() {
        landingPage.proceedToLoginPage();
    }



}
