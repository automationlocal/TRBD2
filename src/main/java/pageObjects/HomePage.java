package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cucumber.Helper.LoggerHelper;

public class HomePage {
	private static Logger log = LoggerHelper.getLogger(HomePage.class);
	public WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 40);
	By title = By.xpath("//img[contains(@alt,'Thompson Reuters logo')]");
	
	By textDashBoard=By.xpath("//span[contains(text(),'Dashboard')]");
	By defaultSeletedTabDashboard=By.xpath("//ul[contains(@class,'user-panel-account-block')]//li[contains(@class,'user-panel-account-block-item active')]//span[contains(text(),'Dashboard')]");
	By textMyAccnt=By.xpath("//span[contains(text(),'My Account')]");
	By textMySettings=By.xpath("//span[contains(text(),'My Settings')]");
	By textLogout=By.xpath("//span[contains(text(),'Logout')]");
	By selectRegion=By.xpath("//div[contains(@id,'globalCountryGlobalSelectFilterWrapper')]//input");
	By selectDefaultValueForRegion=By.xpath("//div[contains(@class,'dropdown-global-menu')]//label[contains(text(),'MENA')]");
	By selectSector=By.xpath("//div[contains(@id,'globalSectorSubsectorGlobalSelectFilterWrapper')]//input");
	By selectDefaultValueForSector=By.xpath("//div[contains(@id,'globalSectorSubsectorGlobalSelectFilterWrapper')]/div[2]//label[contains(text(),'All')]");
	By btnBuildList=By.xpath("//button[contains(@class,'global-search-panel__build-list-button') and contains(text(),'Build List')]");		
			
			
	By chartData=By.xpath("(//div/comparison-donut-chart[contains(@model,'$ctrl.chartData')])[1]");
	By countryRelatedNewsSection=By.xpath("//div[contains(text(),'Country Related News')]");
	By lisTrackerSection=By.xpath("//div[contains(text(),'List Tracker:')]");
	By myResearchReportsSection=By.xpath("//div[contains(text(),'My Research Reports')]");
	By mySavedSearchesandListsSection=By.xpath("//div[contains(text(),'My Saved Searches and Lists')]");
	By recommendedSection=By.xpath("//div[contains(text(),'Recommended Searches')]");
	By searchKeyword=By.xpath("//*[@class='search-group']/input");
	
	By pieChart=By.xpath("//comparison-donut-chart[contains(@model,'$ctrl.chartData')]");
	
	// This is a constructor for initialising the driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement dashboardTab() {
		return driver.findElement(textDashBoard);
	}
	public WebElement defaultSelectedDashboardTab() {
		return driver.findElement(defaultSeletedTabDashboard);
	}
	public WebElement myAccountTab() {
		return driver.findElement(textMyAccnt);
	}
	public WebElement mySettingsTab() {
		return driver.findElement(textMySettings);
	}
	public WebElement logoutButton() {
		return driver.findElement(textLogout);
	}
	public WebElement selectRegion() {
		return driver.findElement(selectRegion);
	}
	public WebElement selectDefaultValueForRegion() {
		return driver.findElement(selectDefaultValueForRegion);
	}
	public WebElement selectSector() {
		return driver.findElement(selectSector);
	}
	public WebElement selectDefaultValueForSector() {
		return driver.findElement(selectDefaultValueForSector);
	}
	public WebElement btnBuildList() {
		return driver.findElement(btnBuildList);
	}	
	
	public WebElement chartData() {
		return driver.findElement(chartData);
	}
	public WebElement countryRelatedNewsSection() {
		return driver.findElement(countryRelatedNewsSection);
	}
	public WebElement lisTrackerSection() {
		return driver.findElement(lisTrackerSection);
	}
	public WebElement myResearchReportsSection() {
		return driver.findElement(myResearchReportsSection);
	}
	public WebElement mySavedSearchesandListsSection() {
		return driver.findElement(mySavedSearchesandListsSection);
	}
	public WebElement recommendedSection() {
		return driver.findElement(recommendedSection);
	}
	
	public WebElement searchKeyword() {
		return driver.findElement(searchKeyword);
	}
	
	public WebElement pieChart() {
		return driver.findElement(pieChart);
	}
	
   public boolean isScreenDisplayed() {
		
		boolean isDisplayed = false;
		try {
			Thread.sleep(6000);
			if(dashboardTab().isDisplayed() && myAccountTab().isDisplayed() && defaultSelectedDashboardTab().isDisplayed()
					&& mySettingsTab().isDisplayed() && logoutButton().isDisplayed())
			{
				isDisplayed = true;
				log.info("HomePage is Loaded");
			}
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in Homepage");
		}
		return isDisplayed;
	}
   
   public boolean verifyMainPillars() {

		boolean isDisplayed = false;
		try {
			if (dashboardTab().isDisplayed() && myAccountTab().isDisplayed()
					&& mySettingsTab().isDisplayed() && logoutButton().isDisplayed()) {
				isDisplayed = true;
				log.info("All four Tabs(Dashboard,My Account,My Settings and Logout) are displayed as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in verifyMainPillars method in HomePage");
		}
		return isDisplayed;
	}
   
   public boolean verifyDifferentScetions() {

 		boolean isDisplayed = false;
 		try {
 			if (countryRelatedNewsSection().isDisplayed() && lisTrackerSection().isDisplayed()
 					&& myResearchReportsSection().isDisplayed() && mySavedSearchesandListsSection().isDisplayed()
 					&& recommendedSection().isDisplayed()) {
 				verifyCustomizedChart();
 				isDisplayed = true;
 				log.info("All Sections(Country Related,List Tracker,My Research Report,My Saved Search List and Recommended) are displayed as expected in Home Page");
 			}
 		} catch (Exception ex) {
 			log.info("Exception in verifyDifferentScetions method in HomePage");
 		}
 		return isDisplayed;
 	}
   
	public void verifyCustomizedChart() throws InterruptedException {
		WebElement table = driver.findElement(By.xpath("(//ul[contains(@class,'nav nav-tabs')])[1]"));
		List<WebElement> allData = table.findElements(By.tagName("li"));

		System.out.println(allData.size());
		for (WebElement row : allData) {
			List<WebElement> cells = row.findElements(By.xpath(
					"//div[contains(@class,'dashboard-container__widget-container')]/companies-and-officers-widget[contains(@id,'0')]//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(@translate,'res_Companies')]"));
			// wait.until(ExpectedConditions.visibilityOfAllElements(cells));
			Thread.sleep(3000);
			for (WebElement cell : cells) {
				// if (!cell.getText().equalsIgnoreCase("COMPANIES")) {
				Thread.sleep(3000);
				// WebDriverWait wait = new WebDriverWait(driver, 40);
				// wait.until(ExpectedConditions.visibilityOf(cell));
				cell.click();
				log.info("Clicked on " + cell.getText() + " Tab");
				if (pieChart().isDisplayed()) {
					log.info("Pie Chart data is Displayed as expected under " + cell.getText() + " Tab");
				}
				// }
				// log.info(cell.getText() + " Tab is displayed as expected");
				System.out.println(cell.getText() + " Tab is displayed as expected");
				System.out.println("content >>>   " + cell.getText());
				String str = cell.getText();

			}
			break;

		}
	}

}
