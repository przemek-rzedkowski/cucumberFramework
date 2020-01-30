package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.LandingPage;
import com.cucumberFramework.pop.OnboardingConfirmationPage;
import com.cucumberFramework.pop.Registration1Page;
import com.cucumberFramework.pop.Registration2Page;
import com.cucumberFramework.support.WaitHelper;
import cucumber.api.java.en.*;

import static org.testng.Assert.assertTrue;

public class Registration1Steps extends TestBase {

    WaitHelper waitHelper = new WaitHelper(driver);
    LandingPage landingPage = new LandingPage(driver);
    Registration1Page registration1Page = new Registration1Page(driver);
    Registration2Page registration2Page = new Registration2Page(driver);
    OnboardingConfirmationPage onboardingConfirmationPage = new OnboardingConfirmationPage(driver);


    @When("^Customer is on Registration Page$")
    public void userIsOnRegistrationPage() {
        assertTrue(registration1Page.isPageDisplayed());
        /*waitHelper.waitForElement(registration1Page.nameField);
        assertTrue(registration1Page.nameField.isDisplayed());*/
    }

    @And("^Customer uses Correct Credentials to register$")
    public void userUsesCorrectCredentials() {
        registration1Page.registerUsingCorrectCredentials();
    }

    @Then("^Customer is able to proceed to step 2 of registration$")
    public void userIsAbleToProceedToStep2() {
        assertTrue(registration2Page.isPageDisplayed());
        /*waitHelper.waitForElement(registration2Page.serialNumberField);
        assertTrue(registration2Page.serialNumberField.isDisplayed());*/
    }

    @And("^Customer leaves all fields blank$")
    public void userLeavesAllFieldsBlank() {
        registration1Page.leaveFieldsEmpty();
    }

    @Then("^Customer sees three error messages$")
    public void userSeesThreeErrors() {
        assertTrue(registration1Page.areThereThreeErrors());
    }

    @And("^Customer leaves Name field blank$")
    public void userLeavesNameFieldBlank() {
        registration1Page.leaveNameBlank();
    }

    @When("^Customer leaves Last name blank$")
    public void userLeavesLastNameBlank() {
        registration1Page.leaveLastNameBlank();
    }

    @When("^Customer leaves Mail field blank$")
    public void userLeavesMailBlank() {
        registration1Page.leaveMailBlank();
    }

    @When("^Customer uses incorrect email format$")
    public void userUsesIncorrectEmailFormat() {
        registration1Page.typeIncorrectEmailAddress();
    }

    @When("^Customer uses email address that already exists in SF$")
    public void userUsesEmailTaken() {
        registration1Page.typeEmailAlreadyTaken();
    }

    @When("^Customer doesn't tick TnC checkbox$")
    public void userDoesNotTickTNC() {
        registration1Page.doNotTickTNC();
    }

    @When("^Customer doesn't tick PP checkbox$")
    public void userDoesNotTickPP() {
        registration1Page.doNotTickPP();
    }

    @Then("^Customer sees an error message under name field$")
    public void userSeesNameErrorMessage() {
        assertTrue(registration1Page.isNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under last name field$")
    public void userSeesLastNameErrorMessage() {
        assertTrue(registration1Page.isLastNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under email field$")
    public void userSeesEmailErrorMessage() {
        assertTrue(registration1Page.isEmailErrorDisplaying());
    }

    @And("^Customer cannot submit form due to inactive button$")
    public void userCannotSubmitForm() {
        assertTrue(registration1Page.isSubmitAvailable());
    }

    @Then("^Customer submits form$")
    public void userSubmitsForm() {
        registration1Page.userSubmitsForm();
    }

    @And("^Customer sees message that account already exists$")
    public void userSeesMessageThatAccountExists() {
        /*waitHelper.waitForElement(onboardingConfirmationPage.onboardingConfirmationHeader);
        assertTrue(onboardingConfirmationPage.onboardingConfirmationHeader.isDisplayed());*/
        assertTrue(onboardingConfirmationPage.isPageDisplayed());
    }

    @Then("^Customer sees TnC checkbox's color turned red$")
    public void userSeesTnCCheckboxTurnedRed() {
        assertTrue(registration1Page.isTnCCheckboxRed());
    }

    @Then("^Customer sees PP checkbox's color turned red$")
    public void userSeesPPCheckboxTurnedRed() {
        assertTrue(registration1Page.isPPCheckboxRed());
    }
}
