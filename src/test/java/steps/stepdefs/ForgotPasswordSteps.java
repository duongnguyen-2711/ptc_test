package steps.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pageObject.pages.forgotPassword.ForgotPasswordPage;
import pageObject.pages.forgotPassword.ThankYouPage;
import steps.commonsteps.CommonSteps;

public class ForgotPasswordSteps {
    @Steps
    CommonSteps commonSteps;

    @When("I go to forgot password page")
    public void i_go_to_forgot_password_page() {
        commonSteps.openForgotPasswordPage();
    }

    @When("I input {string} into email field")
    public void i_input_email(String email) {
        new ForgotPasswordPage().inputEmail(email);
    }

    @Then("I can see error message displayed")
    public void i_can_see_error_message_displayed(){
        Assert.assertEquals("The inputted email does not existed.", new ForgotPasswordPage().getErrorMessage());
    }

    @When("I click send button")
    public void i_click_send_button(){
        new ForgotPasswordPage().clickSendBtn();
    }

    @Then("I can see request accepted message")
    public void i_can_see_accepted_message(){
        Assert.assertTrue(new ThankYouPage().isRequestedAccepted());
    }
}
