package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By cartIcon = By.xpath("//img[@alt='Cart']");
    private By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoBtn = By.cssSelector(".promoBtn");
    private By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    private By prodName = By.xpath("//p[@class='product-name']");

    public void checkOutItem() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        jsClick(cartIcon);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        jsClick(checkoutBtn);
    }

    private void jsClick(By locator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void waitForProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prodName));
    }

    public void assertPromoButtonIsDisplayed() {
        WebElement promoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(promoBtn));
        org.testng.Assert.assertTrue(promoButton.isDisplayed(), "Promo button is not displayed");
    }

    public void assertPlaceOrderButtonIsDisplayed() {
        WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn));
        org.testng.Assert.assertTrue(placeOrderButton.isDisplayed(), "Place Order button is not displayed");
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(prodName)).getText();
    }
}
