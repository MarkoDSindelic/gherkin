package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

import java.util.List;


public class CheckboxPage extends BaseClass {
    WebDriver driver;

    public CheckboxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkboxOne;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement checkboxTwo;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkbox;

    /* Selects a checkbox by accepting the number of the checkbox as they are shown on the page
     * eg: 1 for the first one, 2 for the one below it, etc.  */
    public void clickCheckboxByOrder(String num) {


        int checkboxNumber = Integer.parseInt(num) - 1;

        checkbox.get(checkboxNumber).click();

    }


    public void goToCheckboxPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("checkboxes"));
    }



}
