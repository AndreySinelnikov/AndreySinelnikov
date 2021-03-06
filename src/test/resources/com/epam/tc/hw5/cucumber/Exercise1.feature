Feature: Exercise 1

  Scenario: Different Elements page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    When I select "Water" checkbox
    And I select "Wind" checkbox
    And I select "Selen" radio button
    And I select "Yellow" in dropdown menu
    Then 1 log row has "Water: condition changed to true" text in log section on Elements Page
    And 1 log row has "Wind: condition changed to true" text in log section on Elements Page
    And 1 log row has "metal: value changed to Selen" text in log section on Elements Page
    And 1 log row has "Colors: value changed to Yellow" text in log section on Elements Page
