Feature: Regression Related Scenarios

@RegressionTest-TRBD-1284
Scenario Outline: View search terms on Officers screener
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>"
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify search terms on Officers Screen



Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

@RegressionTest-TRBD-1285
Scenario: View search terms on Companies screener
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify search terms on Companies Screen





@RegressionTest-TRBD-1268
Scenario: Search by Officer Name [Officers screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
And I navigated to officer tab
Then verify search by Officer's name


 

@RegressionTest-TRBD-1283
Scenario: View search terms on News screener
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify search terms on News Screen





@RegressionTest-TRBD-1295
Scenario: Search by Principal Activity [Companies screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify search by Principal Activity


@RegressionTest-TRBD-1292
Scenario: Filter by Brand / Agency [Companies screener]

When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify filter by Brand/Agency
#When user clicks on Logout button,LoginPage should get display



 

@RegressionTest-TRBD-1288
Scenario: Filter by Company Name [Companies screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify filter by Company Name




@RegressionTest-TRBD-1282
Scenario: View search terms on Research screener
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify search terms on Research Screen





@RegressionTest-TRBD-1279
Scenario: Filter by Date [Research screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify filter By Date on Research Screen





@RegressionTest-TRBD-1278
Scenario: Filter by Company [Research screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify filter By Company on Research Screen





@RegressionTest-TRBD-1261
Scenario: Filter by Ownership Type [Companies screener]
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then verify filter By Ownership Type on Company Screen
When user clicks on Logout button,LoginPage should get display
And close the browser




