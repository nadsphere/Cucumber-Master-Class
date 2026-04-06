package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class GenericUtil {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public GenericUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToOfferPage() {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(org.openqa.selenium.By.xpath("//a[@href='#/offers']")).click();

        Set<String> windows = driver.getWindowHandles();
        if (windows.size() < 2) {
            throw new IllegalStateException(
                "Expected 2 windows but found " + windows.size() + ". Unable to switch to Offers page.");
        }
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
        throw new IllegalStateException("Child window not found");
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
    }
}
