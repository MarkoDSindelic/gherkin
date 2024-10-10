package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utility;

import java.util.List;


public class CheckboxPage extends Utility {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public CheckboxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();

        this.driver = driver;

    }

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkboxOne;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement checkboxTwo;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkboxes;

  /*  public void clickAllCheckboxes(){
        for (int i = 0; i < checkboxes.size() - 1; i++) {
            checkboxes.get(i).click();
        }
    }*/

  public void clickCheckbox(String num) {

      checkboxOne.getAttribute("1");
  }

    public void goToCheckboxPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("checkboxes"));
        //driver.navigate().to(configFileReader.getApplicationURL().concat("checkboxes"));
    }

}
