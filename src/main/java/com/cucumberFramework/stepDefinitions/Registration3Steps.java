package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class Registration3Steps extends TestBase {

    MailPage mailPage = new MailPage(driver);
    SettingPasswordPage settingPasswordPage = new SettingPasswordPage(driver);
    SalesForcePage salesForcePage = new SalesForcePage(driver);
    RegistrationCompletedPage registrationCompletedPage = new RegistrationCompletedPage(driver);
    ResendInvitationPage resendInvitationPage = new ResendInvitationPage(driver);


    @Given("^Customer has an activation email in his inbox$")
    public void customerHasAnActivationEmailInHisInbox() { assertTrue(mailPage.isMessageDelivered()); }

    @Then("^Customer sees new tab opened with setting password page$")
    public void customerSeesNewTabOpenedWithSettingPasswordPage() { assertTrue(settingPasswordPage.isPageDisplayed()); }

    @When("^Customer provides new password$")
    public void customerProvidesNewPassword() { settingPasswordPage.setNewPassword(); }

    @Then("^Customer sees password complexity frame$")
    public void customerSeesPasswordComplexityFrame() { assertTrue(settingPasswordPage.isComplexityFrameDisplayed()); }

    @When("^Customer confirms password$")
    public void customerConfirmsPassword() { settingPasswordPage.confirmPassword(); }

    @And("^Customer checks checkboxes$")
    public void customerChecksCheckboxes() { settingPasswordPage.checkBoxes(); }

    @And("^Customer submits password form$")
    public void customerSubmitsPasswordForm() { settingPasswordPage.submitForm(); }

    @Then("^Customer sees registration completed page$")
    public void customerSeesRegistrationCompletedPage() { assertTrue(registrationCompletedPage.isPageDisplayed());}

    @When("^Customer selects to log in immediately$")
    public void customerSelectsToLogInImmediately() { registrationCompletedPage.logIn(); }

    @Then("^Customer cannot submit password form$")
    public void customerCannotSubmitPasswordForm() { assertTrue(settingPasswordPage.isPageDisplayed()); }

    @When("^Customer leaves new password field blank$")
    public void customerLeavesNewPasswordFieldBlank() { settingPasswordPage.leaveNewPasswordEmpty(); }

    @And("^Customer sees error message under new password field$")
    public void customerSeesErrorMessageUnderNewPasswordField() { assertTrue(settingPasswordPage.isNewPasswordErrorDisplayed()); }

    @When("^Customer leaves confirm password field blank$")
    public void customerLeavesConfirmPasswordFieldBlank() { settingPasswordPage.leaveConfirmPasswordEmpty(); }

    @And("^Customer sees error message under confirm password field$")
    public void customerSeesErrorMessageUnderConfirmPasswordField() { assertTrue(settingPasswordPage.isConfirmPasswordErrorDisplayed()); }

    @When("^Customer provides password as \"([^\"]*)\" to both password fields$")
    public void customerProvidesPasswordAsToBothPasswordFields(String arg0)  { settingPasswordPage.providePasswords(arg0); }

    @And("^Customer checks only terms and conditions checkbox$")
    public void customerChecksOnlyTermsAndConditionsCheckbox() { settingPasswordPage.checkTnCCheckbox(); }

    @When("^Customer checks only privacy policy checkbox$")
    public void customerChecksOnlyPrivacyPolicyCheckbox() {
        settingPasswordPage.checkTnCCheckbox();
        settingPasswordPage.checkPPCheckbox();
    }

    @When("^Customer checks and unchecks both checkboxes$")
    public void customerChecksAndUnchecksBothCheckboxes() { settingPasswordPage.checkPPCheckbox(); }

    @And("^Customer sees both checkboxes' names in red$")
    public void customerSeesBothCheckboxesNamesInRed() { assertTrue(settingPasswordPage.areCheckboxesErrorsDisplayed()); }

    @Then("^Customer sees new tab opened with resend invitation page$")
    public void customerSeesNewTabOpenedWithResendInvitationPage() { assertTrue(resendInvitationPage.isPageDisplayed()); }

    @When("^Customer inserts his email address to resend$")
    public void customerInsertsHisEmailAddressToResend() { resendInvitationPage.insertMail(); }

    @And("^Customer submits resend invitation form$")
    public void customerSubmitsResendInvitationForm() { resendInvitationPage.submitForm(); }

    @Given("^Customer is logged into SalesForce$")
    public void customerIsLoggedIntoSalesForce() {
        //some action to log in
        assertTrue(salesForcePage.isPageDisplayed());
    }

    @When("^Customer deletes user created via email registration$")
    public void customerDeletesUserCreatedViaEmailRegistration() { }

    @Then("^Customer sees no user attached to \"([^\"]*)\" account$")
    public void customerSeesNoUserAttachedToAccount(String arg0) { }

    @When("^Customer deletes user created via customer number$")
    public void customerDeletesUserCreatedViaCustomerNumber() { }

    @When("^Customer deletes \"([^\"]*)\" account$")
    public void customerDeletesAccount(String arg0) { }

    @And("^Customer reattaches test battery to \"([^\"]*)\" account$")
    public void customerReattachesTestBatteryToAccount(String arg0) { }

    @Then("^Customer see test battery as ready to be attached again$")
    public void customerSeeTestBatteryAsReadyToBeAttachedAgain() { }

    @When("^Customer uses token from activation email$")
    public void customerUsesTokenFromActivationEmail() { super.getAddress(mailPage.extractActivationToken()); }

    @When("^Customer uses broken token from activation email$")
    public void customerUsesBrokenTokenFromActivationEmail() { super.getAddress(mailPage.breakActivationToken()); }

    @Then("^Customer has a new activation email in his inbox$")
    public void customerHasANewActivationEmailInHisInbox() {
        assertTrue(mailPage.isMessageDelivered());
        mailPage.deleteAllThreads();
    }
}

