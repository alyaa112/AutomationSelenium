#Author: Norfatin 'Alyaa binti Khairuddin
#        fatinalyaa.khairuddin@gmail.com

Feature: Add customer details feature

  Background: XYZ Bank web app is launched
    Given user login as bank manager
    And manager screen is visible

    @SEBTest
    When user adds new customer details
    Then customer details should be saved