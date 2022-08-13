package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
    public WebDriver driver;
    public OfferPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchField = By.xpath("//input[@id='search-field']");
    By prdItem = By.xpath("//tr/td[1]");

    public void searchItem(String name){
        driver.findElement(searchField).sendKeys(name);
    }

    public void getSearchText(){
        driver.findElement(searchField).getText();
    }

    public String getProductItem(){
        return driver.findElement(prdItem).getText();
    }
}
