package runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features/Checkout.feature",
        glue = "stepDefinition",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/checkout-rep.html",
                "json:target/cucumber-reports/checkout-rep.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
