Feature: Using the card Service repository

  Scenario: Finding decks by author
      Given 1 stored deck in the repository with author Henrik Hahne
      When search repository on author Henrik Hahne
      Then The deck with Henrik Hahne as author shall be found