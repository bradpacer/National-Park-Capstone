Feature: park geek

	Scenario: View a park page
	Given I am on the home page
	When I click on the Cuyahoga Valley National Park link
	Then I am sent to the Cuyahoga Valley National Park page
	
	
	Scenario: Change units
	Given I am on the Cuyahoga Valley National Park page
	When I select celsius from the choose a unit
	And I click update
	Then I am sent to the Cuyahoga Valley National Park page
	And The temperature is in celsius
	
	Scenario: View survey page
	Given I am on the home page
	When I click on the Survey link
	Then I am sent to the survey page
	
	Scenario: Submit the survey
	Given I am on the Survey page
	When I choose park Glacier National Park
	And I enter the email brad@gmail.com
	And I choose the state OH
	And I choose the activity level Active
	And I click submit
	Then I am sent to the survey results page
	
	Scenario: View home page
	Given I am on the Survey page
	When I click on the Home link
	Then I am sent to the home page
















