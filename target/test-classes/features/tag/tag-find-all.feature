Feature: BDD Scenarios of Tag API - Find All

  Background:
    Given table tag contains data:
      | id                                   | name    | color |
      | 11111111-1111-1111-1111-111111111111 | Urgent  | red   |
      | 22222222-2222-2222-2222-222222222222 | Travail | blue  |
      | 33333333-3333-3333-3333-333333333333 | Loisir  | green |

  Scenario: Find all tags with pagination and sorting
    When call find all with page=0, size=2 and sort=sort=name,asc
    Then the http status is 200
    And the returned page has following content:
      | name    | color |
      | Loisir  | green |
      | Travail | blue  |

  Scenario: Find all tags with no match should return empty list
    When call find all with page=5, size=10 and sort=sort=name,asc
    Then the http status is 200
    And the returned page has no content
