Feature: Login section

  Scenario Outline: Successfully Login to Website
    Given I am on the Login Page
    When I provide "<username>" and "<password>" and click login
    Then I can see MySummary title
    Examples:
      | username | password |
      | su       | gw       |


