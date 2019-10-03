# new feature
# Tags: optional

Feature: Test login form

  Scenario: site authorization valid
    Given open start page
    When enter value in the Email field
    And enter value in the Password field
    And press Login button
    Then go to home page
    When Facilities block check
    And Check displayed colums


