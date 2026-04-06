package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckOutPage;
import utils.BaseUtil;

public class CheckOutStepDef {
    private final CheckOutPage checkOutPage;

    public CheckOutStepDef(BaseUtil base) {
        this.checkOutPage = base.pom.getCheckOutPage();
    }

    @Then("^User proceed to checkout and validate the (.+) items in checkout page$")
    public void userProceedToCheckoutAndValidateTheNameItemsInCheckoutPage(String productName) throws Exception {
        checkOutPage.checkOutItem();
        checkOutPage.waitForProductTitle();
        String checkoutProductName = checkOutPage.getProductTitle().split(" -")[0].trim();
        Assert.assertEquals(productName, checkoutProductName);
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkOutPage.verifyPromoBtn());
        Assert.assertTrue(checkOutPage.verifyPlaceOrder());
    }
}
