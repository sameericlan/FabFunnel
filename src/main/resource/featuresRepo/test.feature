Feature: to test the login functionality

Scenario: test login feature of application

Given login page is open
When user enters username and password
And user clicks on login button
Then user enters HomePage

Scenario: test negative scenario for login feature

Given browser is open and user is on login page
When user enters wrong username and password
And user clicks on the login button
Then user shouldnt be logged in and an error messaage should be displayed
