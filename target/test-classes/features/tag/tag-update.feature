Feature: BDD Scenarios of Tag API - Update Tag

  Background:
    Given table tag contains data:
      | id                                   | name     | color |
      | 1a2b3c4d-0000-1111-2222-abcdefabcdef | Urgent   | red   |

  Scenario: Update tag should return 200
    And the following tag to update:
      | name       | color |
      | Important  | green |
    When call update tag with id=1a2b3c4d-0000-1111-2222-abcdefabcdef
    Then the http status is 200
    And the returned tag has following properties:
      | name       | color |
      | Important  | green |

  Scenario: Update tag with invalid id should return 404
    And the following tag to update:
      | name       | color |
      | Important  | green |
    When call update tag with id=00000000-0000-0000-0000-000000000000
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type      | status | message                |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | NOT_FOUND | 404    | Tag not found with id |

  Scenario Outline: Update tag with invalid name should return 400
    And the following tag to update:
      | name   | color |
      | <name> | green |
    When call update tag with id=1a2b3c4d-0000-1111-2222-abcdefabcdef
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                                     |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | VALIDATION | 400    | name: name must be between 2 and 50 letters |
    Examples:
      | name                                                                 |
      | a                                                                    |
      | This tag name is way too long and should not be accepted at all     |

  Scenario: Update tag with null name should return 400
    And the following tag to update:
      | name | color |
      | null | green |
    When call update tag with id=1a2b3c4d-0000-1111-2222-abcdefabcdef
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                  |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | VALIDATION | 400    | name: name is required   |
