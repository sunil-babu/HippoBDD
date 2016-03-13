Feature: Create and Publish News document
  Description: Verify user is able to create a new document and publish it to website

  Background: 
    Given user already logged in to Hippo
    

  Scenario: Succesfully Creating a News Document Page and publishing it to website
    Given user in dashboard page
    When the user clicks create a news document link
    And then enters all the valid data and saves the document
    And publishes the document
    Then the data should be published to website
