package testing.stepDefinitions;

import cucumber.api.java.en.*;

import static org.testng.Assert.assertTrue;

public class Registration1Steps extends BaseFunc{


    @When("^Customer is on Registration Page$")
    public void userIsOnRegistrationPage() {
        assertTrue(registrationStep1Page.isLoaded());
    }

    @And("^Customer uses Correct Credentials to register$")
    public void userUsesCorrectCredentials() {
        registrationStep2Page = registrationStep1Page.registerUsingCorrectCredentials();
    }

    @Then("^Customer is able to proceed to step 2 of registration$")
    public void userIsAbleToProceedToStep2() {
        assertTrue(registrationStep2Page.isLoaded());
    }

    @And("^Customer leaves all fields blank$")
    public void userLeavesAllFieldsBlank() {
        registrationStep1Page.leaveFieldsEmpty();
    }

    @Then("^Customer sees three error messages$")
    public void userSeesThreeErrors() {
        assertTrue(registrationStep1Page.areThereThreeErrors());
    }

    @And("^Customer leaves Name field blank$")
    public void userLeavesNameFieldBlank() {
        registrationStep1Page.leaveNameBlank();
    }

    @When("^Customer leaves Last name blank$")
    public void userLeavesLastNameBlank() {
        registrationStep1Page.leaveLastNameBlank();
    }

    @When("^Customer leaves Mail field blank$")
    public void userLeavesMailBlank() {
        registrationStep1Page.leaveMailBlank();
    }

    @When("^Customer uses incorrect email format$")
    public void userUsesIncorrectEmailFormat() {
        registrationStep1Page.typeIncorrectEmailAddress();
    }

    @When("^Customer uses email address that already exists in SF$")
    public void userUsesEmailTaken() {
        registrationStep1Page.typeEmailAlreadyTaken();
    }

    @When("^Customer doesn't tick TnC checkbox$")
    public void userDoesNotTickTNC() {
        registrationStep1Page.doNotTickTNC();
    }

    @When("^Customer doesn't tick PP checkbox$")
    public void userDoesNotTickPP() {
        registrationStep1Page.doNotTickPP();
    }

    @Then("^Customer sees an error message under name field$")
    public void userSeesNameErrorMessage() {
        assertTrue(registrationStep1Page.isNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under last name field$")
    public void userSeesLastNameErrorMessage() {
        assertTrue(registrationStep1Page.isLastNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under email field$")
    public void userSeesEmailErrorMessage() {
        assertTrue(registrationStep1Page.isEmailErrorDisplaying());
    }

    @And("^Customer cannot submit form due to inactive button$")
    public void userCannotSubmitForm() {
        assertTrue(registrationStep1Page.isSubmitAvailable());
    }

    @Then("^Customer submit form$")
    public void userSubmitsForm() {
        onboardingConfirmationPage = registrationStep1Page.userSubmitsForm();
    }

    @And("^Customer sees message that account already exists$")
    public void userSeesMessageThatAccountExists() {
        assertTrue(onboardingConfirmationPage.isLoaded());
    }

    @Then("^Customer sees TnC checkbox's color turned red$")
    public void userSeesTnCCheckboxTurnedRed() {
        assertTrue(registrationStep1Page.isTnCCheckboxRed());
    }

    @Then("^Customer sees PP checkbox's color turned red$")
    public void userSeesPPCheckboxTurnedRed() {
        assertTrue(registrationStep1Page.isPPCheckboxRed());
    }
}
