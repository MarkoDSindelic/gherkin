package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckboxPage;

import java.util.List;


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

    @When("User clicks checkbox")
    public void user_clicks_checkbox_one(DataTable table){

        List<List<Integer>> values = table.asLists(Integer.class);

        for (int i = 0; i < values.size() ; i++) {

            for (int j = 0; j < values.get(i).size() ; j++) {

                checkboxPage.clickCheckboxByOrder(values.get(i).get(j));
            }
        }

    }

    @Then("Checkbox is checked")
    public void checkbox_is_checked(DataTable table){

        List<List<Integer>> values = table.asLists(Integer.class);
        for (int i = 0; i < values.size() ; i++) {

            for (int j = 0; j < values.get(i).size() ; j++) {
                int num = values.get(i).get(j);
                checkboxPage.isSelected(checkboxPage.checkboxes.get(num-1));
            }
        }

    }

    @Then("Checkbox is unchecked")
    public void checkbox_is_unchecked(DataTable table){

        List<List<Integer>> values = table.asLists(Integer.class);
        for (int i = 0; i < values.size() ; i++) {
            for (int j = 0; j < values.get(i).size() ; j++) {
                int num = values.get(i).get(j);
                checkboxPage.isNotSelected(checkboxPage.checkboxes.get(num-1));
            }
        }
    }

}
