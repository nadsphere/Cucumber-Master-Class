package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import utils.BaseUtil;

public class LandingPageStepDef {
    private final BaseUtil base;
    private final LandingPage lp;

    public LandingPageStepDef(BaseUtil base) {
        this.base = base;
        this.lp = base.pom.getLandingPage();
    }

    @Given("User is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() {
        Assert.assertTrue(lp.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with (.+) and extract it$")
    public void userSearchedWithAndExtractIt(String proName) throws Exception{
        lp.searchProduct(proName);
        Thread.sleep(2000);

        base.landingProductName = lp.getProductName().split(" -")[0].trim();
        System.out.println(base.landingProductName + " is extracted");
    }

    @And("added {string} items of the selected product to the cart")
    public void addedItemsOfTheSelectedProductToTheCart(String quantity) throws Exception{
        lp.addItem(Integer.parseInt(quantity));
        Thread.sleep(2000);
        lp.clickAddToCart();
        Thread.sleep(2000);
    }
}
