package steps;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DropdownPage;
import utility.Utility;

public class DropdownSteps {

    public DropdownPage dropdownPage;

    public TestContext testContext;
    public Utility utility;

    public DropdownSteps(TestContext context){
        testContext = context;
        dropdownPage = testContext.getPageObjectManager().getDropdownPage();
        utility = testContext.getUtility();

    }

    @Given("user is on the dropdown page")
    public void user_is_on_the_dropdown_page(){
        dropdownPage.goToDropdownPage();
    }

    @When("user clicks the menu and selects {string}")
    public void user_clicks_the_menu_and_selects_value(String value){
        //dropdownPage.selectOption(value);
        utility.selectDropdownValue(dropdownPage.dropdown, value);
    }

    @Then("Option 1 is selected {string}")
    public void option_one_is_selected(String value){

       String actual =  dropdownPage.getSelectText(value);
       String expected = "Option 1";
       Assert.assertEquals(actual, expected);

    }

    @Then("Option 2 is selected {string}")
    public void option_two_is_selected(String value){
        String actual =  dropdownPage.getSelectText(value);
        String expected = "Option 2";
        Assert.assertEquals(actual, expected);
    }

}
