package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.StepDefinitionLogin;

public class SecurePage extends StepDefinitionLogin {

    public SecurePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".icon-2x.icon-signout")
    public WebElement logOutButton;

    public void clickLogutButton(){
        logOutButton.click();
    }

}
