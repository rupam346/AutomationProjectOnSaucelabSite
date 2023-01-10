Feature: Sauce Labs Demo All functionality



@demo
Scenario Outline: Login with valid credentials
Given User is on SwagLab Page
Given User enter username and password and user click on Login button
Then User must be in products page "Swag Labs" as title




#Examples:
#|   username   |   password   |
#|standard_user | secret_sauce |




@product1
Scenario: Verify product is added to cart 
Given User is on productPage
When User click on AddTo Cart button 
Then Products are added to cart






@Hover
Scenario: User is able to hover to tab
Given User is on product page
When User clicks on left menuBar
And User clicks ABOUT option
Then User in on ABOUT Page with title "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs"
And User hover on Solutions and Platform tab



@Navigation
Scenario: User is able to navigate and close tab
Given User is on SauceLabs Page
When User hover to Resource tab
And User click on Documention option
Then User is in Documentation Page in a New tab
And User closes that tab
Then User is in about page
And User hovers on Resource 
And User right-click on Documentation option and clicks on open in new window
Then User is in Documentation page "Sauce Labs Documentation, Developer Community & Resources | Sauce Labs Documentation" as title
And New window is closed
And Browser is closed