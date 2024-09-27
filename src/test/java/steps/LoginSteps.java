package steps;

import io.cucumber.java.After;
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

import java.time.Duration;

public class LoginSteps {

    public static WebDriver driver;
    public LoginPage loginPage;
    public SecurePage securePage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);

    }

    @Given("User is on the login page")
    public void user_is_on_login_page(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
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

    @After
    public void teardown(){
        driver.quit();
    }
}
