package utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecurePage;


public class Utility {


    public Utility(){

    }

    //Nice try, think harder...
   /* public void goToPage(Object object){


        if(object instanceof LoginPage){

            System.out.println("I am login page");
            //driver.navigate().to(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("login"));

        } else if (object instanceof SecurePage) {

            System.out.println("I am secure page");

        } else {
            System.out.println("I am not a page");
        }

    }*/


    /* Page Actions */

    public void clickAction(WebElement webElement){
        webElement.click();
    }

    public void enterData(WebElement webElement, String data){
        webElement.sendKeys(data);
    }

    public void selectDropdownValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    //I probably don't need this one
    public String getText(WebElement webElement){
        return webElement.getText();
    }

    //Login function
    public void login(WebElement usernameField,
                      WebElement passwordField,
                      WebElement loginBtn,
                      String username,
                      String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();

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
