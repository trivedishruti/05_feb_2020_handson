Feature: LogIn Action

Scenario Outline: Successful Login with Valid Credentials
Given User is on Home Page
When User navigates to login page
And User enters "<username>" and "<password>" as valid admin Credentials
Then Message displayed login Successfully


Examples: 
| username | password    |
| admin    | password456 |

Scenario Outline: User adds Category and SubCategory
Given User selects Add Category
When User adds Sports "<category>" as Category
And User adds "<subcategory1>" and "<subcategory2>"
Then Add Category successful

Examples:
| category | subcategory1 | subcategory2 |
| Sports   | Basketball   | Volleyball   |
