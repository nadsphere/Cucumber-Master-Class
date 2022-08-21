package pages;

import org.openqa.selenium.*;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By prdName = By.className("product-name");
    By topDealsText = By.xpath("//a[@href='#/offers']");
    By increBtn = By.xpath("//a[@class='increment']");
    By addCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");

    public void searchProduct(String name){
        driver.findElement(search).sendKeys(name);
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
        int i = quantity-1;
        while (i>0){
            driver.findElement(increBtn).click();
            i--;
        }
    }

    public void clickAddToCart(){
        driver.findElement(addCartBtn).click();
    }
}
