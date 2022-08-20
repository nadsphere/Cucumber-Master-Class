Feature: Search and place the order of Products

  @SearchProduct1
  Scenario: Search experience for product search in both home and Offers page
    Given User is on GreenKart landing page
    When User searched with Shortname "Tom" and extract actual name of product
    Then User search for "Tom" shortname in offers page
    And validate product name in Offers Page matches with Landing Page

  @SearchProduct2
  Scenario Outline: Search experience for product search in Home and Offers page using Scenario Outline
    Given User is on GreenKart landing page
    When User searched with <name> and extract it
    Then User search for <name> in Offers Page
    And validate product name in Offers Page matches with Landing Page

    Examples:
    | name |
    | Ban  |
    | Car  |
    | Beet |