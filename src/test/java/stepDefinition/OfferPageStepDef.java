package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import pages.OfferPage;
import utils.BaseUtil;

public class OfferPageStepDef {
    private final BaseUtil base;
    private String offerProductName;
    private final LandingPage lp;
    private final OfferPage op;

    public OfferPageStepDef(BaseUtil base) {
        this.base = base;
        this.lp = base.getPom().getLandingPage();
        this.op = base.getPom().getOfferPage();
    }

    @Then("User search for the extracted product name in Offers Page")
    public void userSearchForTheExtractedProductNameInOffersPage() {
        lp.selectTopDeals();
        base.getGu().switchToOfferPage();
        base.getGu().waitForPageLoad();

        String searchName = base.getLandingProductName();
        op.searchItem(searchName);
        op.waitForProductItem();

        String productItem = op.getProductItem();
        if (productItem == null || productItem.isBlank()) {
            throw new AssertionError("No product found in Offers Page for: " + searchName);
        }
        offerProductName = productItem;
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(base.getLandingProductName(), offerProductName,
            "Product name in Offers Page does not match Landing Page");
    }
}
