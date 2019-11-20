package stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.MySettingsPage;
import org.apache.log4j.Logger;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;

public class MyAccountStep extends Base {
	
	private static Logger log = LoggerHelper.getLogger(MyAccountStep.class);
	WebDriverWait wt=new WebDriverWait(driver, 40);
	
	MyAccountPage myAccountPage;
	HomePage homePage;

	public MyAccountStep() throws IOException {
		//driver = initializeDriver();
		myAccountPage = new MyAccountPage(driver);
		homePage=new HomePage(driver);
	}

	
	@When("^i click on My Accounts tab$")
	public void verifyAndClickOnMyAccountsTab() throws InterruptedException
	{
		clickOnMyAccountsTabInHomePage();
		//Thread.sleep(300);
	}
	
	@Then("^Page should navigate to My Account Page$")
	public void verifyMyAccountRelatedInfo()
	{
		checkMyAccountPageIsDisplayed();
	}
	
	public void checkMyAccountPageIsDisplayed() {
		if (!myAccountPage.isScreenDisplayed()) {
			 ApplicationHelper.takeScreenShot();
			log.info("My Account Page is not displayed");
			Assert.assertTrue("My Account Page is not displayed", false);			
		}
	}
	
	public void clickOnMyAccountsTabInHomePage()
	{
		wt.until(ExpectedConditions.visibilityOf(homePage.myAccountTab()));
		if(homePage.myAccountTab().isDisplayed())
		{
			homePage.myAccountTab().click();
			log.info("Clicked on My Account Tab");
		}
		else
		{
			ApplicationHelper.takeScreenShot();
			log.info("My Account tab is not displayed in Homepage");
		}
	}
	
}
