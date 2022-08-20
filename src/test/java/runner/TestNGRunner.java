package runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features", monochrome = true,
        glue = "stepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-rep.html",
                "json:target/cucumber-reports/cucumber-rep.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object [][] scenarios(){
        return super.scenarios();
    }
}