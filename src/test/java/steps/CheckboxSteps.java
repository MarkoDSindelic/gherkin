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

    @When("User clicks checkbox one {string}")
    public void user_clicks_checkbox_one(String num){

        checkboxPage.clickCheckboxByOrder(checkboxPage.checkboxes, num);


    }

    @And("User clicks checkbox two {string}")
    public void user_clicks_checkbox_two(String num){

        checkboxPage.clickCheckboxByOrder(checkboxPage.checkboxes, num);

    }

    @Then("Checkbox one is checked {string}")
    public void checkbox_one_is_checked(String num){

        checkboxPage.isSelected(checkboxPage.checkboxes.get(Integer.parseInt(num )-1));
    }

    @And("Checkbox two is unchecked {string}")
    public void checkbox_two_is_unchecked(String num){

        checkboxPage.isNotSelected(checkboxPage.checkboxes.get(Integer.parseInt(num) -1));
    }

}
