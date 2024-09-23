package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.StepDefinitionLogin;


public class LoginPage extends StepDefinitionLogin {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(className = "radius")
    WebElement loginButton;

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

}
