package utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.List;

public class BaseClass {



    public BaseClass(){

    }


    /* Page Actions */

    /* Clicks a clickable web element */
    public void clickAction(WebElement webElement){
        webElement.click();
    }

    /* Enters data into the field */
    public void enterData(WebElement inputField, String data){
        inputField.sendKeys(data);
    }

    /* Selects the dropdown menu item based on the text displayed in the dropdown*/
    public void selectDropdownByText(WebElement dropdown, String text){
        Select select = new Select(dropdown);

        for (int i = 0; i < select.getOptions().size() ; i++) {
            if(select.getOptions().get(i).getText().equals(text)){
                select.getOptions().get(i).click();
            }
        }
    }



    /* Returns a text string from the specific dropdown field */
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

    /* Checks if element is dipsplayed on the page */
    public void isElementDisplayed(WebElement webElement){
         Assert.assertTrue(webElement.isDisplayed());
    }
    /* Checks if two strings are equal */
    public void isEqual(WebElement webElement, String expected){
        String actual = webElement.getText();
        Assert.assertEquals(actual, expected);
    }

    /* Checks if checkbox is selected */
    public void isSelected(WebElement webElement){
        Assert.assertTrue(webElement.isSelected());
    }
    /* Checks if checkbox is not selected */
    public void isNotSelected(WebElement webElement){
        Assert.assertFalse(webElement.isSelected());
    }


    public WebElement getWebElementByName(Object object, String fieldName){

        WebElement webElement = null;

        Field[] fields = object.getClass().getDeclaredFields();

        for(Field field : fields){
            if(field.getType() == WebElement.class){
                field.setAccessible(true);
                if(field.getName().equals(fieldName)){
                    try{
                        webElement = (WebElement) field.get(object);
                    } catch (IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        return webElement;
    }

}
