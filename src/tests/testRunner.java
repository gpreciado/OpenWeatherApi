package tests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/features/OpenWeatherApi",
		dryRun = false,
		glue = {"stepdefinition"}
		)

public class testRunner {

}
