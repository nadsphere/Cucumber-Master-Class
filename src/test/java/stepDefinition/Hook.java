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

    @After
    public void AfterScenario() throws IOException {
        base.tb.WebDriverManager().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = base.tb.WebDriverManager();
        if(scenario.isFailed()){
            // take a screenshot
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image-failed");
        }
    }
}
