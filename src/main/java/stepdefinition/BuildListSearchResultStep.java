package stepdefinition;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;
import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;
import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BuildListSearchResultPage;
public class BuildListSearchResultStep extends Base {
	private static Logger log = LoggerHelper.getLogger(BuildListSearchResultStep.class);
	WebDriverWait wait = new WebDriverWait(driver, 70);
	BuildListSearchResultPage buildListSearchResultPage;
	public static String firstRowCompanyNameText;
	public BuildListSearchResultStep() throws IOException {
		// driver = initializeDriver();
		buildListSearchResultPage = new BuildListSearchResultPage(driver);
	}
	@Then("^Verify serach result page contents$")
	public void verifySearchResultspageContents() throws Throwable {
		wait.until(
				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));
		Thread.sleep(2000);
		if (buildListSearchResultPage.isScreenDisplayed()
				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {
			// System.out.println("By Default Companies Tab get selected");
			// System.out.println("Fisrt tab Name: " +
			// buildListSearchResultPage.firstTabName().getText());
			// String ssss = buildListSearchResultPage.firstTabCount().getText();
			log.info("Build List Search Result Page is displayed");
			// log.info("First tab count is: " +
			// buildListSearchResultPage.firstTabCount().getText());
			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
			List<WebElement> allData = table.findElements(By.tagName("li"));
			System.out.println(allData.size());
			for (WebElement row : allData) {
				List<WebElement> cells = row.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(cells));
				for (WebElement cell : cells) {
					if (!cell.getText().equalsIgnoreCase("COMPANIES")) {
						Thread.sleep(3000);
						cell.click();
					}
					System.out.println("content >>   " + cell.getText());
					String str = cell.getText();
					String resStr = firstLetterCaps(str);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
									+ resStr + "')]")));
					Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(
							"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
									+ resStr + "')]"))
							.isDisplayed());
					// System.out.println(resStr);
					List<WebElement> rr = cell.findElements(By.xpath(
							"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_"
									+ resStr + "')]/following-sibling::span"));
					// System.out.println(rr.size());
					for (WebElement ee : rr) {
						Thread.sleep(3000);
						// log.info("content >> " + ee.getText());
						log.info("Switched to Tab: " + str + " and Total Count is: " + ee.getText());
					}
				}
				break;
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Build List Search Result Page is not displayed", false);
		}
		// JavascriptExecutor js=(JavascriptExecutor) driver;
		// js.executeScript("Window.scrollBy(0,1000)");
		/* 
		 * // Grab the table WebElement table1 = driver.findElement(By.
		 * xpath("//table[contains(@class,'result-grid result-grid_frozen')]/tbody"));
		 * // Now get all the TR elements from the table List<WebElement> allRows  
		 * table1.findElements(By.tagName("tr")); // And iterate over them, getting th
		 * cells for (WebElement row : allRows) { List<WebElement> cells =
		 * 
		 * row.findElements(By.tagName("td")); for (WebElement cell : cells) 
		 * List<WebElement> data=cell.findElements(By.
		 * xpath("//div//div/span[contains(@ng-bind,'::$ctrl.item') or contains(@ng-bind,'companyNumberString') or contains(@ng-bind-html,'::$ctrl.item')]"
		 * ));
		 * 
		 * for(WebElement dfdf:data) { System.out.println("content >>   " +
		 * dfdf.getText()); } } }
		 */
	}
	@Then("^Verify serach result page contents on left side of the page$")
	public void verifySearchResultspageContentsOnLeftSideOfthePage() throws InterruptedException {
		Thread.sleep(5000);
		if (!buildListSearchResultPage.verifyContentsOnLeftSide()) {
			ApplicationHelper.takeScreenShot();
			log.info("BuildList Search Result Page is not displayed with expected fields");
			Assert.assertTrue("BuildList Search Result Page is not displayed with expected fields", false);
		}
	}
	@Then("^Center of the page$")
	public void verifySearchResultspageContentsOnCentreOfthePage() throws InterruptedException {
		WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
		List<WebElement> allData = table.findElements(By.tagName("li"));
		System.out.println(allData.size());
		for (WebElement row : allData) {
			List<WebElement> cells = row.findElements(By.xpath(
					"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
			wait.until(ExpectedConditions.visibilityOfAllElements(cells));
			for (WebElement cell : cells) {
				if (!cell.getText().equalsIgnoreCase("COMPANIES")) {
					Thread.sleep(4000);
					cell.click();
				}
				System.out.println("content >>   " + cell.getText());
				String str = cell.getText();
				String resStr = firstLetterCaps(str);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
								+ resStr + "')]")));
				Assert.assertTrue(resStr + " tab is not displayed",
						driver.findElement(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]"))
								.isDisplayed());
				// System.out.println(resStr);
				List<WebElement> rr = cell.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_"
								+ resStr + "')]/following-sibling::span"));
				// System.out.println(rr.size());
				for (WebElement ee : rr) {
					Thread.sleep(4000);
					// log.info("content >> " + ee.getText());
					log.info(str + " Tab is displayed as expected");
					log.info("Switched to Tab: " + str + " and Total Count is: " + ee.getText());
				}
			}
			break;
		}
	}
	@Then("^Right side of the page$")
	public void verifySearchResultspageContentsOnRightsideOfthePage() {
		if (!buildListSearchResultPage.verifyContentsOnRightSide()) {
			ApplicationHelper.takeScreenShot();
			log.info("BuildList Search Result Page is not displayed with expected fields on Right side");
			Assert.assertTrue("BuildList Search Result Page is not displayed with expected fields on Right side",
					false);
		}
	}
	@When("^i clicked on Company Name in the Companies tab$")
	public void clickOnFirstCompanyNameInTable() throws InterruptedException {
		buildListSearchResultPage.firstTabName().click();
		Thread.sleep(4000);
		if (buildListSearchResultPage.searchTable().isDisplayed()) {
			log.info("Clicked on: " + buildListSearchResultPage.firstTabName().getText() + " Tab");
			// List<WebElement>
			// FirstRowData=driver.findElements(By.xpath("//table[contains(@class,'result-grid
			// result-grid_frozen')]/tbody/tr[1]/td//span[contains(@ng-bind,'::$ctrl.item')
			// or contains(@ng-bind,'companyNumberString') or
			// contains(@ng-bind-html,'::$ctrl.item')]"));
			WebElement firstRowCompanyName = driver.findElement(
					By.xpath("//table[contains(@class,'result-grid result-grid_frozen')]/tbody/tr[1]/td[2]"));
			firstRowCompanyNameText = firstRowCompanyName.getText();
			System.out.println(firstRowCompanyNameText);
			// js.executeScript("Window.scrollTo(0,2000)");
			// js.executeScript("arguments[0].scrollIntoView();", firstRowCompanyName);
			firstRowCompanyName.click();
			log.info("Search Table is displayed and clicked on first row Company Name: " + firstRowCompanyNameText);
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Build List Search Result Table is not displayed", false);
		}
	}
	@Then("^verify search terms on Officers Screen$")
	public void verifySearchTermsOnOfficersScreen() throws InterruptedException, IOException {
		wait.until(
				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));
		if (buildListSearchResultPage.isScreenDisplayed()
				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {
			log.info("Build List Search Result Page is displayed");
			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
			List<WebElement> allData = table.findElements(By.tagName("li"));
			System.out.println(allData.size());
			loop: for (WebElement row : allData) {
				List<WebElement> cells = row.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(cells));
				for (WebElement cell : cells) {
					if (cell.getText().equalsIgnoreCase("OFFICERS")) {
						Thread.sleep(4000);
						cell.click();
						System.out.println("content >>   " + cell.getText());
						String str = cell.getText();
						String resStr = firstLetterCaps(str);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]")));
						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]"))
								.isDisplayed());
						break loop;
					}
				}
			}
			getpropertiesValues();
			List<String> items = new ArrayList<String>();
			String firstName = prop.getProperty("FirstName");
			String familyName = prop.getProperty("FamilyName");
			// String compName = prop.getProperty("CompanyName");
			try {
				if (firstName.equals("")) {
					firstName = "";
				} else if (familyName.equals("")) {
					familyName = "";
				}
				String name = firstName + " " + familyName;
				System.out.println(name);
				System.out.println(firstName + " " + familyName);
				if (name.trim().length() == 0) {
					items.add(null);
				} else {
					items.add(name);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			items.removeAll(Arrays.asList("", null));
			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {
				if (items.size() != 0 || !items.isEmpty()) {
					Actions builder = new Actions(driver);
					// items.removeIf(Objects::isNull);
					log.info("Selected(Paased Input) Filter Size is:" + items.size());
					System.out.println("The List Size is :" + items.size());
					buildListSearchResultPage.advancedSearchText().click();
					String ss = items.toString().trim();
					String[] splitStr = ss.trim().split("\\s+");
					if (splitStr[0] != null) {
						String reSplitStr0 = splitStr[0].replaceAll("[\\p{S}\\p{P}�]+", "");
						buildListSearchResultPage.firstname().sendKeys(reSplitStr0);
						builder.sendKeys(Keys.ENTER);
					}
					if (splitStr[1] != null) {
						String reSplitStr1 = splitStr[1].replaceAll("[\\p{S}\\p{P}�]+", "");
						buildListSearchResultPage.familyName().sendKeys(reSplitStr1);
						builder.sendKeys(Keys.ENTER);
					}
					// buildListSearchResultPage.companyName().sendKeys(compName);
					System.out.println("5678");
					builder.sendKeys(Keys.TAB);
					driver.findElement(By.xpath("//span[contains(text(),'Current or Past')]")).click();
					String filterCount = buildListSearchResultPage.resFilterCount().getText();
					String resFilterInString = filterCount.replaceAll("\\p{P}", "");
					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
					Thread.sleep(4000);
					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());
				} else {
					String filterCount = driver.findElement(By.xpath(
							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))
							.getText();
					String resFilter = filterCount.replaceAll("\\p{P}", "");
					int ss = Integer.parseInt(resFilter);
					if (ss == 0) {
						log.info("No Filters are selected");
						System.out.println("No Filters are selected");
					}
				}
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Build List Search Result Page is not displayed", false);
		}
	}
	@Then("^verify search terms on News Screen$")
	public void verifySearchTermsOnNewsScreen() throws InterruptedException, IOException {
		wait.until(
				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));
		if (buildListSearchResultPage.isScreenDisplayed()
				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {
			log.info("Build List Search Result Page is displayed");
			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
			List<WebElement> allData = table.findElements(By.tagName("li"));
			System.out.println(allData.size());
			loop: for (WebElement row : allData) {
				List<WebElement> cells = row.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(cells));
				for (WebElement cell : cells) {
					if (cell.getText().equalsIgnoreCase("News")) {
						Thread.sleep(4000);
						cell.click();
						System.out.println("content >>   " + cell.getText());
						String str = cell.getText();
						String resStr = firstLetterCaps(str);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]")));
						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]"))
								.isDisplayed());
						break loop;
					}
				}
			}
			getpropertiesValues();
			List<String> items = new ArrayList<String>();
			String startDate = prop.getProperty("StartDate");
			String endDate = prop.getProperty("EndDate");
			String officer = prop.getProperty("Officer");
			// String compName = prop.getProperty("CompanyName");
			items.add(startDate);
			// items.add(officer);
			// items.add(compName);
			items.removeAll(Arrays.asList("", null));
			if (buildListSearchResultPage.date().isDisplayed()) {
				if (items.size() != 0 || !items.isEmpty()) {
					Actions builder = new Actions(driver);
					// items.removeIf(Objects::isNull);
					log.info("Selected(Paased Input) Filter Size is:" + items.size());
					System.out.println("The List Size is :" + items.size());
					buildListSearchResultPage.date().click();
					buildListSearchResultPage.startDate().clear();
					buildListSearchResultPage.startDate().sendKeys(startDate);
					buildListSearchResultPage.endDate().clear();
					buildListSearchResultPage.endDate().sendKeys(endDate);
					// buildListSearchResultPage.officerName().sendKeys(officer);
					buildListSearchResultPage.applyBtn().click();
					System.out.println("5678");
					String filterCount = buildListSearchResultPage.resFilterCount().getText();
					String resFilterInString = filterCount.replaceAll("\\p{P}", "");
					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
					Thread.sleep(4000);
					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());
				} else {
					String filterCount = driver.findElement(By.xpath(
							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))
							.getText();
					String resFilter = filterCount.replaceAll("\\p{P}", "");
					int ss = Integer.parseInt(resFilter);
					if (ss == 0) {
						log.info("No Filters are selected");
						System.out.println("No Filters are selected");
					}
				}
			}
		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Build List Search Result Page is not displayed", false);
		}
	}
	@Then("^verify search by Officer's name$")
