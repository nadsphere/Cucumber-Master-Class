package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OfferPage {
    public WebDriver driver;
    private final WebDriverWait wait;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchField = By.xpath("//input[@id='search-field']");
    By prdItem = By.xpath("//tr/td[1]");

    public void searchItem(String name){
        driver.findElement(searchField).sendKeys(name);
    }

    public void waitForProductItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prdItem));
    }

    public String getProductItem(){
        return driver.findElement(prdItem).getText();
    }
}
