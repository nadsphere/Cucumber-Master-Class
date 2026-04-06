package runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features/SearchProduct.feature",
        glue = "stepDefinition",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/searchproduct-rep.html",
                "json:target/cucumber-reports/searchproduct-rep.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class SearchProductRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
