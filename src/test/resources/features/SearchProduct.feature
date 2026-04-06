Feature: Search and place the order of Products

  @SearchProduct
  Scenario Outline: Search experience for product search in Home and Offers page using Scenario Outline
    Given User is on GreenKart landing page
    When User searched with <name> and extract it
    Then User search for the extracted product name in Offers Page
    Then Validate product name in Offers Page matches with Landing Page
    
    Examples:
      | name |
      | Ban  |
      | Car  |
      | Tom  |