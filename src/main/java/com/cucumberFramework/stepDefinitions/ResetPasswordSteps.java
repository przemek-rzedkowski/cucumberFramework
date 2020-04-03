package com.cucumberFramework.stepDefinitions;

import com.cucumberFramework.baseTest.TestBase;
import com.cucumberFramework.pop.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ResetPasswordSteps extends TestBase {

    LoginPage loginPage = new LoginPage(driver);
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    SendingSuccessfulPage sendingSuccessfulPage = new SendingSuccessfulPage(driver);
    WentWrongPage wentWrongPage = new WentWrongPage(driver);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
    ResetPasswordConfirmationPage resetPasswordConfirmationPage = new ResetPasswordConfirmationPage(driver);
    MailPage mailPage;

    {
        try {
            mailPage = new MailPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^Customer selects that he forgot the password$")
    public void customerSelectsThatHeForgotThePassword() { loginPage.goToForgotPassword();}

    @Then("^Customer sees forgot password page$")
    public void customerSeesForgotPasswordPage() { assertTrue(forgotPasswordPage.isPageDisplayed());}

    @When("^Customer inserts his email address to reset$")
    public void customerInsertsHisEmailAddressToReset() { forgotPasswordPage.enterMail();}

    @And("^Customer submits forgot password form$")
    public void customerSubmitsForgotPasswordForm() { forgotPasswordPage.submitForm();}

    @Then("^Customer sees sending successful page$")
    public void customerSeesSendingSuccessfulPage() { assertTrue(sendingSuccessfulPage.isPageDisplayed());}

    @And("^Customer has an reset password email in his inbox$")
    public void customerHasAnResetPasswordEmailInHisInbox() { assertTrue(mailPage.isMessageDelivered()); }

    @Then("^Customer sees new tab opened with something went wrong page$")
    public void customerSeesNewTabOpenedWithSomethingWentWrongPage() { assertTrue(wentWrongPage.isPageDisplayed()); }

    @When("^Customer selects to go to login page$")
    public void customerSelectsToGoToLoginPage() { wentWrongPage.goToLogin(); }

    @Then("^Customer sees new tab opened with reset password page$")
    public void customerSeesNewTabOpenedWithResetPasswordPage() { assertTrue(resetPasswordPage.isPageDisplayed()); }

    @When("^Customer leaves both fields blank$")
    public void customerLeavesBothFieldsBlank() { resetPasswordPage.leaveFieldsBlank();}

    @Then("^Customer cannot submit reset password form$")
    public void customerCannotSubmitResetPasswordForm() { assertFalse(resetPasswordPage.isSubmitAvailable());}

    @And("^Customer sees errors below fields$")
    public void customerSeesErrorsBelowFields() { assertTrue(resetPasswordPage.areErrorsDisplayed());}

    @Then("^Customer sees an error under new password field$")
    public void customerSeesAnErrorUnderNewPasswordField() { assertTrue(resetPasswordPage.isNewPasswordErrorDisplayed());}

    @And("^Customer sees that he fulfill number restriction$")
    public void customerSeesThatHeFulfillNumberRestriction() { assertTrue(resetPasswordPage.isNumberRestrictionFulfilled());}

    @When("^Customer provides password as \"([^\"]*)\" to reset password fields$")
    public void customerProvidesPasswordAsToResetPasswordFields(String arg0) { resetPasswordPage.enterPassword(arg0);}

    @And("^Customer sees that he fulfill special signs and length restriction$")
    public void customerSeesThatHeFulfillSpecialSignsAndLengthRestriction() { assertTrue(resetPasswordPage.areLengthAndComplexityRestrictionsFulfilled());}

    @Then("^Customer sees an error under confirm password field$")
    public void customerSeesAnErrorUnderConfirmPasswordField() { assertTrue(resetPasswordPage.isConfirmPasswordErrorDisplayed());}

    @Then("^Customer sees all three restrictions fulfilled$")
    public void customerSeesAllThreeRestrictionsFulfilled() { assertTrue(resetPasswordPage.areAllRestrictionsFulfilled());}

    @When("^Customer clicks on eye icons$")
    public void customerClicksOnEyeIcons() { resetPasswordPage.clickEyeIcons();}

    @Then("^Customer sees passwords as \"([^\"]*)\"$")
    public void customerSeesPasswordsAs(String arg0) { assertTrue(resetPasswordPage.arePasswordsAs(arg0));}

    @When("^Customer submits reset password form$")
    public void customerSubmitsResetPasswordForm() { resetPasswordPage.submitForm();}

    @Then("^Customer sees reset password confirmation page$")
    public void customerSeesResetPasswordConfirmationPage() { assertTrue(resetPasswordConfirmationPage.isPageDisplayed());}

    @When("^Customer selects to go proceed to login page$")
    public void customerSelectsToGoProceedToLoginPage() { resetPasswordConfirmationPage.goToLogin();}

    @When("^Customer provides credentials as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void customerProvidesCredentialsAsAnd(String arg0, String arg1) { loginPage.enterCredentialsAs(arg0, arg1);}

    @When("^Customer provides password as \"([^\"]*)\" to new password field$")
    public void customerProvidesPasswordAsToNewPasswordField(String arg0) { resetPasswordPage.enterNewPassword(arg0);}

    @And("^Customer provides password as \"([^\"]*)\" to confirm password field$")
    public void customerProvidesPasswordAsToConfirmPasswordField(String arg0) { resetPasswordPage.enterConfirmPassword(arg0);}

    @Then("^Customer sees error stating that password don't match$")
    public void customerSeesErrorStatingThatPasswordDonTMatch() { assertTrue(resetPasswordPage.isNotMatchingErrorDisplayed());}

    @When("^Customer uses token from reset password email$")
    public void customerUsesTokenFromEmail() { super.getAddress(mailPage.extractResetPasswordToken()); }

    @And("^Customer cleans inbox$")
    public void customerCleansInbox() { mailPage.deleteAllThreads(); }

    @When("^Customer uses broken token from email to reset password$")
    public void customerUsesBrokenTokenFromEmail() { super.getAddress(mailPage.breakResetPasswordToken()); }
}
