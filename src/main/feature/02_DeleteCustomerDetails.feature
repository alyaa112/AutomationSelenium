#Author: Norfatin 'Alyaa binti Khairuddin
#        fatinalyaa.khairuddin@gmail.com

Feature: Delete customer details feature

  Background: User is on customer screen
    Given user login as bank manager
    And user goes to Customer tab

    When user deletes customer details
    Then deleted customer details should not be visible on screen