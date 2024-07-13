Feature: User

  Scenario Outline: fetch all
    Given getAll
    And getById

    Examples:
      | id | email | full_name | password |
      | 1 | nirajanmahato44@gmail.com | Nirajan Mahato | $2a$10$T9MIjapJpdwriQYM/caVB.GJPfMqsevLuAy24eEJLXwRQ2loj76O. |

  Scenario Outline: for post
    Given post data
    And verify
    Then finally

    Examples:
      | id | email | full_name | password |
      | 1 | nirajanmahato44@gmail.com | Nirajan Mahato | $2a$10$T9MIjapJpdwriQYM/caVB.GJPfMqsevLuAy24eEJLXwRQ2loj76O. |
