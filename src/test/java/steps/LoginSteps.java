package steps;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import managers.WebDriverManagerTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecurePage;

import java.time.Duration;

public class LoginSteps {

    public static WebDriver driver;

    public SecurePage securePage;
//    public PageObjectManager pageObjectManager;
//    public WebDriverManagerTwo webDriverManagerTwo;

    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        securePage = testContext.getPageObjectManager().getSecurePage();
    }

//    @Before
//    public void setup(){
//
//        webDriverManagerTwo = new WebDriverManagerTwo();
//        driver = webDriverManagerTwo.createLocalDriver();
//
//        pageObjectManager = new PageObjectManager(driver);
//
//        loginPage = pageObjectManager.getLoginPage();
//        securePage = pageObjectManager.getSecurePage();
//
//
//    }

    @Given("User is on the login page")
    public void user_is_on_login_page(){
        //driver.navigate().to("https://the-internet.herokuapp.com/login");
        loginPage.goToLoginPage();
    }
    @When("User enters username {string}")
    public void user_enters_username(String username){ //userEnters
        loginPage.inputUsername(username);
    }
    @And("User enters password {string}")
    public void user_enters_password(String password){
        loginPage.inputPassword(password);
    }
    @And("User clicks login button")
    public void user_clicks_login_button(){
        loginPage.clickLoginButton();
    }
    @Then("User is logged in")
    public void user_is_logged_in(){

        Assert.assertEquals(securePage.getLoginMsgText(), "You logged into a secure area!\n" + "×");
        Assert.assertTrue(securePage.logOutButton.isDisplayed());


    }
    @Then("User is not logged in")
    public void user_is_not_logged_in(){
        Assert.assertTrue(loginPage.loginButton.isDisplayed());

    }

//    @After
//    public void teardown(){
//        driver.quit();
//    }
}
