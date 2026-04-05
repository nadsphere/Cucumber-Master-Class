package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtil {
    public WebDriver driver;

    public GenericUtil(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
    }
}
