package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import com.cucumber.Helper.LoggerHelper;

public class BuildListSearchResultPage {
	private static Logger log = LoggerHelper.getLogger(BuildListSearchResultPage.class);
	public WebDriver driver;
	BuildListSearchResultPage buildListSearchResultPage;
	
	By defaultFourTabs=By.xpath("//ul[contains(@class,'nav nav-tabs')]");	
	By activeTab=By.xpath("//ul[contains(@class,'nav nav-tabs')]/li[contains(@class,'active')]");	
    By selectedTabtext=By.xpath("//span[contains(@ng-bind,'$ctrl.pageName')]");
    By firstTabName=By.xpath("//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(text(),'Companies')]");
    By firstTabCount=By.xpath("//i[contains(@ng-show,'item.iconClassName')]/following-sibling::span[contains(text(),'Companies')]/following-sibling::span[contains(@class,'count')]");
	By searchTable=By.xpath("//table[contains(@class,'result-grid result-grid_frozen')]");
    //Left side Fields
    By filterResults=By.xpath("(//span[contains(text(),'Filter results')])[1]");
    By ownershipType=By.xpath("(//span[contains(text(),'Ownership Type')])[1]");
    By companySize=By.xpath("(//span[contains(text(),'Company Size')])[1]");
    By revenueRange=By.xpath("(//span[contains(text(),'Revenue range')])[1]");
    By contactDetails=By.xpath("(//span[contains(text(),'Contact Details')])[1]");
    By yearsEstd=By.xpath("(//span[contains(text(),'Years Established')])[1]");
    By showCompanies=By.xpath("//span[contains(@class,'filter-item__name') and contains(text(),'Show companies')]");
    By advancedSearch=By.xpath("(//span[contains(text(),'Advanced search')])[1]");
    By clearFilters=By.xpath("(//span[contains(text(),'CLEAR FILTERS')])[1]");
    
  
    //Right side Fields
    By saveSearchbtn=By.xpath("//span[contains(text(),'SAVE SEARCH')]");
    By exportBtn=By.xpath("//span[contains(text(),'EXPORT')]");
    
