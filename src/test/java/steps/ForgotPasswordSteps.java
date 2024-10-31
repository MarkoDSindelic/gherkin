package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ForgotPasswordSteps {

    ForgotPasswordPage forgotPasswordPage;
    TestContext testContext;

    public ForgotPasswordSteps(TestContext context) {
        testContext = context;
        forgotPasswordPage = testContext.getPageObjectManager().forgotPasswordPage();

    }

    @Given("I am on the forgot password page")
    public void i_am_on_the_forgot_password_page(){
        forgotPasswordPage.goToForgotPasswordPage();
    }
    @When("I enter my email")
    public void i_enter_my_email(DataTable table) throws IllegalAccessException, InvocationTargetException {

        List<String> values = table.asList(String.class);
        for (int i = 1; i < values.size(); i++) {
            forgotPasswordPage.elementAction(values.get(0), values.get(i));
        }
    }

    @And("I click retrieve password button")
    public void i_click_retrieve_password_button(DataTable table) throws IllegalAccessException, InvocationTargetException {
        List<String> values = table.asList(String.class);

        for (int i = 1; i < values.size(); i++) {
            forgotPasswordPage.elementAction(values.get(0), values.get(i));
        }
    }

    @Then("I get my password")
    public void i_get_my_password(){
        System.out.println("You got your password");
    }

}
