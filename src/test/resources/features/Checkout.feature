Feature: Checkout feature
  @CheckOut
  Scenario Outline: Search, add product and checkout
    Given User is on GreenKart landing page
    When User searched with <name> and extract it
    When added "3" items of the selected product to the cart
    Then User proceed to checkout and validate the <name> items in checkout page
    Then verify user has ability to enter promo code and place the order

    Examples:
      | name |
      | Brocolli |