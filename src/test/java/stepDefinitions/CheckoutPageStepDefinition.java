package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LandingPage;

public class CheckoutPageStepDefinition {
    LandingPage landingPage = new LandingPage();
    public String name;

    @Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
    public void proceedToCheckout(String productName){
        landingPage.checkItems();
        name = landingPage.getItemOnTheTable(productName).split("-")[0].trim();
        System.out.println(name);
    }

    @And("^verify user has ability to enter promo code and place the order$")
    public void verifyPromoCode() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(landingPage.verifyPromoBtn());
        Assert.assertTrue(landingPage.verifyPlaceOrder());
    }
}
