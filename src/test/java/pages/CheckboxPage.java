package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.CheckboxSteps;


public class CheckboxPage extends CheckboxSteps {

    public CheckboxPage(WebDriver driver){
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

    public void goToCheckboxPage(){
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
    }

}
