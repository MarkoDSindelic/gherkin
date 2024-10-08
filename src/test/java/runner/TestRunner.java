package runner;


//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;


import java.io.File;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps"},
        plugin = {"json:target/cucumber-json-report.json",
                "html:target/cucumber-html-report",
                "junit: target/cucumber.xml",
                "pretty"},
        monochrome = true //makes console output more readable 
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
