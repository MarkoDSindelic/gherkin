package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class DropdownPage extends BaseClass {

    WebDriver driver;

    public DropdownPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dropdown")
    public WebElement dropdown;


    public void goToDropdownPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("dropdown"));
    }

}
