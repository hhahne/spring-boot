#The annotation makes sure that everything is rolled back between runs, resulting in a clean database.
@txn
Feature: Using the card Service repository

  Scenario: Finding decks by author
     Given 1 stored deck in the repository with author Henrik Hahne
     When search repository on author Henrik Hahne
     Then The deck with Henrik Hahne as author shall be found

  Scenario: Finding only decks with correct author
     Given 2 stored decks in the repository
     And 1 stored deck in the repository with author Henrik Hahne
     When search repository on author Henrik Hahne
     Then 3 decks available in the repository
     And 1 deck returned from repository with author Henrik Hahne
     And The deck with Henrik Hahne as author shall be found

  Scenario: No decks stored in the repository should not find any results on author
    Given 0 stored decks in the repository
    When search repository on author Henrik Hahne
    Then 0 decks available in the repository

  Scenario: No decks stored in the repository should not find any results
    Given 0 stored decks in the repository
    When  search repository for all decks
    Then  0 decks available in the repository