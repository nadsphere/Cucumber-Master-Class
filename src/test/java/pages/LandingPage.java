package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By search = By.xpath("//input[@type='search']");
    private By topDealsText = By.xpath("//a[@href='#/offers']");
    private By increBtn = By.xpath("//a[@class='increment']");
    private By addCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");

    public void searchProduct(String name) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(search));
        searchField.clear();
        searchField.sendKeys(name);
    }

    public void waitForProductName() {
        wait.until(d -> {
            Long visible = (Long) ((JavascriptExecutor) d).executeScript(
                "var els = document.querySelectorAll('h4.product-name');" +
                "var count = 0; for(var i=0;i<els.length;i++){if(els[i].offsetParent !== null) count++;} return count;"
            );
            return visible != null && visible == 1;
        });
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name"))).getText();
    }

    public void selectTopDeals() {
        wait.until(ExpectedConditions.elementToBeClickable(topDealsText)).click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

    public void addItem(int quantity) {
        for (int i = 1; i < quantity; i++) {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(increBtn));
            btn.click();
        }
    }

    public void waitForAddToCartClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(addCartBtn));
    }

    public void clickAddToCart() {
        driver.findElement(addCartBtn).click();
    }

    public void waitForCartUpdated() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".pomelo-cart1-badge")));
    }
}
