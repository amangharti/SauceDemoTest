package runnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/features/login.feature",
		glue ="stepDefinitions",
		dryRun = false,
		plugin = {"pretty","html:target/htmlReport.html","json:target/Cucumber.json","junit:target/Cucumber.xml"},
		monochrome = true
		)

public class Runner {

}
