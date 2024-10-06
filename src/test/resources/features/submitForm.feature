Feature: Form Submission
  Scenario: Submission of form with correct details
    Given I am on practice form page
    When I enter first and last name
    And I enter email
    And I enter gender
    And I enter mobileNum
    And I enter dob
    And I enter subject
    And I enter hobbies
    And I upload picture
    And I enter current address
    And I enter state and city
    Then Form should be submitted successfully