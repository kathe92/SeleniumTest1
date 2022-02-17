package pages;

public class LandingPage extends BasePage {

    private String searchButton = "//input[@type='search']";
    private String searchTextField = "//input[@type='search']";
    private String searchResult = "//h4[@class='product-name']";
    private String cartBagImage = "//img[@alt='Cart']";
    private String checkoutButton = "//button[contains(text(), 'PROCEED TO CHECKOUT')]";
    private String promoButton = "//button[@class='promoBtn']";
    private String placeOrderButton = "//button[contains(text(), 'Place Order')]";
    private String addItems = "//input[@class='quantity']";
    private String addToCartButton = "//button[contains(text(), 'ADD TO CART')]";
    private String itemOnTheTable = "//p[@class='product-name']";

    public LandingPage() {
        super(driver);
    }

    public void navigateToGreenCartPage(){
        navigateTo("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public void greenCartSearch(){
        clickElement(searchButton);
    }

    public String getResult(){
        return textFromElement(searchResult);
    }

    public void addItemsToTheCart(int number){;
        writeInt(addItems,number);
    }

    public void addToCart(){
        clickElement(addToCartButton);
    }

    public void checkItems(){
        clickElement(cartBagImage);
        clickElement(checkoutButton);
    }

    public String getItemOnTheTable(String productName){
        return textFromElement(itemOnTheTable);
    }

    public boolean verifyPromoBtn(){
        return elementIsDisplayed(promoButton);
    }

    public boolean verifyPlaceOrder(){
        return elementIsDisplayed(placeOrderButton);
    }
}
