package stepdefinition;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.BuildListSearchResultPage;
import pageObjects.CompanySearchResultPage;

public class CompanySearchResultStep extends Base {

	private static Logger log = LoggerHelper.getLogger(CompanySearchResultStep.class);
	WebDriverWait wait = new WebDriverWait(driver, 50);
	CompanySearchResultPage companySearchResultPage;
	BuildListSearchResultPage buildListSearchResultPage;

	public CompanySearchResultStep() throws IOException {
		companySearchResultPage = new CompanySearchResultPage(driver);
	}

	@Then("^Verify Company related information$")
	public void verifySelectedCompanyDetails() throws Throwable {
		Thread.sleep(3000);
		if (companySearchResultPage.isScreenDisplayed()) {
			log.info("Company Related Details Page is displayed");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//collapsible-panel[contains(@header-text,'res_Company_Details_Profile')]/div/div[2]//ul/li/div")));
			List<WebElement> dd = driver.findElements(By.xpath(
					"//collapsible-panel[contains(@header-text,'res_Company_Details_Profile')]/div/div[2]//ul/li/div"));
			log.info("Company Related Details Are:");
			for (int i = 0; i < dd.size(); i++) {
				if (dd.get(i).getText() != null && !dd.get(i).getText().equalsIgnoreCase("")) {
					log.info("" + dd.get(i).getText() + " : " + dd.get(i + 1).getText());
					i = i + 1;
				}
			}
			verifyOtherTabDetails();
			Thread.sleep(3000);
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Company Related Details page is not displayed", false);
			log.info("Company Related Details page is not displayed");
		}
		
	}
	
	@And("^click on Return Back,search result page should display$")
	public void clickOnReslutbackButton() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(companySearchResultPage.backToResultsBtn()));
		if(companySearchResultPage.backToResultsBtn().isDisplayed())
		{
			companySearchResultPage.backToResultsBtn().click();
			Thread.sleep(2000);
			log.info("Clicked on Back To Result Button");
			//Assert.assertTrue("Search Result page is not displayed", buildListSearchResultPage.isScreenDisplayed());
		}
		else
		{
			ApplicationHelper.takeScreenShot();
			log.info("Back To Result button is not displayed");
		}
		//logout();
	}
	

	public void verifyOtherTabDetails() throws InterruptedException {
		WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
		List<WebElement> allData = table.findElements(By.tagName("li"));
		System.out.println(allData.size());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_')]")));
		for (WebElement row : allData) {
			List<WebElement> cells = row.findElements(By.xpath(
					"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_')]"));
			for (WebElement cell : cells) {
				if (!cell.getText().equalsIgnoreCase("FAST FACTS")) {
					cell.click();
					Thread.sleep(200);
					log.info("Clicked on " + cell.getText() + " Tab");
					if(cell.getText().equalsIgnoreCase("OVERVIEW"))
					{
						wait.until(ExpectedConditions.visibilityOf(companySearchResultPage.industryClassifcationText()));
						Assert.assertTrue(cell.getText()+"Tab is not displayed", companySearchResultPage.industryClassifcationText().isDisplayed());
						log.info(cell.getText()+" related Info. is displayed");
					}
					else if(cell.getText().equalsIgnoreCase("OWNERSHIP"))
					{
						wait.until(ExpectedConditions.visibilityOf(companySearchResultPage.shareHolderText()));
						Assert.assertTrue(cell.getText()+"Tab is not displayed", companySearchResultPage.shareHolderText().isDisplayed());
						log.info(cell.getText()+" related Info. is displayed");
					}
					else if(cell.getText().equalsIgnoreCase("RELATIONSHIPS"))
					{
						//Assert.assertTrue(cell.getText()+"Tab is not displayed", companySearchResultPage.representativeText().isDisplayed());
						//log.info(cell.getText()+" related Info. is displayed");
					}
					else if(cell.getText().equalsIgnoreCase("OFFICERS"))
					{
						//Assert.assertTrue(cell.getText()+"Tab is not displayed", companySearchResultPage.boardOfDirectorsText().isDisplayed());
						//log.info(cell.getText()+" related Info. is displayed");
					}
				}
			}
			break;
		}
	}
	
	public void logout()
	{
		if(companySearchResultPage.logoutBtn().isDisplayed())
		{
			companySearchResultPage.logoutBtn().click();
			log.info("Clicked on Logout Button");
		}
		else
		{
			ApplicationHelper.takeScreenShot();
			log.info("Log out Button is not Displayed");
		}
		driver.close();
	}
}
