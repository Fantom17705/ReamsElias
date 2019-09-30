# new feature
# Tags: optional

Feature: Test login form

  Scenario: site authorization valid
    Given open start page
    #https://uat.test-aws.reams-elias.co.uk/user/login
    When enter value in the Email field
    #surveyor@edgehill.co.uk
    And enter value in the Password field
    #Realm34$
    And press Login button
    Then Open home page