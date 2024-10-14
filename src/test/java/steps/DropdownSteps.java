package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DropdownPage;
import utility.Utility;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


public class DropdownSteps extends Utility {

    public DropdownPage dropdownPage;
    public TestContext testContext;


    public DropdownSteps(TestContext context){
        testContext = context;
        dropdownPage = testContext.getPageObjectManager().getDropdownPage();

    }

    @Given("user is on the dropdown page")
    public void user_is_on_the_dropdown_page(){
        dropdownPage.goToDropdownPage();
    }

    @When("user clicks the menu and selects")
    public void user_clicks_the_menu_and_selects_value(DataTable table) throws NoSuchFieldException {

        List<Map<String, String>> dropdownMenu = table.asMaps(String.class, String.class);


        for(Map<String, String> input : dropdownMenu ){

            String elementName = input.get("field");
            String option = input.get("options");

            WebElement el = dropdownPage.getWebElementByName(dropdownPage, elementName);
            dropdownPage.selectDropdownByText(el, option);

        }

    }

    @Then("Correct option is selected")
    public void option_one_is_selected(DataTable table){

        List<Map<String, String>> dropdownMenu = table.asMaps(String.class, String.class);

        for(Map<String, String> input : dropdownMenu ){

            String expected = input.get("options");
            String actual = dropdownPage.getSelectText(dropdownPage.dropdown, expected );
            Assert.assertEquals(actual, expected);

        }

    }


}
