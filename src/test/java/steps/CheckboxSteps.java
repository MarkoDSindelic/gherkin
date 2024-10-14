package steps;

import cucumber.TestContext;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jshell.execution.Util;
import org.testng.Assert;
import pages.CheckboxPage;
import utility.Utility;


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

    @When("User clicks checkbox one {int}")
    public void user_clicks_checkbox_one(int num){

        checkboxPage.clickCheckboxByOrder(checkboxPage.checkboxes, num);


    }

    @And("User clicks checkbox two {int}")
    public void user_clicks_checkbox_two(int num){

        checkboxPage.clickCheckboxByOrder(checkboxPage.checkboxes, num);

    }

    @Then("Checkbox is checked {int}")
    public void checkbox_one_is_checked(int num){

        checkboxPage.isSelected(checkboxPage.checkboxes.get(num-1));
    }

    @And("Checkbox is unchecked {int}")
    public void checkbox_two_is_unchecked(int num){

        checkboxPage.isNotSelected(checkboxPage.checkboxes.get(num -1));
    }

}
