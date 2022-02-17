Feature: Place the orders for the products

  @Smoke
  Scenario Outline: Search experience for product search in both Home and Offers Page
    Given User is on GreenCart card landing page
    When user searched for shortname <Name> and extract actual name of product
    And added <number> items of the selected product to cart
    Then user proceeds to Checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      |Name | number |
      |Tom  | 3      |
      |Str  | 5      |