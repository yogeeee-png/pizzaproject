package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

features = "src/test/resources/features",
glue = {"stepdefinitions","hooks"},
monochrome = true,

plugin = {
"pretty",
"html:target/cucumber-report.html",
"json:target/cucumber.json"
},

tags = "@Smoke"
)

public class TestRunner {

}