package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String baseUrl = prop.getProperty("linkUrl");
        String browserProps = prop.getProperty("browser");
        String browserMaven = System.getProperty("browser");

        String browser = browserMaven != null ? browserMaven : browserProps;

        if (driver == null) {
            if(browser.equalsIgnoreCase("Chrome")){
                ChromeOptions options = new ChromeOptions();
                options.setBrowserVersion("stable");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
        return driver;
    }
}
