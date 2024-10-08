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
        //utility = testContext.getUtility();
    }


    @Given("User is on the checkbox page")
    public void user_is_on_checkbox_page(){
        //driver.navigate().to(configFileReader.getApplicationURL().concat("checkboxes"));
        checkboxPage.goToCheckboxPage();

    }

    @When("User clicks checkbox one {string}")
    public void user_clicks_checkbox_one(String num){

        checkboxPage.clickCheckbox(checkboxPage.checkboxes, num);
        //utility.clickAction(checkboxPage.checkboxOne);
        //checkboxPage.clickAllCheckboxes();


    }

    @And("User clicks checkbox two {string}")
    public void user_clicks_checkbox_two(String num){
        //checkboxPage.clickCheckbox(num);
        //utility.clickAction(checkboxPage.checkboxTwo);
        //checkboxPage.clickCheckbox(2);
        checkboxPage.clickCheckbox(checkboxPage.checkboxes, num);

    }

    @Then("Checkbox 1 is checked")
    public void checkbox_one_is_checked(){
        //utility.isSelected(checkboxPage.checkboxOne);
        //Assert.assertTrue(checkboxPage.checkboxOne.isSelected());
        checkboxPage.isSelected(checkboxPage.checkboxes.get(0));
    }

    @And("Checkbox 2 is unchecked")
    public void checkbox_two_is_unchecked(){
        //utility.isNotSelected(checkboxPage.checkboxTwo);
        //Assert.assertFalse(checkboxPage.checkboxTwo.isSelected());
        checkboxPage.isNotSelected(checkboxPage.checkboxes.get(1));
    }

}
