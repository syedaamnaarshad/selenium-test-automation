Feature: Form Submission

  Background:
    Given User is on practice form page

  @001
  Scenario: Form submission with all valid fields
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully

  @002
  Scenario: Form submission without optional fields
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully

  @003
  Scenario Outline: Form submission by selecting different genders
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender <gender>
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully
    Examples:
      | gender |
      | Male   |
      | Female |
      | Other  |

  @004
  Scenario: Form submission with missing subject field
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "", ""
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully

  @005
  Scenario: Form submission without uploading picture
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully

  @006
  Scenario: Form submission without selecting hobbies
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully

  @007
  Scenario: Form submission with missing address field
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address ""
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should be submitted successfully

  @008
  Scenario: Form submission with missing state and city field
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "", ""
    And User clicks the submit button
    Then Form should be submitted successfully

  @009
  Scenario: Form submission with missing first name field
    When User enters first <empty> and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully

  @010
  Scenario: Form submission with missing last name field
    When User enters first Amna and last name <empty>
    And User enters email name@example.com
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully

  @011
  Scenario: Form submission without selecting gender
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully

  @012
  Scenario Outline: Form submission with invalid email formats
    When User enters first Amna and last name Arshad
    And User enters email <userEmail>
    And User selects gender Female
    And User enters 0123456789 mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully
    Examples:
      | userEmail           |
      | userEmail@          |
      | userEmail@g         |
      | userEmail@gmail     |

  @013
  Scenario Outline: Form submission with invalid mobile numbers
    When User enters first Amna and last name Arshad
    And User enters email name@example.com
    And User selects gender Female
    And User enters <number> mobileNum
    And User enters dob
    And User enters subject "Computer Science", "Maths"
    And User selects hobbies
    And User upload picture src/test/resources/picture.webp
    And User enters current address abc street
    And User enters state and city "Rajasthan", "Jaipur"
    And User clicks the submit button
    Then Form should not be submitted successfully
    Examples:
      | number    |
      | 0         |
      | 01        |
      | 012       |
      | 0123      |
      | 01234     |
      | 012345    |
      | 0123456   |
      | 01234567  |
      | 012345678 |






