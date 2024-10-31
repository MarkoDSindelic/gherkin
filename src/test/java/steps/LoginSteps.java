package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SecurePage;
import java.util.List;
import java.util.Map;

public class LoginSteps {


    TestContext testContext;
    LoginPage loginPage;
    SecurePage securePage;

    public LoginSteps(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        securePage = testContext.getPageObjectManager().getSecurePage();
    }


    @Given("User is on the login page")
    public void user_is_on_login_page(){

        loginPage.goToLoginPage();

    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials(DataTable table) {

        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);

        for(Map<String, String> validCredentials : credentials ) {

            String username = validCredentials.get("username");
            String password = validCredentials.get("password");

            loginPage.login(username, password);

        }

    }

    @Then("User is logged in")
    public void user_is_logged_in(){
        String expected = "You logged into a secure area!\n" + "×";
        loginPage.isEqual(loginPage.loginMsg, expected);
        loginPage.isElementDisplayed(securePage.logOutButton);
    }
    @Then("User is not logged in")
    public void user_is_not_logged_in(){
        loginPage.isElementDisplayed(loginPage.loginButton);
    }

    @When("User tries to login with invalid credentials")
    public void userTriesToLoginWithInvalidCredentials(DataTable table ) {

        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);

        for(Map<String, String> invalidCredentials : credentials){
            String username = invalidCredentials.get("username");
            String password = invalidCredentials.get("password");
            loginPage.login(username, password);
        }
    }

}
