package stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.MySettingsPage;
import org.apache.log4j.Logger;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;

public class MySettingsStep extends Base {
	
	private static Logger log = LoggerHelper.getLogger(MySettingsStep.class);
	WebDriverWait wt=new WebDriverWait(driver, 40);
	
	MySettingsPage mySettingsPage;
	HomePage homePage;

	public MySettingsStep() throws IOException {
		//driver = initializeDriver();
		mySettingsPage = new MySettingsPage(driver);
		homePage=new HomePage(driver);
	}

	
	@When("^i click on My Settings tab$")
	public void verifyAndClickOnMySettingsTab() throws InterruptedException
	{
		clickOnMySettingsTabInHomePage();
		//Thread.sleep(300);
	}
	
	@Then("^My Settings related info.section should get display$")
	public void validateMySettingsRelatedInfo() throws InterruptedException
	{
		checkMySettingsPageIsDisplayed();
		//Thread.sleep(1000);
	}
	
	
	

	public void checkMySettingsPageIsDisplayed() {
		if (!mySettingsPage.isScreenDisplayed()) {
			 ApplicationHelper.takeScreenShot();
			log.info("My Settings Page is not displayed");
			Assert.assertTrue("MySettings Page is not displayed", false);			
		}
	}	
	
	public void clickOnMySettingsTabInHomePage()
	{
		wt.until(ExpectedConditions.visibilityOf(homePage.mySettingsTab()));
		if(homePage.mySettingsTab().isDisplayed())
		{
			homePage.mySettingsTab().click();
			log.info("Clicked on My Settings Tab");
		}
		else
		{
			ApplicationHelper.takeScreenShot();
			log.info("My Settings tab is not displayed in Homepage");
		}
	}
	
}
