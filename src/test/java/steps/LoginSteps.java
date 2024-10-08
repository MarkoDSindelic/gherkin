package steps;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SecurePage;
import utility.Utility;

public class LoginSteps {


    TestContext testContext;
    LoginPage loginPage;
    SecurePage securePage;
    Utility utility;

    public LoginSteps(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        securePage = testContext.getPageObjectManager().getSecurePage();
        utility = testContext.getUtility();
    }


    @Given("User is on the login page")
    public void user_is_on_login_page(){
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        loginPage.goToLoginPage();
        //utility.goToPage(loginPage);

        /* Just some tests */
        /*System.out.println("***************");
        utility.goToPage(loginPage);
        System.out.println("***************");
        utility.goToPage(securePage);
        System.out.println("***************");
        utility.goToPage(testContext);
        System.out.println("***************");*/


    }
    @When("User enters username {string}")
    public void user_enters_username(String username){
        utility.enterData(loginPage.usernameField, username);
        //loginPage.inputUsername(username);

    }
    @And("User enters password {string}")
    public void user_enters_password(String password){
        utility.enterData(loginPage.passwordField, password);
        //loginPage.inputPassword(password);
    }
    @And("User clicks login button")
    public void user_clicks_login_button(){
        utility.clickAction(loginPage.loginButton);
        //loginPage.clickLoginButton();

    }
    @Then("User is logged in") //Move to a new class?
    public void user_is_logged_in(){

        String expected = "You logged into a secure area!\n" + "×";

        utility.isEqual(securePage.loginMsg, expected);
        utility.isElementDisplayed(securePage.logOutButton);

        //Assert.assertEquals(utility.getText(securePage.loginMsg), "You logged into a secure area!\n" + "×");
        //Assert.assertTrue(securePage.logOutButton.isDisplayed());
    }
    @Then("User is not logged in")
    public void user_is_not_logged_in(){
        //Assert.assertTrue(loginPage.loginButton.isDisplayed());
        utility.isElementDisplayed(loginPage.loginButton);
    }

}
