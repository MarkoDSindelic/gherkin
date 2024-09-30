package managers;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverManagerTwo {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;


    public WebDriverManagerTwo(){
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    private WebDriver cerateRemoteDriver(){
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    public WebDriver createLocalDriver(){

        switch (driverType){
            case FIREFOX: driver = new FirefoxDriver();
            break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
        }
        if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }
}
