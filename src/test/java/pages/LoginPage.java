package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;


public class LoginPage {

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
    public WebElement logoutMsg;


    public void inputUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getLogoutTxt(){
        return logoutMsg.getText();
    }

    public void goToLoginPage(){

        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("login"));

    }
}
