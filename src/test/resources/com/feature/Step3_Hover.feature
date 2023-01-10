Feature: Hover action feature

Background: Prerequisite for hover page
Given User is on SwagLabs Page
And User enters username and password and user clicks on Login button
And User is on product page

@Hover
Scenario: User is able to hover to tab
When User clicks on left menuBar
And User clicks ABOUT option
Then User must be in ABOUT Page
And User hover contact tab
And User select contactSales page and select crossBrowsertesting
