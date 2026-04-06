package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OfferPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By searchField = By.id("search-field");
    private By prdItem = By.xpath("//tbody//tr/td[1]");
    private By tableBody = By.xpath("//tbody");

    public void searchItem(String name) {
        WebElement searchEl = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchEl.clear();
        searchEl.sendKeys(name);
    }

    public void waitForProductItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
    }

    public String getProductItem() {
        return driver.findElement(prdItem).getText();
    }
}
