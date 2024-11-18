package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class ForgotPasswordPage extends BaseClass {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "form_submit")
    private WebElement retrievePassword;

    @FindBy(tagName = "h1")
    public WebElement error_message;

    public void goToForgotPasswordPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("forgot_password"));
    }

}
