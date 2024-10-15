Feature: To check the end to end flow of the application

@smoketest
Scenario: testing the end to end flow 

Given browser is open
When user credentials are logged in and new Agency is invited
And user verifies from mail box and registration is done
And user accepts the invitation 
Then status is verified through owner