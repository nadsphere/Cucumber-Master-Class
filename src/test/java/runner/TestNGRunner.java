package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features", monochrome = true,
        glue = "stepDefinition", tags = "@Debug2",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-rep.html",
                "json:target/cucumber-reports/cucumber-rep.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object [][] scenarios(){
        return super.scenarios();
    }
}