package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckOutPage;
import utils.BaseUtil;

public class CheckOutStepDef {
    private final CheckOutPage checkOutPage;

    public CheckOutStepDef(BaseUtil base) {
        this.checkOutPage = base.getPom().getCheckOutPage();
    }

    @Then("^User proceed to checkout and validate the (.+) items in checkout page$")
    public void userProceedToCheckoutAndValidateTheNameItemsInCheckoutPage(String productName) {
        checkOutPage.checkOutItem();
        checkOutPage.waitForProductTitle();

        String checkoutProductName = checkOutPage.getProductTitle();
        int dashIndex = checkoutProductName.indexOf(" -");
        String extracted = (dashIndex > 0) ? checkoutProductName.substring(0, dashIndex).trim() : checkoutProductName.trim();
        Assert.assertEquals(extracted, productName,
            "Checkout product name does not match expected: expected '" + productName + "' but found '" + extracted + "'");
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        checkOutPage.assertPromoButtonIsDisplayed();
        checkOutPage.assertPlaceOrderButtonIsDisplayed();
    }
}
