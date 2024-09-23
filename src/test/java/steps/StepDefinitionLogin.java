package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecurePage;

public class StepDefinitionLogin {

    public static WebDriver driver;
    public LoginPage loginPage;
    public SecurePage securePage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage();
        securePage = new SecurePage();

    }

    @Given("User is on the login page")
    public void user_is_on_login_page(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username){
        loginPage.inputUsername(username);
    }
    @And("User enters valid password {string}")
    public void user_enters_valid_password(String password){
        loginPage.inputPassword(password);
    }
    @And("User clicks login button")
    public void user_clicks_login_button(){
        loginPage.clickLoginButton();
    }
    @Then("User is logged in")
    public void user_is_logged_in(){
        Assert.assertEquals(securePage.getLoginMsgText(), "You logged into a secure area!\n" + "×");
    }
}
