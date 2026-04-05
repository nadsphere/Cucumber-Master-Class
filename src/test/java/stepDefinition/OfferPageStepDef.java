package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;
import utils.BaseUtil;

public class OfferPageStepDef {
    private final BaseUtil base;
    public String offerProductName;
    private final LandingPage lp;
    private final OfferPage op;

    public OfferPageStepDef(BaseUtil base) {
        this.base = base;
        this.lp = base.pom.getLandingPage();
        this.op = base.pom.getOfferPage();
    }

    public void switchToOfferPage(){
        lp.selectTopDeals();
        base.gu.switchWindowToChild();
    }

    @And("validate product name in Offers Page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() throws Exception{
        Assert.assertEquals(offerProductName, base.landingProductName);
    }

    @Then("User search for the extracted product name in Offers Page")
    public void userSearchForTheExtractedProductNameInOffersPage() throws Exception {
        switchToOfferPage();
        base.gu.waitForPageLoad();
        op.searchItem(base.landingProductName);
        op.waitForProductItem();
        offerProductName = op.getProductItem();
    }
}
