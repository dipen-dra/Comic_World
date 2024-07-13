Feature: User

  Scenario Outline: fetch all
    Given getAll
    And getById

    Examples:
      | id | email                      | full_name       | password                                             |
      | 1  | dipendrajr999@gmail.com    | Dipendra Ghimire| $2a$10$LlyXqp/CkaoMHq8hQ2CJoOaAAEq.QBdzOGSVgZCLUQJAAJkN28OOO |

  Scenario Outline: for post
    Given post data
    And verify
    Then finally

    Examples:
      | id | email                      | full_name       | password                                             |
      | 1  | dipendrajr999@gmail.com    | Dipendra Ghimire| $2a$10$LlyXqp/CkaoMHq8hQ2CJoOaAAEq.QBdzOGSVgZCLUQJAAJkN28OOO |
