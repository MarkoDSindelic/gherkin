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
    ConfigFileReader configFileReader;

    public CheckboxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    private WebElement checkboxTwo;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkboxes;

    /* Selects a checkbox by accepting the number of the checkbox as they are shown on the page
     * eg: 1 for the first one, 2 for the one below it, etc.  */
    public void clickCheckboxByOrder(int num) {

        int checkboxNumber = num - 1;

        checkboxes.get(checkboxNumber).click();

    }


    public void goToCheckboxPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("checkboxes"));
    }



}
