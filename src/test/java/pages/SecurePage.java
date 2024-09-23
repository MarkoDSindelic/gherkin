package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SecurePage extends LoginPage {

    public SecurePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = ".icon-2x.icon-signout")
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
