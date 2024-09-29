package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SecurePage {

    public SecurePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "radius")
    public WebElement logOutButton;

    @FindBy(id = "flash-messages")
    public WebElement loginMsg;

    public void clickLogutButton(){
        logOutButton.click();
    }

    public String getLoginMsgText(){
        return loginMsg.getText();
    }

}