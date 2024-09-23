package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = {"steps"}
        //plugin = {"pretty", "html:target/cucumber-html-report", "json.cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
