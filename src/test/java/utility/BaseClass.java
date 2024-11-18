package utility;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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

    public void isElementNotDisplayed(WebElement webElement){
        Assert.assertFalse(webElement.isDisplayed());
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

    public void clickDropdownOptionByText(String fieldName, String value) throws IllegalAccessException, InvocationTargetException {

        WebElement webElement;

        Field[] fields = this.getClass().getDeclaredFields();
        Method[] methods = this.getClass().getDeclaredMethods();

        for(Field field : fields){
            if(field.getType() == WebElement.class){
                if(field.getName().equals(fieldName)){
                    webElement = (WebElement) field.get(this);

                    for(Method method : methods){
                        if(method.getName().equals("selectDropdownByText")) {
                            method.invoke(webElement, value);
                        }
                    }
                }

            }
        }
    }


   public String getType(String value){

        return value.replaceAll(".*_", "");
   }

   public String getElementName(String value){
       return value.replaceAll("_.*", "");
   }

   public void fillElement(String element, String value) throws Exception {

       Field[] fields = this.getClass().getDeclaredFields();
       WebElement webElement;
       String elementType = this.getType(element);
       String elementName = this.getElementName(element);

       List<String> fieldNames = new ArrayList<>();

       for(Field field : fields){
           fieldNames.add(field.getName());
       }

       for(Field field : fields){
           if(field.getName().equals(elementName) && field.getType() == WebElement.class){
               field.setAccessible(true);

               webElement = (WebElement) field.get(this);
               switch(elementType){
                   case "input":
                       webElement.sendKeys(value);
                       System.out.println("FILLED");
                       break;
                   case "checkbox":
                       webElement.click();
                       System.out.println("CHECKED");
                       break;
                   case "button":
                       webElement.click();
                       System.out.println("CLICKED");
                       break;
                   case "dropdown":
                       this.selectDropdownByText(webElement, value);
                       System.out.println("SELECTED");
                       break;
                   default :
                       System.out.println("No such type");
               }
           }else if(!fieldNames.contains(elementName)){
               System.out.println("No such element: " + elementName);
               break;
           }
       }

   }
}

