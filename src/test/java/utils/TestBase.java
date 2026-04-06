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
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = initDriver();
        }
        return driver;
    }

    private WebDriver initDriver() {
        Properties prop = new Properties();
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("global.properties")) {
            if (fis == null) {
                throw new IllegalStateException("global.properties not found in classpath");
            }
            prop.load(fis);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load global.properties", e);
        }

        String baseUrl = prop.getProperty("linkUrl");
        String browserProps = prop.getProperty("browser");
        String browserMaven = System.getProperty("browser");
        String browser = (browserMaven != null) ? browserMaven : browserProps;

        if ("Chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if ("Edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalStateException("Unsupported browser: " + browser + ". Supported browsers: Chrome, Edge");
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
