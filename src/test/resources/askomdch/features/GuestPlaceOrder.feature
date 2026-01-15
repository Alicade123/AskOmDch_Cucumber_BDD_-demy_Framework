Feature: Place an Order

  Scenario: Using default Payment option
    Given I'm a guest customer
    And my billing details are
      |firstname|lastname|country           |address_line1   |city |state|zip  |email           |
      |Alicade  |Tester  |US                |600 Spring Creek|Plano|TX|74024|abcKigali@gmail.com|
    And I'm have a product in the cart
    And I'm on the Checkout Page
    When I'm provide billing details
    And I place an Order
    Then the order should be placed successfully