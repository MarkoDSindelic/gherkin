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
import pages.CheckboxPage;
import java.time.Duration;

public class CheckboxSteps {

    public static WebDriver driver;

    public CheckboxPage checkboxPage;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        checkboxPage = new CheckboxPage(driver);


    }

    @Given("User is on the checkbox page")
    public void user_is_on_checkbox_page(){
        checkboxPage.goToCheckboxPage();

    }
    @When("User clicks checkbox 1")
    public void user_clicks_checkbox_one(){

        checkboxPage.clickCheckbox(1);

    }
    @And("User clicks checkbox 2")
    public void user_clicks_checkbox_two(){
        checkboxPage.clickCheckbox(2);
    }
    @Then("Checkbox 1 is checked")
    public void checkbox_one_is_checked(){
        Assert.assertTrue(checkboxPage.checkboxOne.isSelected());

    }

    @And("Checkbox 2 is unchecked")
    public void checkbox_two_is_unchecked(){
        Assert.assertFalse(checkboxPage.checkboxTwo.isSelected());
    }



    @After
    public void teardown(){
        driver.quit();
    }

}
