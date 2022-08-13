package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    public WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartIcon = By.xpath("//img[@alt='Cart']");
    By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    By prodName = By.xpath("//p[@class='product-name']");

    public void checkOutItem() throws Exception{
        driver.findElement(cartIcon).click();
        driver.findElement(checkoutBtn).click();
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
