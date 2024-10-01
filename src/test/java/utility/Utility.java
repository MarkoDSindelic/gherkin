package utility;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CheckboxPage;
import pages.LoginPage;

public class Utility {


    public Utility(){

    }

//    public void goToPage(Object object){
//
//
//        if(object instanceof LoginPage){
//
//            driver.navigate().to("https://the-internet.herokuapp.com/login");
//
//        } else if (object instanceof CheckboxPage) {
//
//            driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
//        }
//
//    }



    /* Page Actions */

    public void clickAction(WebElement webElement){
        webElement.click();
    }

    public void enterData(WebElement webElement, String data){
        webElement.sendKeys(data);
    }

    //I probably don't need this one
    public String getText(WebElement webElement){
        return webElement.getText();
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
