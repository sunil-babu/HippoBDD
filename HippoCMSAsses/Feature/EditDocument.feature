Feature: Edit and Publish News document
  Description: Verify user is able to edit a  document and publish it to website

  Background: 
    Given user already logged in to Hippo

  Scenario: Succesfully Editing a News documnet and publishing it to website
    Given user in dashboard page
    When the user navigates to news document page
    And then selects the the document to be edited and enter valid data
    And saves and publishes the document
    Then the data should be published to website
