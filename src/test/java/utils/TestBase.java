package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        // buat ngebaca file global.properties
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String baseUrl = prop.getProperty("linkUrl");
        if (driver == null) {
            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            } else if (prop.getProperty("browser").equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
        return driver;
    }
}
