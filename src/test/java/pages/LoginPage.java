package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
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



    }
}
