package managers;

import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CustomWebDriverManager {

    private static WebDriver driver;
    private static DriverType driverType;



    public CustomWebDriverManager(){
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }



    private static WebDriver createDriver(){

        switch (driverType){
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    public WebDriver getDriver(){
       return createDriver();
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }
}
