Feature: Application Login

Scenario Outline: HomePage Default Login
#Combines TRBD-1308,TRBD-1309
Given That Application is launched with the url "https://businessdevelopment.mena.thomsonreuters.com/login"
When user login to application with "<Username>" and "<Password>"
Then Homepage should get display
When i click on My Settings tab
Then My Settings related info.section should get display
When user clicks on Logout button,LoginPage should get display


Examples:
|Username                                   | Password             |
|trbd.mena2@thomsonreuters.com              | TestUser2            | 



