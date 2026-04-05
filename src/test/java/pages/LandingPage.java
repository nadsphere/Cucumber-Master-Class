package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    private final WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By search = By.xpath("//input[@type='search']");
    By prdName = By.className("product-name");
    By topDealsText = By.xpath("//a[@href='#/offers']");
    By increBtn = By.xpath("//a[@class='increment']");
    By addCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");

    public void searchProduct(String name){
        driver.findElement(search).sendKeys(name);
    }

    public void waitForProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prdName));
    }

    public String getProductName(){
        return driver.findElement(prdName).getText();
    }

    public void selectTopDeals(){
        driver.findElement(topDealsText).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void addItem(int quantity){
        for (int i = 1; i < quantity; i++){
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(increBtn));
            btn.click();
        }
    }

    public void waitForAddToCartClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(addCartBtn));
    }

    public void clickAddToCart(){
        driver.findElement(addCartBtn).click();
    }

    public void waitForCartUpdated() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".pomelo-cart1-badge")));
    }
}
