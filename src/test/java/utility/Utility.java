package utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Utility {



    public Utility(){

    }


    /* Page Actions */

    public void clickAction(WebElement webElement){
        webElement.click();
    }

    public void enterData(WebElement webElement, String data){
        webElement.sendKeys(data);
    }

    public void selectDropdownByText(WebElement element, String text){
        Select select = new Select(element);

        for (int i = 0; i < select.getOptions().size() ; i++) {
            if(select.getOptions().get(i).getText().equals(text)){
                select.getOptions().get(i).click();
            }
        }
    }

    public void clickCheckbox(List<WebElement> list, String num) {

        int checkboxNumber = Integer.parseInt(num) - 1;

        list.get(checkboxNumber).click();

    }

    //Login function
    public void login(WebElement usernameField,
                      WebElement passwordField,
                      WebElement loginBtn,
                      String username,
                      String password) {
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();

    }
    /* Get text methods */

    public String getSelectText(WebElement element, String text){
        Select select = new Select(element);

        for (int i = 0; i < select.getOptions().size() ; i++) {

            if(select.getOptions().get(i).getText().equals(text)){
                select.getOptions().get(i).click();

                return select.getOptions().get(i).getText();
            }
        }

        return "No matching value";
    }

    /* Assertions */

    public void isElementDisplayed(WebElement webElement){
         Assert.assertTrue(webElement.isDisplayed());
    }

    public void isEqual(WebElement webElement, String expected){
        String actual = webElement.getText();
        Assert.assertEquals(actual, expected);
    }


    public void isSelected(WebElement webElement){
        Assert.assertTrue(webElement.isSelected());
    }

    public void isNotSelected(WebElement webElement){
        Assert.assertFalse(webElement.isSelected());
    }

}
