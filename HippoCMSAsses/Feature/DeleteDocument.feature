Feature: Delete already published document
  Description: Verify user is able to delete a document already published  to website

  Background: 
    Given user already logged in to Hippo

  Scenario: Succesfully delete a News document already published to website
    Given user in dashboard page
    When the user navigates to news document page
    And then takes the website offline and deletes the record
    Then the data should be unpublished from the website and removed from the list
