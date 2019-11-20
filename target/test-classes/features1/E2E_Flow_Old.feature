Feature: End To End Scenario

@RegressionTest
Scenario Outline: End To End Scenario
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>"
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then Verify serach result page contents
When i clicked on Company Name in the Companies tab
Then Verify Company related information
And click on Return Back,search result page should display
When i click on My Settings tab
Then My Settings related info.section should get display
When user clicks on Logout button,LoginPage should get display
And close the browser


Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 


@SmokeTest
Scenario Outline: End To End Scenario
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>"
Then Homepage should get display
When user clicks on Logout button,LoginPage should get display
And close the browser

Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 



