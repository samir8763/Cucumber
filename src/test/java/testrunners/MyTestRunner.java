package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/ContactUs.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		
		)

public class MyTestRunner {

}
