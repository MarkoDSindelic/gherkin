package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    WebDriver driver;
    ConfigFileReader configFileReader;

    public DropdownPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dropdown")
    public WebElement dropdown;

    public void selectOption(String value){
        Select obj = new Select(dropdown);
        obj.selectByValue(value);

    }

    public String getSelectText(String value){
        Select obj = new Select(dropdown);

        return obj.getFirstSelectedOption().getText();
    }

    public void goToDropdownPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("dropdown"));
    }

}
