package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CheckboxPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    FileReaderManager fileReaderManager;

    public CheckboxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();

        this.driver = driver;

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
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("checkboxes"));
        //driver.navigate().to(configFileReader.getApplicationURL().concat("checkboxes"));
    }

}
