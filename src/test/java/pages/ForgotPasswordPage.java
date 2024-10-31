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
    public WebElement email_field;

    @FindBy(id = "form_submit")
    public WebElement retrieve_password_button;

    public void goToForgotPasswordPage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat("forgot_password"));
    }

}
