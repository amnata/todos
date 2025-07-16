Feature: BDD Scenarios of Tag API - Delete Tag

  Background:
    Given table tag contains data:
      | id                                   | name     | color |
      | 1a2b3c4d-0000-1111-2222-abcdefabcdef | Urgent   | red   |
      | 2b3c4d5e-3333-4444-5555-fedcbafedcba | Planning | blue  |

  Scenario: Delete tag should return 204
    When call delete with id=1a2b3c4d-0000-1111-2222-abcdefabcdef
    Then the http status is 204

  Scenario: Delete tag with invalid id should return 404
    When call delete with id=00000000-0000-0000-0000-000000000000
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TAGS     | NOT_FOUND  | 404    | Tag not found with id |
