package managers;

import org.openqa.selenium.WebDriver;
import pages.CheckboxPage;
import pages.DropdownPage;
import pages.LoginPage;
import pages.SecurePage;

public class PageObjectManager {

    WebDriver driver;
    CheckboxPage checkboxPage;
    LoginPage loginPage;
    SecurePage securePage;
    DropdownPage dropdownPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getLoginPage(){

        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }

    public CheckboxPage getCheckboxPage(){
        return (checkboxPage == null ) ? checkboxPage = new CheckboxPage(driver) : checkboxPage;
    }

    public SecurePage getSecurePage(){
        return (securePage == null) ? securePage = new SecurePage(driver) : securePage;
    }

    public DropdownPage getDropdownPage(){
        return (dropdownPage == null) ? dropdownPage = new DropdownPage(driver) : dropdownPage;
    }

}
