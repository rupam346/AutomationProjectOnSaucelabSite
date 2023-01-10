Feature: Opening Documentation in new Tab feature

@Navigation
Scenario: User is able to navigate to tab, window and close the tab
Given User is on SwagLabs Page
And User enters username and password and user clicks on Login button
And User is on product page
When User clicks on left menuBar
And User clicks ABOUT option
Then User must be in ABOUT Page
When User is in About page
When User hovers to Resource tab
And User clicks on Documention option
Then User must be in Documentation Page in a New tab
And User closes that tab
Then User must be in about page after closing new tab
And User hovers on Resource 
And User right-click on Documentation option and clicks on open in new window
Then User must be in Documentation page in new window 
And New window is closed

