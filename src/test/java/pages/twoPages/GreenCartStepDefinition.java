package pages.twoPages;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LandingPage;
import pages.OfferPage;

public class GreenCartStepDefinition {

    LandingPage landingPage = new LandingPage();
    OfferPage offerPage = new OfferPage();
    public String landingPageProductName;
    public String offerPageProductName;


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
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void userGoAndSearchForSameShortname(String shortname) throws InterruptedException {
        offerPage.navigateToTopDealsPage();
        offerPage.enterSearchCriteriaTopDeals(shortname);
        offerPageProductName = offerPage.getResult().split("-")[0].trim();
    }

    @And("^validate product name in offer page matches with Landing Page$")
    public void matchProductName(){
        Assert.assertEquals(landingPageProductName,offerPageProductName);
    }
}
