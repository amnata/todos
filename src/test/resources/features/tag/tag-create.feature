Feature: BDD Scenarios of Tag API - Add Tag

  Scenario: Add tag should return 201
    And the following tag to add:
      | name      | color |
      | Urgent    | red   |
    When call add tag
    Then the http status is 201
    And the returned tag has following properties:
      | name    | color |
      | Urgent  | red   |

  Scenario Outline: Add tag with name not matching size constraints should return 400
    And the following tag to add:
      | name      | color |
      | <name>    | blue  |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                                         |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | VALIDATION | 400    | name: name must be between 2 and 50 characters |
    Examples:
      | name                                                                            |
      | A                                                                               |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor |

  Scenario: Add tag with null name should return 400
    And the following tag to add:
      | name  | color |
      | null  | green |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message             |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | VALIDATION | 400    | name: name is required |

  Scenario: Add tag with null color should return 400
    And the following tag to add:
      | name   | color |
      | Alert  | null  |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message              |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | VALIDATION | 400    | color: color is required |
