package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    public WebDriver driver;
    private final WebDriverWait wait;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By cartIcon = By.xpath("//img[@alt='Cart']");
    By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    By prodName = By.xpath("//p[@class='product-name']");

    public void checkOutItem() throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        jsClick(cartIcon);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        jsClick(checkoutBtn);
    }

    private void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void waitForProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prodName));
    }

    public Boolean verifyPromoBtn(){
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean verifyPlaceOrder(){
        return driver.findElement(placeOrderBtn).isDisplayed();
    }

    public String getProductTitle(){
        return driver.findElement(prodName).getText();
    }
}
