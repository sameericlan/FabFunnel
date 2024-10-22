@smoke
Feature: To check the end to end flow of the application

@inviteagency
Scenario: user logs in

Given homepage is open
Then user credentials are logged in 

@inviteagency
Scenario: Agency Invite

Given user clicks on crew control and agency button
Then user invites new agency

@registration @inviteagency
Scenario: Invited Agency  Sign-up. 
Given Login to YOPmail
When Token catch from to-mail 
Then Signup agency
