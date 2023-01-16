package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/Features",
        glue={"StepDefinitions"},
        monochrome = true,
        plugin={"pretty", "html:target/HtmlReports.html", "json:target/jsonReport.json","junit:target/junitReport.xml"},
        dryRun = true
       // , tags = ""
)
public class TestRunner {
}
