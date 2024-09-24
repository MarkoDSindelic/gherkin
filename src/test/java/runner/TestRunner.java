package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
