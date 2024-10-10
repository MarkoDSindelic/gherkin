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
        //driver.navigate().to(configFileReader.getApplicationURL().concat("checkboxes"));
        checkboxPage.goToCheckboxPage();

    }

    @When("User clicks checkbox one {string}")
    public void user_clicks_checkbox_one(String num){
        //utility.clickAction(checkboxPage.checkboxOne);
        //checkboxPage.clickAllCheckboxes();
        checkboxPage.clickCheckbox(checkboxPage.checkboxes, num);


    }

    @And("User clicks checkbox two {string}")
    public void user_clicks_checkbox_two(String num){
        //checkboxPage.clickCheckbox(num);

        checkboxPage.clickCheckbox(checkboxPage.checkboxes, num);

    }

    @Then("Checkbox one is checked {string}")
    public void checkbox_one_is_checked(String num){
        //utility.isSelected(checkboxPage.checkboxOne);
        //Assert.assertTrue(checkboxPage.checkboxOne.isSelected());
        checkboxPage.isSelected(checkboxPage.checkboxes.get(Integer.parseInt(num )-1));
    }

    @And("Checkbox two is unchecked {string}")
    public void checkbox_two_is_unchecked(String num){
        //utility.isNotSelected(checkboxPage.checkboxTwo);
        //Assert.assertFalse(checkboxPage.checkboxTwo.isSelected());
        checkboxPage.isNotSelected(checkboxPage.checkboxes.get(Integer.parseInt(num) -1));
    }

}
