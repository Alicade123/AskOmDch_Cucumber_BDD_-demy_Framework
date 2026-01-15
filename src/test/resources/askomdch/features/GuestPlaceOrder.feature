Feature: Place an Order

  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      |firstname|lastname|country           |address_line1   |city |state|zip  |email           |
      |Alicade  |Tester  |US                |600 Spring Creek|Plano|TX|74024|abcKigali@gmail.com|
    And I'm on the Checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully