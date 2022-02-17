package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition{
    OfferPage offerPage = new OfferPage();
    TestContextSetup testContextSetup = new TestContextSetup();
    public String offerPageProductName;
    public String textObtained;

    @Then("^user searched for (.+) shortname in offers page$")
    public void userGoAndSearchForSameShortname(String shortname) {
        offerPage.navigateToTopDealsPage();
        offerPage.enterSearchCriteriaTopDeals(shortname);
        offerPageProductName = offerPage.getResult().split("-")[0].trim();
    }

    @And("^validate product name in offer page matches with Landing Page$")
    public void matchProductName(){
        textObtained = testContextSetup.textLandingPage;
        Assert.assertEquals(textObtained,offerPageProductName);
    }
}
