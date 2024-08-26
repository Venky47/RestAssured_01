package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/addPlace_featureFiles",
        glue = {"addPlace_stepDef"},
        plugin = "json:target/jsonReports/cucumber-report.json",
        tags= "@GoogleTestAPI"
        )
public class AddPlaceRunner {

}
