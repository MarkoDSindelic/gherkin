package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps"},
        plugin = {"json:target/cucumber-json-report.json",
                "html:target/cucumber-html-report",
                "junit: target/cucumber.xml",
                "pretty"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
