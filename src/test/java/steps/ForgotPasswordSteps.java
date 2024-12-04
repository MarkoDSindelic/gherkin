package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ForgotPasswordPage;
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
    @When("I enter my email in the")
    public void i_enter_my_email(DataTable table) throws Exception {

        List<String> values = table.asList(String.class);

        String element= values.get(0);
        String value = values.get(1);

        forgotPasswordPage.fillElement(element, value);

    }


    @And("I click")
    public void i_click_retrieve_password_button(DataTable table) throws Exception {

        List<String> values = table.asList(String.class);

       String element = values.get(0);
       String value = values.get(1);

       forgotPasswordPage.fillElement(element, value);
        
    }

    @Then("I get my password")
    public void i_get_my_password() throws InterruptedException {
        String expected = "Internal Server Error";
        String actual = forgotPasswordPage.error_message.getText();
        Assert.assertEquals(actual, expected);
    }

}
