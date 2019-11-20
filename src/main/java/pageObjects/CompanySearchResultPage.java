package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import com.cucumber.Helper.LoggerHelper;

import stepdefinition.BuildListSearchResultStep;

public class CompanySearchResultPage {
	private static Logger log = LoggerHelper.getLogger(CompanySearchResultPage.class);
	public WebDriver driver;
	CompanySearchResultPage companySearchResultPage;
	BuildListSearchResultStep buildListSearchResultStep;
	
	By companyDetailsSubTitle=By.xpath("//span[contains(text(),'Company Details')]");	
	By profileTitle=By.xpath("//div[contains(@class,'profile__title')]");
	By industryClassifcationText=By.xpath("//span[contains(text(),'Industry Classification')]");
    By shareHolderText=By.xpath("//span[contains(text(),'Shareholder')]");
    By representativeText=By.xpath("//span[contains(text(),'Representatives')]");
    By boardOfDirectorsText=By.xpath("//span[contains(text(),'Board of Directors')]");
    By backToResultsBtn=By.xpath("//span[contains(text(),'Back to results')]");
    By logoutBtn=By.xpath("//span[contains(text(),'Logout')]");
	
	// This is a constructor for initialising the driver
	public CompanySearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement companyDetailsSubTitle() {
		return driver.findElement(companyDetailsSubTitle);
	}
	
	public WebElement profileTitle() {
		return driver.findElement(profileTitle);
	}
	public WebElement industryClassifcationText() {
		return driver.findElement(industryClassifcationText);
	}
	public WebElement shareHolderText() {
		return driver.findElement(shareHolderText);
	}
	public WebElement representativeText() {
		return driver.findElement(representativeText);
	}
	public WebElement boardOfDirectorsText() {
		return driver.findElement(boardOfDirectorsText);
	}
	public WebElement backToResultsBtn() {
		return driver.findElement(backToResultsBtn);
	}
	public WebElement logoutBtn() {
		return driver.findElement(logoutBtn);
	}
	
	
	
	public boolean isScreenDisplayed() {
		String selectedCompanyName=profileTitle().getText();
		String ss=BuildListSearchResultStep.firstRowCompanyNameText;
		
		WebDriverWait wt=new WebDriverWait(driver, 50);
		wt.until(ExpectedConditions.visibilityOf(profileTitle()));
		
		System.out.println(ss);
		boolean isDisplayed = false;
		try {
			if (companyDetailsSubTitle().isDisplayed() && BuildListSearchResultStep.firstRowCompanyNameText.equalsIgnoreCase(selectedCompanyName)) {
				isDisplayed = true;				
			}
		} catch (Exception ex) {
			System.out.println("Exception in isScreenDisplayed method in Company Details Search Result page");
		}
		return isDisplayed;
	}

}
