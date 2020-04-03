package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.MailPage;
import com.cucumberFramework.pop.Registration1Page;
import com.cucumberFramework.pop.Registration2Page;
import com.cucumberFramework.pop.SuccessfulVerificationPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class Registration2Steps extends TestBase {

    Registration2Page registration2Page = new Registration2Page(driver);
    Registration1Page registration1Page = new Registration1Page(driver);
    SuccessfulVerificationPage successfulVerificationPage = new SuccessfulVerificationPage(driver);
    MailPage mailPage;
    {
        try {
            mailPage = new MailPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^Customer selects that he doesn't receive an email$")
    public void customerSelectsThatHeDoesnTReceiveAnEmail() { successfulVerificationPage.clickDontReceiveEmail(); }

    @And("^Customer uses correct \"([^\"]*)\" for step two$")
    public void customerUsesCorrectForStepTwo(String arg0) { registration2Page.useCorrectCredentials(arg0);}

    @And("^Customer submits registration form$")
    public void customerSubmitsRegistrationForm() { registration2Page.submitForm();}

    @Then("^Customer sees successful verification page$")
    public void customerSeesSuccessfulVerificationPage() { assertTrue(successfulVerificationPage.isPageDisplayed());}

    @And("^Customer receives confirmation email using \"([^\"]*)\"$")
    public void customerReceivesConfirmationEmail(String arg0) {
        assertTrue(mailPage.isMessageDelivered());
        mailPage.deleteAllThreadsIfSerialNumber(arg0);
    }

    @Then("^Customer sees troubleshooting message$")
    public void customerSeesTroubleshootingMessage() { assertTrue(successfulVerificationPage.isTroubleshootingDisplayed());}

    @When("^Customer uses incorrect serial number and legitimation password$")
    public void customerUsesIncorrectSerialNumberAndLegitimationPassword() { registration2Page.useIncorrectSerialNumberAndLegitimationPassword();}

    @Then("^Customer sees wrong serial number or password error$")
    public void customerSeesWrongCredentialsErrorMessage() { assertTrue(registration2Page.isWrongSerialNumberOrPasswordErrorDisplayed());}

    @And("^Customer cannot submit registration form again$")
    public void customerCannotSubmitRegistrationFormAgain() { assertFalse(registration2Page.isSubmitButtonActive()); }

    @When("^Customer leaves \"([^\"]*)\" blank$")
    public void customerLeavesBlank(String arg0) { registration2Page.leaveFieldBlank(arg0); }

    @Then("^Customer sees error message under \"([^\"]*)\"$")
    public void customerSeesErrorMessageUnder(String arg0) { assertTrue(registration2Page.isEmptyFieldErrorDisplayed(arg0)); }

    @When("^Customer switches to second way of registration$")
    public void customerSwitchesToSecondWayOfRegistration() { registration2Page.switchToAnotherWayOfRegistration();}

    @And("^Customer uses incorrect zip code and customer number$")
    public void customerUsesIncorrectZipCodeAndCustomerNumber() { registration2Page.useIncorrectZipAndId();}

    @When("^Customer goes back to first step of registration$")
    public void customerGoesBackToFirstStepOfRegistration() { registration2Page.goBackToFirstStep();}

    @Then("^Customer sees first step form prefilled with his data$")
    public void customerSeesFirstStepFormPrefilledWithHisData() { assertTrue(registration1Page.areFieldsFilled());}

    @When("^Customer goes to login from second step of registration$")
    public void customerGoesToLoginFromSecondStepOfRegistration() { registration2Page.goBackToLogin();}

    @When("^Customer switches to \"([^\"]*)\" tab$")
    public void customerSwitchesToTab(String arg0) {
        registration2Page.goBackToFirstStep();
        registration1Page.changePersonalData(arg0);
        registration1Page.userSubmitsForm();
        registration2Page.switchToAnotherTab(arg0);
    }

    @And("^Customer wants to find \"([^\"]*)\"$")
    public void customerWantsToFind(String arg0) { registration2Page.clickOnHint(arg0);}

    @Then("^Customer sees clues about finding \"([^\"]*)\"$")
    public void customerSeesCluesAboutFinding(String arg0) { assertTrue(registration2Page.isHintDisplayed(arg0));}

    @When("^Customer closes clue page$")
    public void customerClosesCluePage() { registration2Page.closeHint();}

    @Then("^Customer sees \"([^\"]*)\" tab$")
    public void customerSeesTab(String arg0) { assertTrue(registration2Page.isTabDisplayed(arg0));}

    @Then("^Customer sees wrong zip code or customer number wrong error$")
    public void customerSeesWrongZipCodeOrCustomerNumberWrongError() { assertTrue(registration2Page.isWrongCustomerNumberOrZipCodeErrorDisplayed());}
}
