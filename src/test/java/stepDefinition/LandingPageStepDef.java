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
        this.lp = base.getPom().getLandingPage();
    }

    @Given("User is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() {
        Assert.assertTrue(
            lp.getTitleLandingPage().contains("GreenKart"),
            "Page title should contain 'GreenKart'"
        );
    }

    @When("^User searched with (.+) and extract it$")
    public void userSearchedWithAndExtractIt(String proName) {
        lp.searchProduct(proName);
        lp.waitForProductName();

        String productName = lp.getProductName();
        int dashIndex = productName.indexOf(" -");
        String extracted = (dashIndex > 0) ? productName.substring(0, dashIndex).trim() : productName.trim();
        base.setLandingProductName(extracted);
    }

    @When("added {string} items of the selected product to the cart")
    public void addedItemsOfTheSelectedProductToTheCart(String quantity) {
        lp.addItem(Integer.parseInt(quantity));
        lp.waitForAddToCartClickable();
        lp.clickAddToCart();
        lp.waitForCartUpdated();
    }
}
