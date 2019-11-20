$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Regression_Flows.feature");
formatter.feature({
  "line": 1,
  "name": "Regression Related Scenarios",
  "description": "",
  "id": "regression-related-scenarios",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "View search terms on Officers screener",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-officers-screener",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RegressionTest-TRBD-1284"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "That Application is launched with the url \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User login to application with \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify search terms on Officers Screen",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-officers-screener;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "URL"
      ],
      "line": 14,
      "id": "regression-related-scenarios;view-search-terms-on-officers-screener;;1"
    },
    {
      "cells": [
        "trbd.mena2@thomsonreuters.com",
        "TestUser2",
        "https://businessdevelopment.mena.thomsonreuters.com/login"
      ],
      "line": 15,
      "id": "regression-related-scenarios;view-search-terms-on-officers-screener;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 220700,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "View search terms on Officers screener",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-officers-screener;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RegressionTest-TRBD-1284"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "That Application is launched with the url \"https://businessdevelopment.mena.thomsonreuters.com/login\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User login to application with \"trbd.mena2@thomsonreuters.com\" and \"TestUser2\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify search terms on Officers Screen",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://businessdevelopment.mena.thomsonreuters.com/login",
      "offset": 43
    }
  ],
  "location": "LoginStep.launchApplication(String)"
});
formatter.result({
  "duration": 16726313400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "trbd.mena2@thomsonreuters.com",
      "offset": 32
    },
    {
      "val": "TestUser2",
      "offset": 68
    }
  ],
  "location": "LoginStep.verifyUserLogin(String,String)"
});
formatter.result({
  "duration": 13413185100,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6243418400,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "duration": 3722972600,
  "status": "passed"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchTermsOnOfficersScreen()"
});
formatter.result({
  "duration": 4180757900,
  "error_message": "java.lang.AssertionError: Build List Search Result Page is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.BuildListSearchResultStep.verifySearchTermsOnOfficersScreen(BuildListSearchResultStep.java:283)\r\n\tat ✽.Then verify search terms on Officers Screen(Regression_Flows.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 14435700,
  "status": "passed"
});
formatter.before({
  "duration": 65900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "View search terms on Companies screener",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-companies-screener",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@RegressionTest-TRBD-1285"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "verify search terms on Companies Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 13040200,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6012022200,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:20)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchTermsOnCompaniesScreen()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4825500,
  "status": "passed"
});
formatter.before({
  "duration": 49000,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Search by Officer Name [Officers screener]",
  "description": "",
  "id": "regression-related-scenarios;search-by-officer-name-[officers-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@RegressionTest-TRBD-1268"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "I navigated to officer tab",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "verify search by Officer\u0027s name",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 8342900,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6011261200,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:31)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.i_navigated_to_officer_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchByOfficerName()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4861100,
  "status": "passed"
});
formatter.before({
  "duration": 67400,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "View search terms on News screener",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-news-screener",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 39,
      "name": "@RegressionTest-TRBD-1283"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "verify search terms on News Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 7739400,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6010676000,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:42)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchTermsOnNewsScreen()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4493100,
  "status": "passed"
});
formatter.before({
  "duration": 75500,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Search by Principal Activity [Companies screener]",
  "description": "",
  "id": "regression-related-scenarios;search-by-principal-activity-[companies-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 50,
      "name": "@RegressionTest-TRBD-1295"
    }
  ]
});
formatter.step({
  "line": 52,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 53,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "verify search by Principal Activity",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 6735700,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6011264500,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:53)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchByPrincipalActivity()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3591400,
  "status": "passed"
});
formatter.before({
  "duration": 48100,
  "status": "passed"
});
formatter.scenario({
  "line": 59,
  "name": "Filter by Brand / Agency [Companies screener]",
  "description": "",
  "id": "regression-related-scenarios;filter-by-brand-/-agency-[companies-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 58,
      "name": "@RegressionTest-TRBD-1292"
    }
  ]
});
formatter.step({
  "line": 61,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "verify filter by Brand/Agency",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 7115900,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6013384600,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:62)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifyFilterByBrandOrAgency()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5368900,
  "status": "passed"
});
formatter.before({
  "duration": 42300,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 65,
      "value": "#When user clicks on Logout button,LoginPage should get display"
    }
  ],
  "line": 72,
  "name": "Filter by Company Name [Companies screener]",
  "description": "",
  "id": "regression-related-scenarios;filter-by-company-name-[companies-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 71,
      "name": "@RegressionTest-TRBD-1288"
    }
  ]
});
formatter.step({
  "line": 73,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 75,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 76,
  "name": "verify filter by Company Name",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 8266800,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6012638300,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:74)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifyFilterByCompanyName()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5195100,
  "status": "passed"
});
formatter.before({
  "duration": 45000,
  "status": "passed"
});
formatter.scenario({
  "line": 82,
  "name": "View search terms on Research screener",
  "description": "",
  "id": "regression-related-scenarios;view-search-terms-on-research-screener",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 81,
      "name": "@RegressionTest-TRBD-1282"
    }
  ]
});
formatter.step({
  "line": 83,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 84,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 85,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 86,
  "name": "verify search terms on Research Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 8232200,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6024653200,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:84)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifySearchTermsOnResearchScreen()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 7990600,
  "status": "passed"
});
formatter.before({
  "duration": 40800,
  "status": "passed"
});
formatter.scenario({
  "line": 93,
  "name": "Filter by Date [Research screener]",
  "description": "",
  "id": "regression-related-scenarios;filter-by-date-[research-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 92,
      "name": "@RegressionTest-TRBD-1279"
    }
  ]
});
formatter.step({
  "line": 94,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 95,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 96,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 97,
  "name": "verify filter By Date on Research Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 13971300,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6016211300,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:95)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifyFilterByDate()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5634500,
  "status": "passed"
});
formatter.before({
  "duration": 61000,
  "status": "passed"
});
formatter.scenario({
  "line": 104,
  "name": "Filter by Company [Research screener]",
  "description": "",
  "id": "regression-related-scenarios;filter-by-company-[research-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 103,
      "name": "@RegressionTest-TRBD-1278"
    }
  ]
});
formatter.step({
  "line": 105,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 107,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 108,
  "name": "verify filter By Company on Research Screen",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 12086100,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6011388600,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:106)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifyFilterByCompany()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4341500,
  "status": "passed"
});
formatter.before({
  "duration": 47300,
  "status": "passed"
});
formatter.scenario({
  "line": 115,
  "name": "Filter by Ownership Type [Companies screener]",
  "description": "",
  "id": "regression-related-scenarios;filter-by-ownership-type-[companies-screener]",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 114,
      "name": "@RegressionTest-TRBD-1261"
    }
  ]
});
formatter.step({
  "line": 116,
  "name": "User clicks on Title",
  "keyword": "When "
});
formatter.step({
  "line": 117,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 118,
  "name": "i select Region,Sectors and click on Build List",
  "keyword": "When "
});
formatter.step({
  "line": 119,
  "name": "verify filter By Ownership Type on Company Screen",
  "keyword": "Then "
});
formatter.step({
  "line": 120,
  "name": "user clicks on Logout button,LoginPage should get display",
  "keyword": "When "
});
formatter.step({
  "line": 121,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomeStep.titleIsPresent()"
});
formatter.result({
  "duration": 6517400,
  "status": "passed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "duration": 6010399800,
  "error_message": "java.lang.AssertionError: Home Screen is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.HomeStep.verifyHomePageIsDisplayed(HomeStep.java:73)\r\n\tat ✽.Then Homepage should get display(Regression_Flows.feature:117)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.enterRegionSectorDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BuildListSearchResultStep.verifyFilterByOwnerShipType()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomeStep.clickOnLogoutButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStep.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4688700,
  "status": "passed"
});
formatter.uri("Sanity_Flows_New.feature");
formatter.feature({
  "line": 1,
  "name": "Daily Sanity Related Scenarios",
  "description": "",
  "id": "daily-sanity-related-scenarios",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Login Page -TRBD - Valid Credentials",
  "description": "",
  "id": "daily-sanity-related-scenarios;login-page--trbd---valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SanityTest-TRBD-1256"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "That Application is launched with the url \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User login to application with \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on Logout button,LoginPage should get display",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "And "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "daily-sanity-related-scenarios;login-page--trbd---valid-credentials;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "URL"
      ],
      "line": 14,
      "id": "daily-sanity-related-scenarios;login-page--trbd---valid-credentials;;1"
    },
    {
      "cells": [
        "trbd.mena2@thomsonreuters.com",
        "TestUser2",
        "https://businessdevelopment.mena.thomsonreuters.com/login"
      ],
      "line": 15,
      "id": "daily-sanity-related-scenarios;login-page--trbd---valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 48800,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Login Page -TRBD - Valid Credentials",
  "description": "",
  "id": "daily-sanity-related-scenarios;login-page--trbd---valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SanityTest-TRBD-1256"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "That Application is launched with the url \"https://businessdevelopment.mena.thomsonreuters.com/login\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User login to application with \"trbd.mena2@thomsonreuters.com\" and \"TestUser2\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Homepage should get display",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on Logout button,LoginPage should get display",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://businessdevelopment.mena.thomsonreuters.com/login",
      "offset": 43
    }
  ],
  "location": "LoginStep.launchApplication(String)"
});
formatter.result({
  "duration": 5501083000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "trbd.mena2@thomsonreuters.com",
      "offset": 32
    },
    {
      "val": "TestUser2",
      "offset": 68
    }
  ],
  "location": "LoginStep.verifyUserLogin(String,String)"
});
formatter.result({
  "duration": 2007801000,
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d78.0.3904.97)\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027T4BVDIW10DV0085\u0027, ip: \u002710.25.59.187\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}), userDataDir\u003dC:\\Users\\UX012817\\AppData\\Local\\Temp\\scoped_dir11780_1364608304}, timeouts\u003d{implicit\u003d0.0, pageLoad\u003d300000.0, script\u003d30000.0}, pageLoadStrategy\u003dnormal, unhandledPromptBehavior\u003ddismiss and notify, strictFileInteractability\u003dfalse, platform\u003dANY, proxy\u003dProxy(), goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:59685}, acceptInsecureCerts\u003dfalse, browserVersion\u003d78.0.3904.97, browserName\u003dchrome, javascriptEnabled\u003dtrue, platformName\u003dwindows nt, setWindowRect\u003dtrue}]\nSession ID: a960b509ba81dcbc121aeb6bec0228ea\n*** Element info: {Using\u003dxpath, value\u003d//input[contains(@name,\u0027username\u0027)]}\r\n\tat jdk.internal.reflect.GeneratedConstructorAccessor11.newInstance(Unknown Source)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:150)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:115)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:637)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:410)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:509)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:402)\r\n\tat pageObjects.LoginPage.getUsername(LoginPage.java:117)\r\n\tat stepdefinition.LoginStep.verifyUserLogin(LoginStep.java:69)\r\n\tat ✽.When User login to application with \"trbd.mena2@thomsonreuters.com\" and \"TestUser2\"(Sanity_Flows_New.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomeStep.verifyHomePageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomeStep.clickOnLogoutButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStep.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5160000,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 17,
      "value": "#"
    }
  ],
  "line": 21,
  "name": "Links to Marketing Page on the Login Page",
  "description": "",
  "id": "daily-sanity-related-scenarios;links-to-marketing-page-on-the-login-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@SanityTest-TRBD-1260"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "That Application is launched with the url \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "User login Page is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "Verify LoginPage Header Section and validate the links",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "close the browser",
  "keyword": "And "
});
formatter.examples({
  "line": 28,
  "name": "",
  "description": "",
  "id": "daily-sanity-related-scenarios;links-to-marketing-page-on-the-login-page;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "URL"
      ],
      "line": 29,
      "id": "daily-sanity-related-scenarios;links-to-marketing-page-on-the-login-page;;1"
    },
    {
      "cells": [
        "trbd.mena2@thomsonreuters.com",
        "TestUser2",
        "https://businessdevelopment.mena.thomsonreuters.com/login"
      ],
      "line": 30,
      "id": "daily-sanity-related-scenarios;links-to-marketing-page-on-the-login-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 50000,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Links to Marketing Page on the Login Page",
  "description": "",
  "id": "daily-sanity-related-scenarios;links-to-marketing-page-on-the-login-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@SanityTest-TRBD-1260"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "That Application is launched with the url \"https://businessdevelopment.mena.thomsonreuters.com/login\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "User login Page is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "Verify LoginPage Header Section and validate the links",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://businessdevelopment.mena.thomsonreuters.com/login",
      "offset": 43
    }
  ],
  "location": "LoginStep.launchApplication(String)"
});
formatter.result({
  "duration": 4566834600,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.verifyLoginPageIsDisplayed()"
});
formatter.result({
  "duration": 21004000,
  "error_message": "java.lang.AssertionError: LoginPage is not displayed\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepdefinition.LoginStep.checkLoginPageIsDisplayed(LoginStep.java:318)\r\n\tat stepdefinition.LoginStep.verifyLoginPageIsDisplayed(LoginStep.java:126)\r\n\tat ✽.When User login Page is displayed(Sanity_Flows_New.feature:23)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginStep.verifyLoginPageHeaderSection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStep.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4252500,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 32,
      "value": "#"
    }
  ],
  "line": 35,
  "name": "Verifying forgot password link on login page",
  "description": "",
  "id": "daily-sanity-related-scenarios;verifying-forgot-password-link-on-login-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 34,
      "name": "@SanityTest-TRBD-1328"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "That Application is launched with the url \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "User login Page is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Verify forgot password link on login page",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "close the browser",
  "keyword": "And "
});
formatter.examples({
  "line": 41,
  "name": "",
  "description": "",
  "id": "daily-sanity-related-scenarios;verifying-forgot-password-link-on-login-page;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "URL"
      ],
      "line": 42,
      "id": "daily-sanity-related-scenarios;verifying-forgot-password-link-on-login-page;;1"
    },
    {
      "cells": [
        "trbd.mena2@thomsonreuters.com",
        "TestUser2",
        "https://businessdevelopment.mena.thomsonreuters.com/login"
      ],
      "line": 43,
      "id": "daily-sanity-related-scenarios;verifying-forgot-password-link-on-login-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 129400,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Verifying forgot password link on login page",
  "description": "",
  "id": "daily-sanity-related-scenarios;verifying-forgot-password-link-on-login-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 34,
      "name": "@SanityTest-TRBD-1328"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "That Application is launched with the url \"https://businessdevelopment.mena.thomsonreuters.com/login\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "User login Page is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Verify forgot password link on login page",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://businessdevelopment.mena.thomsonreuters.com/login",
      "offset": 43
    }
  ],
  "location": "LoginStep.launchApplication(String)"
});
formatter.result({
  "duration": 12393756500,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.verifyLoginPageIsDisplayed()"
});
