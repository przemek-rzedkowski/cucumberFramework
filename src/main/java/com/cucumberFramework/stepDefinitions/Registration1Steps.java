package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.OnboardingConfirmationPage;
import com.cucumberFramework.pop.Registration1Page;
import com.cucumberFramework.pop.Registration2Page;
import cucumber.api.java.en.*;

import static org.testng.Assert.assertTrue;

public class Registration1Steps extends TestBase {

    Registration1Page registration1Page = new Registration1Page(driver);
    Registration2Page registration2Page = new Registration2Page(driver);
    OnboardingConfirmationPage onboardingConfirmationPage = new OnboardingConfirmationPage(driver);

    @When("^Customer is on Registration Page$")
    public void userIsOnRegistrationPage() { assertTrue(registration1Page.isPageDisplayed()); }

    @And("^Customer uses correct credentials to register$")
    public void userUsesCorrectCredentials() {
        registration1Page.registerUsingCorrectCredentials();
    }

    @Then("^Customer is able to proceed to step 2 of registration$")
    public void userIsAbleToProceedToStep2() { assertTrue(registration2Page.isPageDisplayed()); }

    @And("^Customer leaves all fields blank$")
    public void userLeavesAllFieldsBlank() {
        registration1Page.leaveFieldsEmpty();
    }

    @Then("^Customer sees three error messages$")
    public void userSeesThreeErrors() {
        assertTrue(registration1Page.areThereThreeErrors());
    }

    @When("^Customer uses incorrect email format$")
    public void userUsesIncorrectEmailFormat() {
        registration1Page.typeIncorrectEmailAddress();
    }

    @When("^Customer uses email address that already exists in SF$")
    public void userUsesEmailTaken() {
        registration1Page.typeEmailAlreadyTaken();
    }

    @Then("^Customer sees an error message under email field$")
    public void userSeesEmailErrorMessage() { assertTrue(registration1Page.isEmailErrorDisplaying()); }

    @And("^Customer cannot submit form due to inactive button$")
    public void userCannotSubmitForm() {
        assertTrue(registration1Page.isSubmitAvailable());
    }

    @Then("^Customer submits form$")
    public void userSubmitsForm() {
        registration1Page.userSubmitsForm();
    }

    @And("^Customer sees message that account already exists$")
    public void userSeesMessageThatAccountExists() { assertTrue(onboardingConfirmationPage.isPageDisplayed()); }

    @When("^Customer leaves \"([^\"]*)\" field blank$")
    public void userLeavesFieldBlank(String arg1) { registration1Page.leaveFieldBlank(arg1); }

    @Then("^Customer sees an error message under \"([^\"]*)\" field$")
    public void userSeesErrorMessage(String arg1) { assertTrue(registration1Page.isErrorDisplaying(arg1)); }

    @When("^Customer doesn't tick \"([^\"]*)\" checkbox$")
    public void userNotTick(String arg1) { registration1Page.doNotTick(arg1); }

    @Then("^Customer sees \"([^\"]*)\" checkbox's color turned red$")
    public void userSeesRed(String arg1) { assertTrue(registration1Page.isCheckboxRed(arg1)); }
}
