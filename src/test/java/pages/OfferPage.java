package pages;

public class OfferPage extends BasePage {

    private String searchResult = "//tbody/tr/td[1]";
    private String searchTextFieldTopDeals = "//input[@id='search-field']";

    public OfferPage() {
        super(driver);
    }

    public void navigateToTopDealsPage()
    {
        navigateTo("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    public void enterSearchCriteriaTopDeals(String criteria){
        write(searchTextFieldTopDeals, criteria);
    }

    public String getResult(){
        return textFromElement(searchResult);
    }
}
