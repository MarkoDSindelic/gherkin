package steps;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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
    public void user_clicks_checkbox(DataTable table) throws Exception {

        List<String> values = table.asList(String.class);

        checkboxPage.fillElement(values.get(0), "");
        checkboxPage.fillElement(values.get(1), "");


    }

    @Then("Checkbox is checked")
    public void checkbox_is_checked(DataTable table)  {

        //List<String> values = table.asList(String.class);

        Assert.assertTrue(checkboxPage.checkboxOne.isSelected());
    }

    @Then("Checkbox is unchecked")
    public void checkbox_is_unchecked(DataTable table){

        //List<String> values = table.asList(String.class);

        Assert.assertFalse(checkboxPage.checkboxTwo.isSelected());

    }

}
