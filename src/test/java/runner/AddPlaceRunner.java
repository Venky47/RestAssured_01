package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature_files",
        glue = {"stepDef"},
        plugin = "json:target/jsonReports/cucumber-report.json",
        tags= "@ExcelSheet"
        )
public class AddPlaceRunner {

}
