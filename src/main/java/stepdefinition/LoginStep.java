package stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import org.apache.log4j.Logger;

public class LoginStep extends Base {

	private static Logger log = LoggerHelper.getLogger(LoginStep.class);
	LoginPage loginPage;
	

	public LoginStep() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
	}
	

	@Given("^That Application is launched with the url \"([^\"]*)\"$")
	public void launchApplication(String url) throws Throwable {
		System.out.println("Coming Here");
		driver.get(url);
		log.info("Application is launched");
	}

	@When("^User relaunches the application with the url \"([^\"]*)\"$")
	public void relaunchApplication(String url) throws Throwable {
		driver = initializeDriver();
		launchApplication(url);
	}

	@Then("^Check System stored the specified Username details$")
	public void checkSystemStoredDetails() {
		try {
			if (loginPage.storedUserName().isDisplayed()) {
				System.out.println("kalyan" + loginPage.storedUserName().getText());
				log.info("System stored the specified username details as expected");
			} /*
				 * else { Assert.
				 * assertTrue("System stored username details are not displayed as expected",
				 * loginPage.storedUserName().isDisplayed()); }
				 */
		}

		catch (Exception e) {
			log.info("System not stored the Username details");
			Assert.assertTrue("System not stored Username details", false);
		}

	}

	@When("^User login to application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verifyUserLogin(String username, String password) throws Throwable {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(loginPage.getUsername()));
		if (loginPage.isScreenDisplayed()) {
			loginPage.getUsername().sendKeys(username);
			loginPage.getPassword().sendKeys(password);
			if (loginPage.rememberMeChkbox().isSelected()) {
				log.info("Remeber Check box is already selected");
			} else {
				loginPage.rememberMeChkbox().click();
				log.info("Remeber Me Checkbox is checked");
			}

			loginPage.clickSignIn().click();
			log.info("User entered Username :" + username + " and Password :" + password
					+ " ,and clicked on SignIn Button");
			verifyEnteredCredentials();
			verifyIsAnotherLoginSessionScreenIsDisplayed();
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("LoginPage is not displayed", false);
			log.info("LoginPage is not displayed");
		}

	}
	
	@When("^User login to application with \"([^\"]*)\" and \"([^\"]*)\" and verify Credentials$")
	public void verifyUserCredentials(String username, String password) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(loginPage.getUsername()));
		if (loginPage.isScreenDisplayed()) {
			loginPage.getUsername().sendKeys(username);
			loginPage.getPassword().sendKeys(password);
			if (loginPage.rememberMeChkbox().isSelected()) {
				log.info("Remeber Check box is already selected");
			} else {
				loginPage.rememberMeChkbox().click();
				log.info("Remeber Me Checkbox is checked");
			}

			loginPage.clickSignIn().click();
			log.info("User entered Username :" + username + " and Password :" + password
					+ " ,and clicked on SignIn Button");
			verifyEnteredCredentials();
			verifyIsAnotherLoginSessionScreenIsDisplayed();
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("LoginPage is not displayed", false);
			log.info("LoginPage is not displayed");
		}
	}

	@Then("^User login Page is displayed$")
	public void verifyLoginPageIsDisplayed() throws Throwable {
		// Thread.sleep(1000);-------------------
		// Assert.assertTrue("LoginPage is not displayed",
		// loginPage.isScreenDisplayed());
		// ApplicationHelper.takeScreenshot();
		checkLoginPageIsDisplayed();
		log.info("Login page is displayed");
	}

	@Then("^close the browser$")
	public void closeBrowser() {
		log.info("Closing the Session");
		driver.close();
	}

	@Then("^Verify LoginPage Footer Section and validate the links$")
	public void verifyLoginPageFooterSection() throws InterruptedException {
		clickCookiePolicy();
		clickPrivacyStatement();
		clickTermsOfUse();
		clickCopyRight();
	}

	@Then("^Verify LoginPage Header Section and validate the links$")
	public void verifyLoginPageHeaderSection() throws InterruptedException {
		clickAboutTRBDMENALink();
		clickWhySubscribeLink();
	}
	
	@Then("^Verify forgot password link on login page$")
	public void verifyForgotPasswordLinkFunctionality()
	{
		if(loginPage.forgotPswdLink().isDisplayed())
		{
			loginPage.forgotPswdLink().click();
			checkPasswordAssistancePageisDisplayed();
		}
		else
		{
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Forgot Password Link is not displayed", false);
		}
	}

	public void checkPasswordAssistancePageisDisplayed()
	{
		if (!loginPage.isPasswordAssistanceScreenIsDisplayed()) {
				ApplicationHelper.takeScreenShot();
				log.info("Login page is not displayed");
				Assert.assertTrue("LoginPage is not displayed", false);
			}
		else
		{
			loginPage.userId().sendKeys("trbd.mena2@thomsonreuters.com");
			log.info("Entered UserID for UserID Field");
			loginPage.okBtn().click();
			log.info("Clicked on OK Button");
			verifyEmailSentMsgDisplayed();
		}
	}
	public void verifyEmailSentMsgDisplayed()
	{
		try
		{
			if(loginPage.emailSentMsg().isDisplayed())		
		   {
			 log.info("Email Sent message is displayed as expected");
		   }
			else
			{
				log.info("Email Sent Message is not displayed");
				ApplicationHelper.takeScreenShot();
				Assert.assertTrue("Email Sent Message is not displayed", false);
			}
		}
		catch (Exception e) {
			log.info("Exception in verifyEmailSentMsgDisplayed method");
		}
	}
	/*
	 * public void navigateBackToLoginPage() { if
	 * (loginPage.isCookiePolicyDisplayed()) { ApplicationHelper.navigatePageBack();
	 * } else { //ApplicationHelper.navigatePageBack();
	 * ApplicationHelper.takeScreenShot();
	 * Assert.assertTrue("Cookie Policy Screen is not displayed", false); } }
	 */

	public void clickCookiePolicy() throws InterruptedException {
		if (loginPage.isCookiePolicyAvailable()) {
			loginPage.clickCookiePolicy();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());
			
			WebDriverWait wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.visibilityOf(loginPage.cookiePolicyHeadlineText()));
			if (loginPage.isCookiePolicyDisplayed()) {
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				// ApplicationHelper.navigatePageBack();
				ApplicationHelper.takeScreenShot();
				Assert.assertTrue("Cookie Policy Screen is not displayed", false);
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Cookie Policy Option is not available", false);
		}
	}

	public void clickPrivacyStatement() throws InterruptedException {
		if (loginPage.isPrivacyStatementAvailable()) {
			loginPage.clickPrivacyStatement();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());

			WebDriverWait wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.visibilityOf(loginPage.privacyStatementHeadlinetext()));
			if (loginPage.isPrivacyStatementDisplayed()) {
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				// ApplicationHelper.navigatePageBack();
				ApplicationHelper.takeScreenShot();
				Assert.assertTrue("Privacy Statement Screen is not displayed", false);
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Privacy Statement Option is not available", false);
		}
	}

	public void clickTermsOfUse() throws InterruptedException {
		if (loginPage.isTermsOfUseAvailable()) {
			loginPage.clickTermsOfUse();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());

			WebDriverWait wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.visibilityOf(loginPage.termsOfUseHeadlineText()));
			if (loginPage.isTermsOfUseDisplayed()) {
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				// ApplicationHelper.navigatePageBack();
				ApplicationHelper.takeScreenShot();
				Assert.assertTrue("Terms Of Use Screen is not displayed", false);
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Terms Of Use Option is not available", false);
		}
	}

	public void clickCopyRight() throws InterruptedException {
		if (loginPage.isCopyRightAvailable()) {
			loginPage.clickCopyRight();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());

			WebDriverWait wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.visibilityOf(loginPage.copyRightHeadlineText()));
			if (loginPage.isCopyRightDisplayed()) {
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				// ApplicationHelper.navigatePageBack();
				ApplicationHelper.takeScreenShot();
				Assert.assertTrue("Copy Right Screen is not displayed", false);
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("CopyRight Option is not available", false);
		}
	}

	public void checkLoginPageIsDisplayed() {
		/*
		 * if (loginPage.isScreenDisplayed()) { // ApplicationHelper.takeScreenshot(); }
		 * else { // ApplicationHelper.takeScreenshot();
		 * Assert.assertTrue("My Account Option is not available", false); }
		 */

		if (!loginPage.isScreenDisplayed()) {
			ApplicationHelper.takeScreenShot();
			log.info("Login page is not displayed");
			Assert.assertTrue("LoginPage is not displayed", false);
		}
	}

	public void verifyIsAnotherLoginSessionScreenIsDisplayed() throws InterruptedException {
		// Thread.sleep(1000);-------------------
		try {
			if (loginPage.anotherSessionScreen().isDisplayed() || loginPage.anotherSessionScreen().isEnabled()) {
				loginPage.signInAnyway().click();
				log.info("Another Session created page is displayed,and clicked on SignIn Anyway button");
			}
		} catch (Exception e) {
			log.info("Antoher Session Page is not encountered");
		}
	}

	public void verifyEnteredCredentials() {
		/*
		 * try { if (loginPage.invalidUsernameAndPswdMsg().isDisplayed()) {
		 * System.out.println("Entered credentials are invalid"); }
		 * 
		 * } catch (Exception e) { // TODO: handle exception }
		 */
		try {
			if (!loginPage.isInvalidScreenDisplayed()) {
				//ApplicationHelper.takeScreenShot();
				log.info("The entered Username or Password is Correct");
				//Assert.assertTrue("Invalid User name and password alert is not displayed", false);
			}
		} catch (Exception e) {
			log.info("Entered Valid credentials");
		}
		// Assert.assertTrue("Invalid message is not
		// displayed",loginPage.invalidUsernameAndPswdMsg().isDisplayed());
	}

	public void clickAboutTRBDMENALink() throws InterruptedException {
		if (loginPage.isAbouttrbdLinkAvailable()) {
			loginPage.clickAboutTRBDMena();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			String redirectedURL = driver.getCurrentUrl();
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());
			// if (loginPage.isCookiePolicyDisplayed()) {
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			if(actualTitle.contains("Network Error")) 
			{
				Set <String> windows = driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				String parent = it.next();
				while(it.hasNext()){
					driver.switchTo().window(it.next());
					driver.close();
				}
				driver.switchTo().window(parent);
			}
			/*else {
				WebDriverWait wt = new WebDriverWait(driver, 30);
				wt.until(ExpectedConditions.visibilityOf(loginPage.TRBDHeadlineText()));
				if (loginPage.TRBDHeadlineText().isDisplayed()) {
					driver.close();
					driver.switchTo().window(tabs2.get(0));
			}*/
			
				// ApplicationHelper.navigatePageBack();
				
			}
		
		/*else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("About TRBD Mena is not available", false);
		}*/
	}

	public void clickWhySubscribeLink() throws InterruptedException {
		if (loginPage.isWhySubscribeLinkAvailable()) {
			loginPage.clickWhySubscribe();
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			String redirectedURL = driver.getCurrentUrl();
			log.info("Page is redirected to: " + driver.getCurrentUrl());
			
			System.out.println("Page is redirected to: " + driver.getCurrentUrl());
			
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			if(actualTitle.contains("Network Error")) 
			{
				Set <String> windows = driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				String parent = it.next();
				while(it.hasNext()){
					driver.switchTo().window(it.next());
					driver.close();
				}
				driver.switchTo().window(parent);
			}
			/*else {
			// if (loginPage.isCookiePolicyDisplayed()) {
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			}*/
		} /*
			 * else { //ApplicationHelper.navigatePageBack();
			 * ApplicationHelper.takeScreenShot();
			 * Assert.assertTrue("Cookie Policy Screen is not displayed", false); }
			 */
		// navigateBackToLoginPage();
		// }
		/*else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Why Subscribe Link is not available", false);
		}*/
	}
}
