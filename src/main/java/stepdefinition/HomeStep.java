package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import org.apache.log4j.Logger;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;

public class HomeStep extends Base {
	private static Logger log = LoggerHelper.getLogger(HomeStep.class);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	LoginPage loginPage;
	HomePage homePage;

	public HomeStep() throws IOException {
		// driver = initializeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		prop = new Properties();
		FileInputStream fis = new FileInputStream(("user.dir")+ "\\src\\main\\resources\\Data.properties");

		prop.load(fis);
	}
	@When("^User clicks on Title$")
	public void titleIsPresent() throws InterruptedException {
	Title();

	}
	public void Title() {

	try {
	if (homePage.getTitle().isDisplayed()) {
	Thread.sleep(5000);
	homePage.getTitle().click();
log.info("Click Button");
	}
	else {
	ApplicationHelper.takeScreenShot();
log.info("title is not present");
	}
	} catch (Exception exc) {
	exc.printStackTrace();
	System.out.println("title is not verified");
	} 
	}
	@Then("^Homepage should get display$")
	public void verifyHomePageIsDisplayed() {
		/*
		 * if (homePage.isScreenDisplayed()) { //ApplicationHelper.takeScreenshot(); }
		 * else { //ApplicationHelper.takeScreenshot();
		 * Assert.assertTrue("Home screen is not displayed", false); }
		 */
		if (!homePage.isScreenDisplayed()) {
			ApplicationHelper.takeScreenShot();
			log.info("Homepage is not displayed");
			Assert.assertTrue("Home Screen is not displayed", false);
		}
	}

	@When("^user clicks on Logout button,LoginPage should get display$")
	public void clickOnLogoutButton() throws Throwable {
		try {
			wait.until(ExpectedConditions.visibilityOf(homePage.logoutButton()));
		if (homePage.logoutButton().isDisplayed()) {
			homePage.logoutButton().click();
			log.info("Clicked on Logout Button");
			Assert.assertTrue("Login Page is not displayed", loginPage.isScreenDisplayed());
		} else {
			ApplicationHelper.takeScreenShot();
			log.info("Logout button is not displayed");
			Assert.assertTrue("Logout button is not displayed", false);
		}
		}
		catch (Exception e) {
			ApplicationHelper.takeScreenShot();// TODO: handle exception
		}
	}

	@When("^i select Region,Sectors and click on Build List$")
	public void enterRegionSectorDetails() throws Exception {
		enterRegionDetails();
		enterSectorDetails();
		enterSearchKeyword();
		clickOnBuildListButton();
	}
	
	@When("^i Click on Build List Button without selecting any filters$")
	public void clickOnBuildListWithoutFilters() throws InterruptedException
	{
		clickOnBuildListButton();
	}
	
	@Then("^Verify Homepage Dashboard items$")
	public void verifyHomepageDahsboardItems() {

		if (!//homePage.verifyMainPillars() &&
				homePage.verifyDifferentScetions()) {
			ApplicationHelper.takeScreenShot();
			log.info("Homepage is not displayed with expected fields");
			Assert.assertTrue("Homepage is not displayed with expected fields", false);
		}
	}

	public void enterRegionDetails() {
		String region = prop.getProperty("Region");

		if (!region.isEmpty()) {
			// && wait.until(ExpectedConditions
			// .visibilityOfElementLocated(By.xpath("//label[contains(text(),"+region+")]")))
			// != null) {
			homePage.selectRegion().sendKeys(region);
			log.info("Selected Region is: " + region);
			// label[contains(text(),"Ajim")]
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//label[contains(text()," + "\"" + region + "\"" + ")]")));
			// System.out.println("Hai"+element.getText());
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} else {
			homePage.selectRegion().clear();
			homePage.selectRegion().click();
			WebElement element=driver.findElement(By.xpath("//div[contains(@class,'dropdown-global-menu')]//label[contains(text(),'MENA')]"));
			String minimizecontrol = element.getAttribute("class");
				if (minimizecontrol.contains("dropdown-global-element-label__checkbox-label label-checkbox label-checkbox_selected-false")) {
					homePage.selectDefaultValueForRegion().click();
				}
				
				else if  (minimizecontrol.contains("dropdown-global-element-label__checkbox-label label-checkbox label-checkbox_selected-true")) {
					
				}
				
		
			log.info("Selected Default value for Region field");
		}
	}

	public void enterSectorDetails() throws InterruptedException {
		String sector = prop.getProperty("Sector");

		if (!sector.isEmpty()) {
			homePage.selectSector().sendKeys(sector);
			log.info("Selected Sector is: " + sector);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//label[contains(text()," + "\"" + sector + "\"" + ")]")));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} else {
			homePage.selectSector().clear();
			homePage.selectSector().click();
			
			WebElement element=driver.findElement(By.xpath("//div[contains(@id,'globalSectorSubsectorGlobalSelectFilterWrapper')]/div[2]//label[contains(text(),'All')]"));
			String minimizecontrol = element.getAttribute("class");
				if (minimizecontrol.contains("dropdown-global-element-label__checkbox-label label-checkbox label-checkbox_selected-false")) {
					homePage.selectDefaultValueForSector().click();;
				}
				
				else if  (minimizecontrol.contains("dropdown-global-element-label__checkbox-label label-checkbox label-checkbox_selected-true")) {
					
				}
				
		
			log.info("Selected Default value for Sector Field");
		}

	}
	

	public void enterSearchKeyword() throws Exception
	{
	 
		String searchKeyword = prop.getProperty("SearchKeyword");
		homePage.searchKeyword().clear();
		Thread.sleep(2000);
		homePage.searchKeyword().sendKeys(searchKeyword);
	 }
	 
	
	public void clickOnBuildListButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(homePage.btnBuildList()));
		if (homePage.btnBuildList().isDisplayed()) {
			homePage.btnBuildList().click();
			log.info("Clicked on Build List Button");
		} else {
			ApplicationHelper.takeScreenShot();
			log.info("Build List button is not displayed");
		}
	}
	
	public void verifyMainPillars()
	{
		if (homePage.btnBuildList().isDisplayed()) {
			homePage.btnBuildList().click();
			log.info("Clicked on Build List Button");
		} else {
			ApplicationHelper.takeScreenShot();
			log.info("Build List button is not displayed");
		}
	}
    public void verifyDifferentScetions()
    {
    	
    
    	}
        
    }