public void verifySearchByOfficerName() throws InterruptedException, IOException {
		wait.until(
				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Officers"));
		if (buildListSearchResultPage.isScreenDisplayed()
				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Officers")) {
			log.info("Build List Search Result Page is displayed");
			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
			List<WebElement> allData = table.findElements(By.tagName("li"));
			System.out.println(allData.size());
			loop: for (WebElement row : allData) {
				List<WebElement> cells = row.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(cells));
				for (WebElement cell : cells) {
					if (cell.getText().equalsIgnoreCase("OFFICERS")) {
						cell.click();
						System.out.println("content >>   " + cell.getText());
						String str = cell.getText();
						String resStr = firstLetterCaps(str);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]")));
						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]"))
								.isDisplayed());
						break loop;
					}
				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String firstName = prop.getProperty("FirstName");

			String familyName = prop.getProperty("FamilyName");

			// String compName = prop.getProperty("CompanyName");

			if (firstName.equals("")) {

				firstName = "";

			} else if (familyName.equals("")) {

				familyName = "";

			}

			String name = firstName + " " + familyName;

			System.out.println(name);

			System.out.println(firstName + " " + familyName);

			if (name.trim().length() == 0) {

				items.add(null);

			} else {

				items.add(name);

			}

			// items.add(compName);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					log.info("Before");

					if (buildListSearchResultPage.advancedSearchPlus().isDisplayed()) {

						log.info("Advance Search is diaplyed with the expand option(+) By default");

						buildListSearchResultPage.advancedSearchPlus().click();

						log.info("Clicked on +/expand option");

						if (buildListSearchResultPage.advancedSearchMinus().isDisplayed()) {

							log.info("Advance Search is diaplyed with the Collapse option(-)");

						}

					}

					// =============================

					try {

						// buildListSearchResultPage.advancedSearchPlus().click();

						String ss = items.toString().trim();

						String[] splitStr = ss.trim().split("\\s+");

						if (splitStr[0] != null) {

							String reSplitStr0 = splitStr[0].replaceAll("[\\p{S}\\p{P}�]+", "");

							buildListSearchResultPage.firstname().sendKeys(reSplitStr0);

							builder.sendKeys(Keys.ENTER);

						}

						if (splitStr[1] != null) {

							String reSplitStr1 = splitStr[1].replaceAll("[\\p{S}\\p{P}�]+", "");

							buildListSearchResultPage.familyName().sendKeys(reSplitStr1);

							builder.sendKeys(Keys.ENTER);

						}

						driver.findElement(By.xpath("//span[contains(text(),'Current or Past')]")).click();

					} catch (Exception e) {

					}

					String filterCount = buildListSearchResultPage.resFilterCount().getText();

					String resFilterInString = filterCount.replaceAll("\\p{P}", "");

					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

					Thread.sleep(4000);

					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

					List<WebElement> filterNames = driver

							.findElements(By.xpath("//div[contains(@class,'filter-list-tag-content')]/span"));

					for (WebElement selectedFilters : filterNames) {

						log.info(selectedFilters.getText());

						System.out.println(selectedFilters.getText());

					}

					if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

							.isDisplayed()) {

						log.info("No Results found for the seelected Fliter criteria");

					} else {

						WebElement totalRecords = driver.findElement(By.xpath(

								"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[2]/contacts-screener/div/div/screener-page-header/div/div[2]/div"));

						System.out.println(totalRecords.getText());

						String[] parts = totalRecords.getText().split(" ");

						String lastWord = parts[parts.length - 1];

						System.out.println(lastWord);

						System.out.println("There are " + lastWord + " results are found for the selected Filters");

						log.info("There are " + lastWord + " results are found for the selected Filters");

						/*
						 * 
						 * List<WebElement> tableData = driver.findElements( By.
						 * 
						 * xpath("(//table[contains(@class,'result-grid result-grid_frozen')])[2]/tbody/tr"
						 * 
						 * )); for (WebElement td : tableData) { System.out.println( "There are " +
						 * 
						 * tableData.size() + " results are found for the selected Filters");
						 * 
						 * log.info("There are " + tableData.size() +
						 * 
						 * " results are found for the selected Filters"); break; }
						 * 
						 */

					}

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);
		}

	}

	@Then("^verify search by Principal Activity$")
	public void verifySearchByPrincipalActivity() throws InterruptedException, IOException {
		wait.until(
				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));
		if (buildListSearchResultPage.isScreenDisplayed()
				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {
			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));
			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());
			loop: for (WebElement row : allData) {
				List<WebElement> cells = row.findElements(By.xpath(
						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(cells));
				for (WebElement cell : cells) {
					if (cell.getText().equalsIgnoreCase("COMPANIES")) {
						Thread.sleep(2000);
						cell.click();
						System.out.println("content >>   " + cell.getText());
						String str = cell.getText();
						String resStr = firstLetterCaps(str);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(
								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"
										+ resStr + "')]"))
								.isDisplayed());
						break loop;
					}
				}

			}
			getpropertiesValues();
			List<String> items = new ArrayList<String>();
			String principalActivity = prop.getProperty("PrincipalActivity");
			// String familyName = prop.getProperty("FamilyName");
			// String compName = prop.getProperty("CompanyName");

			// items.add(firstName);
			// items.add(familyName);
			items.add(principalActivity);
			// items.add(compName);

			items.removeAll(Arrays.asList("", null));
			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {
				if (items.size() != 0 || !items.isEmpty()) {
					Actions builder = new Actions(driver);
					// items.removeIf(Objects::isNull);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());
					System.out.println("The List Size is :" + items.size());
					// =============================
					log.info("Before");
					if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {
						buildListSearchResultPage.advancedSearchText().click();
						buildListSearchResultPage.principalActivity().sendKeys(principalActivity);
						builder.sendKeys(Keys.ENTER);

						driver.findElement(
								By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))
								.click();
						String filterCount = buildListSearchResultPage.resFilterCount().getText();
						String resFilterInString = filterCount.replaceAll("\\p{P}", "");
						log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));
						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
						Thread.sleep(2000);

					//	assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());
						List<WebElement> filterNames = driver
								.findElements(By.xpath("//div[contains(@class,'filter-list-tag-content')]/span"));

						for (WebElement selectedFilters : filterNames) {
							log.info(selectedFilters.getText());
							System.out.println(selectedFilters.getText());
						}

						if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))
								.isDisplayed()) {
							log.info("No Results found for the selected Fliter criteria");
						} else {
							
							WebElement totalRecords = driver.findElement(By.xpath(
									"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[1]/companies-screener/div/div/screener-page-header/div/div[2]/div"));
							System.out.println(totalRecords.getText());

							String[] parts = totalRecords.getText().split(" ");
							String lastWord = parts[parts.length - 1];
							System.out.println(lastWord);

							System.out.println("There are " + lastWord + " results are found for the selected Filters");
							log.info("There are " + lastWord + " results are found for the selected Filters");
							/*List<WebElement> tableData = driver.findElements(By
									.xpath("(//table[contains(@class,'result-grid result-grid_frozen')])[2]/tbody/tr"));
							for (WebElement td : tableData) {
								System.out.println("There are " + tableData.size()
										+ " results are found for the selected Filters");
								log.info("There are " + tableData.size()
										+ " results are found for the selected Filters");
							}*/
						}
					} else {
						log.info("Advanced Search is not displayed");
					}

				} else {
					String filterCount = driver.findElement(By.xpath(
							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))
							.getText();
					String resFilter = filterCount.replaceAll("\\p{P}", "");
					int ss = Integer.parseInt(resFilter);
					if (ss == 0) {
						log.info("No Filters are selected");
						System.out.println("No Filters are selected");
					}
				}
			}

		} else {
			ApplicationHelper.takeScreenShot();
			Assert.assertTrue("Build List Search Result Page is not displayed", false);
		}

	}

	@Then("^verify filter by Brand/Agency$")

	public void verifyFilterByBrandOrAgency() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("COMPANIES")) {

						Thread.sleep(6000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String brand = prop.getProperty("Brand/Agency");

			items.add(brand);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					// items.removeIf(Objects::isNull);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					log.info("Before");

					if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

						buildListSearchResultPage.advancedSearchText().click();

						buildListSearchResultPage.brandOrAgency().sendKeys(brand);

						builder.sendKeys(Keys.ENTER);

						driver.findElement(

								By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

								.click();

						String filterCount = buildListSearchResultPage.resFilterCount().getText();

						String resFilterInString = filterCount.replaceAll("\\p{P}", "");

						log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

						Thread.sleep(4000);

						assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

						List<WebElement> filterNames = driver

								.findElements(By.xpath("//div[contains(@class,'filter-list-tag-content')]/span"));

						for (WebElement selectedFilters : filterNames) {

							log.info(selectedFilters.getText());

							System.out.println(selectedFilters.getText());

						}

						if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

								.isDisplayed()) {

							log.info("No Results found for the selected Fliter criteria");

							System.out.println("No Results found for the selected Fliter criteria");

						} else {

							WebElement totalRecords = driver.findElement(By.xpath(

									"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[1]/companies-screener/div/div/screener-page-header/div/div[2]/div"));

							System.out.println(totalRecords.getText());

							String[] parts = totalRecords.getText().split(" ");

							String lastWord = parts[parts.length - 1];

							System.out.println(lastWord);

							System.out.println("There are " + lastWord + " results are found for the selected Filters");

							log.info("There are " + lastWord + " results are found for the selected Filters");

							/*
							 * List<WebElement> tableData = driver.findElements(By
							 * 
							 * .xpath("(//table[contains(@class,'result-grid result-grid_frozen')])[2]/tbody/tr"
							 * ));
							 * 
							 * for (WebElement td : tableData) {
							 * 
							 * System.out.println("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * log.info("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * }
							 */

						}

					} else {

						log.info("Advanced Search is not displayed");

					}

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

						System.out.println("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	@Then("^verify filter by Company Name$")

	public void verifyFilterByCompanyName() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("COMPANIES")) {

						Thread.sleep(6000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String companyName = prop.getProperty("CompaniesScreenCompanyName");

			items.add(companyName);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					// items.removeIf(Objects::isNull);

					log.info("Selected(Passed Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					log.info("Before");

					if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

						buildListSearchResultPage.advancedSearchText().click();

						buildListSearchResultPage.compCompanyName().sendKeys(companyName);

						builder.sendKeys(Keys.ENTER);

						driver.findElement(

								By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

								.click();

						String filterCount = buildListSearchResultPage.resFilterCount().getText();

						String resFilterInString = filterCount.replaceAll("\\p{P}", "");

						log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

						Thread.sleep(4000);

						assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

						List<WebElement> filterNames = driver

								.findElements(By.xpath("//div[contains(@class,'filter-list-tag-content')]/span"));

						for (WebElement selectedFilters : filterNames) {

							log.info(selectedFilters.getText());

							System.out.println(selectedFilters.getText());

						}

						if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

								.isDisplayed()) {

							log.info("No Results found for the selected Fliter criteria");

							System.out.println("No Results found for the selected Fliter criteria");

						} else {

							/*
							 * List<WebElement> tableData = driver.findElements(
							 * 
							 * By.
							 * xpath("//table[contains(@class,'result-grid result-grid_frozen')]/tbody/tr"))
							 * ;
							 * 
							 * for (WebElement td : tableData) {
							 * 
							 * System.out.println("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * log.info("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * }
							 */

							WebElement totalRecords = driver.findElement(By.xpath(

									"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[1]/companies-screener/div/div/screener-page-header/div/div[2]/div"));

							System.out.println(totalRecords.getText());

							String[] parts = totalRecords.getText().split(" ");

							String lastWord = parts[parts.length - 1];

							System.out.println(lastWord);

							System.out.println("There are " + lastWord + " results are found for the selected Filters");

							log.info("There are " + lastWord + " results are found for the selected Filters");

						}

					} else {

						log.info("Advanced Search is not displayed");

					}

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

						System.out.println("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	@Then("^verify search terms on Research Screen$")

	public void verifySearchTermsOnResearchScreen() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("RESEARCH")) {

						Thread.sleep(4000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String compName = prop.getProperty("ResearchScreenCompanyName");

			String startDate = prop.getProperty("ResearchScreenStartDate");

			String endDate = prop.getProperty("ResearchScreenEndDate");

			items.add(startDate);

			items.add(compName);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.resDate().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					// items.removeIf(Objects::isNull);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					buildListSearchResultPage.resDate().click();

					buildListSearchResultPage.resStartDate().clear();

					buildListSearchResultPage.resStartDate().sendKeys(startDate);

					buildListSearchResultPage.resEndDate().clear();

					buildListSearchResultPage.resEndDate().sendKeys(endDate);

					// buildListSearchResultPage.officerName().sendKeys(officer);

					buildListSearchResultPage.resApplyBtn().click();

					System.out.println("5678");

					buildListSearchResultPage.rescompCompanyName().sendKeys(compName);

					List<WebElement> ele = driver

							.findElements(By.xpath("//ul[contains(@class,'autosuggest__option_list')]/li"));

					for (WebElement e1 : ele) {

						e1.click();

						break;

					}

					System.out.println("5678");

					builder.sendKeys(Keys.TAB);

					driver.findElement(By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

							.click();

					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'filter-title-name')

					// and contains(text(),'FILTERS')]/following-sibling::span")));

					// Thread.sleep(8000);

					String filterCount = buildListSearchResultPage.resFilterCount().getText();

					String resFilterInString = filterCount.replaceAll("\\p{P}", "");

					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

					Thread.sleep(4000);

					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	@Then("^verify search terms on Companies Screen$")

	public void verifySearchTermsOnCompaniesScreen() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("COMPANIES")) {

						Thread.sleep(4000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String principalActivity = prop.getProperty("PrincipalActivity");

			String brand = prop.getProperty("Brand/Agency");

			// String endDate = prop.getProperty("ResearchScreenEndDate");

			items.add(principalActivity);

			items.add(brand);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					// items.removeIf(Objects::isNull);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					buildListSearchResultPage.advancedSearchText().click();

					buildListSearchResultPage.principalActivity().sendKeys(principalActivity);

					builder.sendKeys(Keys.ENTER);

					buildListSearchResultPage.brandOrAgency().sendKeys(brand);

					builder.sendKeys(Keys.ENTER);

					System.out.println("5678");

					builder.sendKeys(Keys.TAB);

					driver.findElement(By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

							.click();

					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'filter-title-name')

					// and contains(text(),'FILTERS')]/following-sibling::span")));

					// Thread.sleep(8000);

					Thread.sleep(5000);

					String filterCount = buildListSearchResultPage.resFilterCount().getText();

					String resFilterInString = filterCount.replaceAll("\\p{P}", "");

					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

					Thread.sleep(4000);

					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	@Then("^verify filter By Date on Research Screen$")

	public void verifyFilterByDate() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("RESEARCH")) {

						Thread.sleep(4000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			// String compName = prop.getProperty("ResearchScreenCompanyName");

			String startDate = prop.getProperty("ResearchScreenStartDate");

			String endDate = prop.getProperty("ResearchScreenEndDate");

			items.add(startDate);

			// items.add(compName);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.resDate().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					// items.removeIf(Objects::isNull);

					log.info("Selected(Paased Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					buildListSearchResultPage.resDate().click();

					buildListSearchResultPage.resStartDate().clear();

					buildListSearchResultPage.resStartDate().sendKeys(startDate);

					buildListSearchResultPage.resEndDate().clear();

					buildListSearchResultPage.resEndDate().sendKeys(endDate);

					// buildListSearchResultPage.officerName().sendKeys(officer);

					buildListSearchResultPage.resApplyBtn().click();

					System.out.println("5678");

					driver.findElement(By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

							.click();

					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'filter-title-name')

					// and contains(text(),'FILTERS')]/following-sibling::span")));

					// Thread.sleep(8000);

					String filterCount = buildListSearchResultPage.resFilterCount().getText();

					String resFilterInString = filterCount.replaceAll("\\p{P}", "");

					log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

					Thread.sleep(4000);

					assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

					if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

							.isDisplayed()) {

						log.info("No Results found for the selected Fliter criteria");

						System.out.println("No Results found for the selected Fliter criteria");

					} else {

						/*
						 * List<WebElement> tableData =
						 * driver.findElements(By.xpath("//div/news-list-item"));
						 * 
						 * for (WebElement td : tableData) {
						 * 
						 * System.out.println(
						 * 
						 * "There are " + tableData.size() +
						 * " results are found for the selected Filters");
						 * 
						 * log.info("There are " + tableData.size() +
						 * " results are found for the selected Filters");
						 * 
						 * break;
						 * 
						 * }
						 */

						WebElement totalRecords = driver.findElement(By.xpath(

								"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[4]/report-screener/div/screener-page-header/div/div[2]/div[1]"));

						System.out.println(totalRecords.getText());

						String[] parts = totalRecords.getText().split(" ");

						String lastWord = parts[parts.length - 1];

						System.out.println(lastWord);

						System.out.println("There are " + lastWord + " results are found for the selected Filters");

						log.info("There are " + lastWord + " results are found for the selected Filters");

					}

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	@Then("^verify filter By Company on Research Screen$")

	public void verifyFilterByCompany() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		try {

			if (buildListSearchResultPage.isScreenDisplayed()

					&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

				log.info("Build List Search Result Page is displayed");

				WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

				List<WebElement> allData = table.findElements(By.tagName("li"));

				System.out.println(allData.size());

				loop: for (WebElement row : allData) {

					List<WebElement> cells = row.findElements(By.xpath(

							"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

					wait.until(ExpectedConditions.visibilityOfAllElements(cells));

					for (WebElement cell : cells) {

						if (cell.getText().equalsIgnoreCase("RESEARCH")) {

							Thread.sleep(4000);

							cell.click();

							System.out.println("content >>   " + cell.getText());

							String str = cell.getText();

							String resStr = firstLetterCaps(str);

							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

									"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

											+ resStr + "')]")));

							Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

									"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

											+ resStr + "')]"))

									.isDisplayed());

							break loop;

						}

					}

				}

				getpropertiesValues();

				List<String> items = new ArrayList<String>();

				String compName = prop.getProperty("ResearchScreenCompanyName");

				// String startDate = prop.getProperty("ResearchScreenStartDate");

				// String endDate = prop.getProperty("ResearchScreenEndDate");

				// items.add(startDate);

				items.add(compName);

				items.removeAll(Arrays.asList("", null));

				if (buildListSearchResultPage.resDate().isDisplayed()) {

					if (items.size() != 0 || !items.isEmpty()) {

						Actions builder = new Actions(driver);

						// items.removeIf(Objects::isNull);

						log.info("Selected(Paased Input) Filter Size is:" + items.size());

						System.out.println("The List Size is :" + items.size());

						// =============================

						buildListSearchResultPage.rescompCompanyName().sendKeys(compName);

						// try {

						if (driver.findElement(By.xpath(

								"//div[@class='autosuggest__dropdown_menu']//span[contains(text(),'No matches found.')]"))

								.isDisplayed()) {

							System.out.println(

									"No Matches found for the inputted Company,Hence terminating from the testcase");

							Assert.assertTrue("No Matches found for the Selected Company", driver.findElement(By.xpath(

									"//div[@class='autosuggest__dropdown_menu']//span[contains(text(),'No matches found1.')]"))

									.isDisplayed());

							// Assert.assertTrue("No Matches found for the Selected Company",false);

						}

						else {

							List<WebElement> ele = driver

									.findElements(By.xpath("//ul[contains(@class,'autosuggest__option_list')]/li"));

							for (WebElement e1 : ele) {

								if (e1.getText().contains(compName)) {

									e1.click();

									break;

								}

							}

						}

						System.out.println("5678");

						builder.sendKeys(Keys.TAB);

						System.out.println("5678");

						driver.findElement(

								By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

								.click();

						// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'filter-title-name')

						// and contains(text(),'FILTERS')]/following-sibling::span")));

						// Thread.sleep(8000);

						String filterCount = buildListSearchResultPage.resFilterCount().getText();

						String resFilterInString = filterCount.replaceAll("\\p{P}", "");

						log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

						Thread.sleep(4000);

						assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

						if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

								.isDisplayed()) {

							log.info("No Search Results found for the selected Fliter criteria");

							System.out.println("No Search Results found for the selected Fliter criteria");

						} else {

							/*
							 * List<WebElement> tableData =
							 * driver.findElements(By.xpath("//div/news-list-item"));
							 * 
							 * for (WebElement td : tableData) {
							 * 
							 * System.out.println("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * log.info("There are " + tableData.size()
							 * 
							 * + " results are found for the selected Filters");
							 * 
							 * break;
							 * 
							 * }
							 */

							WebElement totalRecords = driver.findElement(By.xpath(

									"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[4]/report-screener/div/screener-page-header/div/div[2]/div[1]"));

							System.out.println(totalRecords.getText());

							String[] parts = totalRecords.getText().split(" ");

							String lastWord = parts[parts.length - 1];

							System.out.println(lastWord);

							System.out.println("There are " + lastWord + " results are found for the selected Filters");

							log.info("There are " + lastWord + " results are found for the selected Filters");

						}

					} else {

						String filterCount = driver.findElement(By.xpath(

								"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

								.getText();

						String resFilter = filterCount.replaceAll("\\p{P}", "");

						int ss = Integer.parseInt(resFilter);

						if (ss == 0) {

							log.info("No Filters are selected");

						}

					}

				} else {

					ApplicationHelper.takeScreenShot();

					Assert.assertTrue("Build List Search Result Page is not displayed", false);

				}

			} else {

				ApplicationHelper.takeScreenShot();

				Assert.assertTrue("Build List Search Result Page is not displayed", false);

			}

		} catch (Exception e) {

			System.out.println("haiiiiii");

		}

	}

	@Then("^verify filter By Ownership Type on Company Screen$")

	public void verifyFilterByOwnerShipType() throws InterruptedException, IOException {

		wait.until(

				ExpectedConditions.textToBePresentInElement(buildListSearchResultPage.selectedTabtext(), "Companies"));

		if (buildListSearchResultPage.isScreenDisplayed()

				&& buildListSearchResultPage.selectedTabtext().getText().equalsIgnoreCase("Companies")) {

			log.info("Build List Search Result Page is displayed");

			WebElement table = driver.findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]"));

			List<WebElement> allData = table.findElements(By.tagName("li"));

			System.out.println(allData.size());

			loop: for (WebElement row : allData) {

				List<WebElement> cells = row.findElements(By.xpath(

						"//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Landing_Search_')]"));

				wait.until(ExpectedConditions.visibilityOfAllElements(cells));

				for (WebElement cell : cells) {

					if (cell.getText().equalsIgnoreCase("COMPANIES")) {

						Thread.sleep(6000);

						cell.click();

						System.out.println("content >>   " + cell.getText());

						String str = cell.getText();

						String resStr = firstLetterCaps(str);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]")));

						Assert.assertTrue(resStr + " tab is not displayed", driver.findElement(By.xpath(

								"//div[contains(@class,'global-search-results-tab-title')]/div/span[contains(text(),'"

										+ resStr + "')]"))

								.isDisplayed());

						break loop;

					}

				}

			}

			getpropertiesValues();

			List<String> items = new ArrayList<String>();

			String companyName = prop.getProperty("OwnershipType");

			items.add(companyName);

			items.removeAll(Arrays.asList("", null));

			if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

				if (items.size() != 0 || !items.isEmpty()) {

					Actions builder = new Actions(driver);

					log.info("Selected(Passed Input) Filter Size is:" + items.size());

					System.out.println("The List Size is :" + items.size());

					// =============================

					log.info("Before");

					if (buildListSearchResultPage.advancedSearchText().isDisplayed()) {

						buildListSearchResultPage.advancedSearchText().click();

						buildListSearchResultPage.compCompanyName().sendKeys(companyName);

						builder.sendKeys(Keys.ENTER);

						driver.findElement(

								By.xpath("//div[contains(@class,'user-panel-account hide-user-panel-account')]"))

								.click();

						String filterCount = buildListSearchResultPage.resFilterCount().getText();

						String resFilterInString = filterCount.replaceAll("\\p{P}", "");

						log.info("Displaying Filter Counter is :" + Integer.parseInt(resFilterInString));

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

						Thread.sleep(4000);

						assertEquals("Filter Counts are Not equal", Integer.parseInt(resFilterInString), items.size());

						List<WebElement> filterNames = driver

								.findElements(By.xpath("//div[contains(@class,'filter-list-tag-content')]/span"));

						for (WebElement selectedFilters : filterNames) {

							log.info(selectedFilters.getText());

							System.out.println(selectedFilters.getText());

						}

						if (driver.findElement(By.xpath("//div[contains(@translate,'res_noScreenerDataTitle')]"))

								.isDisplayed()) {

							log.info("No Results found for the selected Fliter criteria");

							System.out.println("No Results found for the selected Fliter criteria");

						} else {

							WebElement totalRecords = driver.findElement(By.xpath(

									"//*[@id=\"searchLandingTopHeader\"]/div[2]/div/div[2]/div[1]/companies-screener/div/div/screener-page-header/div/div[2]/div"));

							System.out.println(totalRecords.getText());

							String[] parts = totalRecords.getText().split(" ");

							String lastWord = parts[parts.length - 1];

							System.out.println(lastWord);

							System.out.println("There are " + lastWord + " results are found for the selected Filters");

							log.info("There are " + lastWord + " results are found for the selected Filters");

						}

					} else {

						log.info("Advanced Search is not displayed");

					}

				} else {

					String filterCount = driver.findElement(By.xpath(

							"//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span"))

							.getText();

					String resFilter = filterCount.replaceAll("\\p{P}", "");

					int ss = Integer.parseInt(resFilter);

					if (ss == 0) {

						log.info("No Filters are selected");

						System.out.println("No Filters are selected");

					}

				}

			}

		} else {

			ApplicationHelper.takeScreenShot();

			Assert.assertTrue("Build List Search Result Page is not displayed", false);

		}

	}

	public static String firstLetterCaps(String data) {

		{

			String firstLetter = data.substring(0, 1).toUpperCase();

			String restLetters = data.substring(1).toLowerCase();

			return firstLetter + restLetters;
		}

		}
		
		@When("^I navigated to officer tab$")
		public void i_navigated_to_officer_tab() throws Throwable {
			Thread.sleep(4000);
			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(buildListSearchResultPage.officerTab));
			Thread.sleep(4000);
			buildListSearchResultPage.officerTab().click();
		   
		}

	}
