package cucumberPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features = "Feature"
		,glue={"hippoPages"}
		,monochrome = true
		,plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
		)

public class cucumberRunner {

}
