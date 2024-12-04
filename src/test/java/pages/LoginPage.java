package pages;

import dataProvider.ConfigHelper;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;


public class LoginPage extends BaseClass {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(className = "radius")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement loginMsg;


    /* Login */
    public void login(String username, String password){

        super.enterData(usernameField, username);
        super.enterData(passwordField, password);
        super.clickAction(loginButton);

    }

    public void goToLoginPage(){

        driver.get(ConfigHelper.get("login"));

    }
}
