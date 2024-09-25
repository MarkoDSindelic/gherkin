package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.CheckboxSteps;


public class CheckboxPage extends CheckboxSteps {

    public CheckboxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkboxOne;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement checkboxTwo;




    public void clickCheckbox(Integer num){

        if (num == 1 ){
            checkboxOne.click();
        } else if (num == 2) {
            checkboxTwo.click();
        }
    }

}
