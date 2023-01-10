Feature: Product page feature

  Background: Prerequisite Logging in
    Given User is on SwagLabs Page
    And User enters username and password and user clicks on Login button
    Then User must be in products page

  @product1
  Scenario: Verify product is added to cart
    When User is on productPage
    And User sorts products
    Then Verify the sort order
    When User adds the products into cart by clicking on add to cart button
    Then Products must be added to cart

  @product2
  Scenario Outline: Verify checkout page functionality
    When User is on productPage
    When User adds the products into cart by clicking on add to cart button
    Then Products must be added to cart
    When User clicks on checkout button
    Then User is able to enter "<firstName>","<lastName>" and "<zipCode>" and clicks on continue
    When User clicks on finish button
    Then User must have placed order successfully

    Examples: 
      | firstName | lastName  | zipCode     |
      | Rupam     | Kumari    |      583765 |
      | Ru$pam    | Kumari    |      583765 |
      | Rupam     | Kuma^%@ri |      583765 |
      | Rupam     | Kumari    |    58343765 |
      | Rupam$$%  | Kumari&^  | 87438583765 |
      |    121323 |      4676 | srtt        |
