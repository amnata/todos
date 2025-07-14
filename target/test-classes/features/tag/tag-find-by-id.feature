Feature: BDD Scenarios of Tag API - Find By ID

  Background:
    Given table tag contains data:
      | id                                   | name   | color |
      | 11111111-1111-1111-1111-111111111111 | Urgent | red   |

  Scenario: Find by id should return 200
    When call find by id with id=11111111-1111-1111-1111-111111111111
    Then the http status is 200
    And the returned tag has following properties:
      | name   | color |
      | Urgent | red   |

  Scenario: Find by id with bad id should return 404
    When call find by id with id=00000000-0000-0000-0000-000000000000
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type      | status | message                |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | NOT_FOUND | 404    | Tag not found with id |