    By advancedSearchText=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Advanced search')]");
    By firstname=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'First Name')]/../following-sibling::div/input");
    By familyName=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Family Name')]/..//following-sibling::render-filters-controls/div/div[2]/input");
    By companyName=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Company name is')]/..//following-sibling::div[contains(@class,'aditional-input-container_main_multi_input')]/input");
    By resFilterCount=By.xpath("//span[contains(@class,'filter-title-name') and contains(text(),'FILTERS')]/following-sibling::span");
    
    By date=By.xpath("(//input[contains(@class,'filters-daterange__input')])[1]");
    By startDate=By.xpath("(//input[contains(@name,'daterangepicker_start')])[1]");
    By endDate=By.xpath("(//input[contains(@name,'daterangepicker_end')])[1]");
    By applyBtn=By.xpath("//button[contains(text(),'Apply')]");
    By officerName=By.xpath("//*[@id=\"filters-template\"]/div/div[1]/ul/li[3]/div[2]/div/render-filters-controls/div/div[2]/input");
    public By officerTab=By.xpath("//ul[@class='nav nav-tabs']/li[2]/a");
    
    By advancedSearchMinus=By.xpath("//span[contains(text(),'Advanced search')]/..//following-sibling::span[contains(@class,'filters-search-button-icon filters-search-button-icon-minus')]");
    By advancedSearchPlus=By.xpath("(//span[contains(text(),'Advanced search')]/..//following-sibling::span[contains(@class,'filters-search-button-icon filters-search-button-icon-plus')])[2]");
	By selectedFilterNames=By.xpath("//div[contains(@class,'filter-list-tag-content')]/span");
	
	By principalActivity=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Principal Activity')]/..//following-sibling::div/div/render-filters-controls//input[contains(@placeholder,'Search Keyword')]");
	By brandOrAgency=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Brand / Agency')]/..//following-sibling::div/div/render-filters-controls//input[contains(@placeholder,'Search Keyword')]");
	By compCompanyName=By.xpath("//filters-panel[not(contains(@class,'ng-hide'))]//span[contains(text(),'Company Name')]/..//following-sibling::div/div/render-filters-controls//input[contains(@placeholder,'Search Keyword')]");
    
	//Reserach Screen
	By rescompCompanyName=By.xpath("(//*[@id=\"filters-template\"]/div/div[1]/ul/li[2]/div[2]/div/render-filters-controls/filters-autosuggest/input-autosuggest/div/div[1]/input)[2]");
	By resDate=By.xpath("(//input[contains(@class,'filters-daterange__input')])[2]");
    By resStartDate=By.xpath("(//input[contains(@name,'daterangepicker_start')])[2]");
    By resEndDate=By.xpath("(//input[contains(@name,'daterangepicker_end')])[2]");
    By resApplyBtn=By.xpath("(//button[contains(text(),'Apply')])[2]");
    
    
	// This is a constructor for initialising the driver
	public BuildListSearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement defaultFourTabs() {
		return driver.findElement(defaultFourTabs);
	}	
	
	public WebElement activeTab() {
		return driver.findElement(activeTab);
	}
	public WebElement selectedTabtext() {
		return driver.findElement(selectedTabtext);
	}
	public WebElement firstTabName() {
		return driver.findElement(firstTabName);
	}
	public WebElement firstTabCount() {
		return driver.findElement(firstTabCount);
	}	
	
	public WebElement filterResults() {
		return driver.findElement(filterResults);
	}
	public WebElement ownershipType() {
		return driver.findElement(ownershipType);
	}
	public WebElement officerTab() {
		return driver.findElement(officerTab);
	}
	public WebElement companySize() {
		return driver.findElement(companySize);
	}
	public WebElement revenueRange() {
		return driver.findElement(revenueRange);
	}
	public WebElement contactDetails() {
		return driver.findElement(contactDetails);
	}
	public WebElement yearsEstd() {
		return driver.findElement(yearsEstd);
	}
	public WebElement showCompanies() {
		return driver.findElement(showCompanies);
	}
	public WebElement advancedSearch() {
		return driver.findElement(advancedSearch);
	}
	public WebElement clearFilters() {
		return driver.findElement(clearFilters);
	}
		
    public WebElement saveSearchbtn() {
		return driver.findElement(saveSearchbtn);
	}
    public WebElement exportBtn() {
		return driver.findElement(exportBtn);
	}
    public WebElement searchTable() {
		return driver.findElement(searchTable);
	}
    public WebElement advancedSearchText() {
		return driver.findElement(advancedSearchText);
	}
	public WebElement firstname() {
		return driver.findElement(firstname);
	}
	public WebElement familyName() {
		return driver.findElement(familyName);
	}
	public WebElement companyName() {
		return driver.findElement(companyName);
	}
	public WebElement resFilterCount() {
		return driver.findElement(resFilterCount);
	}
    
	public WebElement date() {
		return driver.findElement(date);
	}
	public WebElement startDate() {
		return driver.findElement(startDate);
	}
	public WebElement endDate() {
		return driver.findElement(endDate);
	}

	public WebElement applyBtn() {
		return driver.findElement(applyBtn);
	}
	public WebElement officerName() {
		return driver.findElement(officerName);
	}
	public WebElement advancedSearchMinus() {
		return driver.findElement(advancedSearchMinus);
	}
	public WebElement advancedSearchPlus() {
		return driver.findElement(advancedSearchPlus);
	}
	public WebElement selectedFilterNames() {
		return driver.findElement(selectedFilterNames);
	}
	
	public WebElement principalActivity() {
		return driver.findElement(principalActivity);
	}
	public WebElement brandOrAgency() {
		return driver.findElement(brandOrAgency);
	}	
	public WebElement compCompanyName() {
		return driver.findElement(compCompanyName);
	}
	public WebElement rescompCompanyName() {
		return driver.findElement(rescompCompanyName);
	}
	public WebElement resDate() {
		return driver.findElement(resDate);
	}
	public WebElement resStartDate() {
		return driver.findElement(resStartDate);
	}
	public WebElement resEndDate() {
		return driver.findElement(resEndDate);
	}
	public WebElement resApplyBtn() {
		return driver.findElement(resApplyBtn);
	}
	
public boolean verifyContentsOnLeftSide() {

		boolean isDisplayed = false;
		try {
			if (filterResults().isDisplayed() && ownershipType().isDisplayed() && companySize().isDisplayed()
					&& revenueRange().isDisplayed() && contactDetails().isDisplayed() && yearsEstd().isDisplayed()
					&& showCompanies().isDisplayed() && advancedSearch().isDisplayed() && clearFilters().isDisplayed()) {
				isDisplayed = true;
				log.info("Build List Search Page is Displayed with following fields:Filter Results,Ownership Type,"
						+ "Company Size,Revenue Range,Contact Details,Years Estd.,Show Companies,Adavanced Search and Clear Filters as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in Build List Search Result Page");
		}
		return isDisplayed;
	}
	
	public boolean isScreenDisplayed() {

		boolean isDisplayed = false;
		try {
			if (defaultFourTabs().isDisplayed() && activeTab().isDisplayed()) {
				isDisplayed = true;
				log.info("Build List Search Page is Displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in Build List Search Result Page");
		}
		return isDisplayed;
	}	
	
	public boolean verifyContentsOnRightSide() {

		boolean isDisplayed = false;
		try {
			if (saveSearchbtn().isDisplayed() && exportBtn().isDisplayed()) {
				isDisplayed = true;
				log.info("Build List Search Page is Displayed with the expected fields Save Search and Export button on Right Side");
			}
		} catch (Exception ex) {
			log.info("Exception in verifyContentsOnRightSide method in Build List Search Result Page");
		}
		return isDisplayed;
	}

}
