package steps;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckboxPage;


public class CheckboxSteps {

    //public static WebDriver driver;

    //Pages
    public CheckboxPage checkboxPage;

    //utils
//    public PageObjectManager pageObjectManager;
//    public ConfigFileReader configFileReader;
//    public WebDriverManagerTwo webDriverManagerTwo;
    public TestContext testContext;


    public CheckboxSteps(TestContext context){
        testContext = context;
        checkboxPage = testContext.getPageObjectManager().getCheckboxPage();
    }

    
//    @Before
//    public void setup(){
//
//        webDriverManagerTwo = new WebDriverManagerTwo();
//        driver = new WebDriverManagerTwo().createLocalDriver();
//
//        pageObjectManager = new PageObjectManager(driver);
//
//        checkboxPage = pageObjectManager.getCheckboxPage();
//        configFileReader = new ConfigFileReader();
//
//
//    }

    @Given("User is on the checkbox page")
    public void user_is_on_checkbox_page(){
        //driver.navigate().to(configFileReader.getApplicationURL().concat("checkboxes"));
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



//    @After
//    public void teardown(){
//        driver.quit();
//    }

}
