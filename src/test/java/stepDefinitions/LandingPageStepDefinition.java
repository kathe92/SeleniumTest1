package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    LandingPage landingPage = new LandingPage();
    TestContextSetup testContextSetup = new TestContextSetup();
    public String landingPageProductName;

    @Given("^User is on GreenCart card landing page$")
    public void goToGreenCart(){
        landingPage.navigateToGreenCartPage();
    }

    @When("^user searched for shortname (.+) and extract actual name of product$")
    public void userSearchedForShortname(String shortname) throws InterruptedException {
        landingPage.enterSearchCriteria(shortname);
        landingPage.greenCartSearch();
        Thread.sleep(4000);
        landingPageProductName = landingPage.getResult().split("-")[0].trim();
        testContextSetup.TestContextSetup(landingPageProductName);
    }

    @And("^added (.+) items of the selected product to cart$")
    public void addItemsToTheCart(int itemNumber) throws InterruptedException {
        landingPage.addItemsToTheCart(itemNumber);
        Thread.sleep(1000);
        landingPage.addToCart();
    }
}
