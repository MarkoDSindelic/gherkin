package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckboxPage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


public class CheckboxSteps {


    public CheckboxPage checkboxPage;
    public TestContext testContext;

    public CheckboxSteps(TestContext context){
        testContext = context;
        checkboxPage = testContext.getPageObjectManager().getCheckboxPage();
    }


    @Given("User is on the checkbox page")
    public void user_is_on_checkbox_page(){
        checkboxPage.goToCheckboxPage();

    }

    /* TO DO */
    @When("User clicks checkbox")
    public void user_clicks_checkbox(DataTable table) throws IllegalAccessException, InvocationTargetException {

        List<String> values = table.asList(String.class);

        for (int i = 1; i < values.size(); i++) {
            String name = values.get(0);
            String num = values.get(i);

            checkboxPage.elementAction(name, num);

        }






    }

    @Then("Checkbox is checked")
    public void checkbox_is_checked(DataTable table) throws InvocationTargetException, IllegalAccessException {

        List<Map<String, String>> values = table.asMaps(String.class, String.class);

        for(Map<String, String> input : values){

            String num = input.get("checkbox");

            checkboxPage.elementAction("checkbox", num);

        }

    }

    @Then("Checkbox is unchecked")
    public void checkbox_is_unchecked(DataTable table){

        List<Map<String, Integer>> values = table.asMaps(String.class, Integer.class);

        for(Map<String, Integer> input : values){

            int num = input.get("checkbox");

            checkboxPage.isNotSelected(checkboxPage.checkbox.get(num -1));
        }

    }

}
