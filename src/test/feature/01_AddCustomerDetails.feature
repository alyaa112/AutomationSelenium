#Author: Norfatin 'Alyaa binti Khairuddin
#        fatinalyaa.khairuddin@gmail.com

Feature: Add customer details feature

  Background: XYZ Bank web app is launched
    Given user login as bank manager
    And manager screen is visible

    @SEBTest
      Scenario: Add new customer details and verify
      When user adds new customer details and verify it
      And user deletes some customers
      Then deleted customer details should not be visible on screen
