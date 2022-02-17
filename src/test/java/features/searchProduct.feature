Feature: Search and Place the order for Products

  Scenario Outline: Search experience for product search in both Home and Offers Page
    Given User is on GreenCart card landing page
    When user searched for shortname <shortName> and extract actual name of product
    Then user searched for <shortName> shortname in offers page
    And validate product name in offer page matches with Landing Page

    Examples:
      |shortName |
      |Tom       |
      |Str       |
      |Alv       |
