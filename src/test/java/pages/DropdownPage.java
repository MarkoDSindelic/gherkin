package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class DropdownPage extends Utility {

    WebDriver driver;

    public DropdownPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dropdown")
    public WebElement dropdown;

    public void selectOption(String value){
        Select select = new Select(dropdown);

        for (int i = 0; i < select.getOptions().size() ; i++) {
            if(select.getOptions().get(i).getText().equals(value)){
                select.getOptions().get(i).click();
            }
        }
    }

    /*public String getSelectText(String value){
        Select select = new Select(dropdown);

        for (int i = 0; i < select.getOptions().size() ; i++) {

            if(select.getOptions().get(i).getText().equals(value)){
                select.getOptions().get(i).click();

                return select.getOptions().get(i).getText();
            }
        }

        return "No matching value";
    }*/

    public void goToDropdownPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("dropdown"));
    }

}
