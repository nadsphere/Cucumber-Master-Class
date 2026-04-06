package stepDefinition;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.BaseUtil;

import java.io.*;

public class Hook {
    private final BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        base.getTb().getDriver();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        base.getTb().quitDriver();
    }

    @AfterStep(order = 1)
    public void addScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = base.getTb().getDriver();
        if (scenario.isFailed() && driver != null) {
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
                scenario.attach(fileContent, "image/png", "image-failed");
            } catch (WebDriverException e) {
                // Driver may have been quit already
            }
        }
    }
}
