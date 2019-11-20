Feature: Daily Sanity Related Scenarios

@SanityTest-TRBD-1256
Scenario Outline: Login Page -TRBD - Valid Credentials
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>"
Then Homepage should get display
When user clicks on Logout button,LoginPage should get display
And close the browser



Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#


@SanityTest-TRBD-1260
Scenario Outline: Links to Marketing Page on the Login Page
Given That Application is launched with the url "<URL>"
When User login Page is displayed
Then Verify LoginPage Header Section and validate the links
And close the browser


Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#

@SanityTest-TRBD-1328
Scenario Outline: Verifying forgot password link on login page
Given That Application is launched with the url "<URL>"
When User login Page is displayed
Then Verify forgot password link on login page
And close the browser

Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  |

#


@SanityTest-TRBD-1259
Scenario Outline: LegalStatiContentOnLoginpage
Given That Application is launched with the url "<URL>"
When User login Page is displayed
Then Verify LoginPage Footer Section and validate the links
And close the browser


Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#

@SanityTest-TRBD-1257
Scenario Outline: Login Page -TRBD -remember me
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>" and verify Credentials
#When User clicks on Title
Then Homepage should get display
When user clicks on Logout button,LoginPage should get display
Then Check System stored the specified Username details
And close the browser

Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 
 
#



@SanityTest-TRBD-1309
Scenario Outline: TRBDAccountLogout
Given That Application is launched with the url "<URL>"
When User login to application with "<Username>" and "<Password>"
#When User clicks on Title
Then Homepage should get display


Examples:
|Username                                   | Password             |URL                                                        |
|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 
#

@SanityTest-TRBD-1326
Scenario: TRBD Build List Result without any filter combination
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i Click on Build List Button without selecting any filters 
Then Verify serach result page contents
When i clicked on Company Name in the Companies tab
Then Verify Company related information
And click on Return Back,search result page should display

#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#


@SanityTest-TRBD-1310
Scenario: TRBDBuildListFilterBar
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i select Region,Sectors and click on Build List
Then Verify serach result page contents
When i clicked on Company Name in the Companies tab
Then Verify Company related information
And click on Return Back,search result page should display



#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 
#



@SanityTest-TRBD-1308
Scenario: TR My Settings
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i click on My Settings tab
Then My Settings related info.section should get display



#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  |
#



@SanityTest-TRBD-1307
Scenario: TR My Accounts
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i click on My Accounts tab
Then Page should navigate to My Account Page



#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  |
#
#
@SanityTest-TRBD-1311
Scenario: TRBD Build List Result without any filter combination


When User clicks on Title
Then Homepage should get display
When i Click on Build List Button without selecting any filters 
Then Verify serach result page contents on left side of the page
And Center of the page
When i clicked on Company Name in the Companies tab
And click on Return Back,search result page should display
And Right side of the page




#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#
@SanityTest-TRBD-1306
Scenario: TRBD Home Dashboard
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display



#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  |


@SanityTest-TRBD-1325
Scenario: TRBD Build List Result without any filter combination
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i Click on Build List Button without selecting any filters 
Then Verify serach result page contents
When i clicked on Company Name in the Companies tab
Then Verify Company related information
And click on Return Back,search result page should display


#Examples:
#|Username                                   | Password             |URL                                                        |
#|trbd.mena2@thomsonreuters.com              | TestUser2            |https://businessdevelopment.mena.thomsonreuters.com/login  | 

#

@SanityTest-TRBD-1324

Scenario: TRBD Build List Result without any filter combination
#Given That Application is launched with the url "<URL>"
#When User login to application with "<Username>" and "<Password>"
When User clicks on Title
Then Homepage should get display
When i Click on Build List Button without selecting any filters 
Then Verify serach result page contents
When i clicked on Company Name in the Companies tab
Then Verify Company related information
And click on Return Back,search result page should display
When user clicks on Logout button,LoginPage should get display
And close the browser




