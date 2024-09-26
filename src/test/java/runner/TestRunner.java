package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"json:target/cucumber-json-report.json",
                "html:target/cucumber-html-report",
                "junit: target/cucumber.xml"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
