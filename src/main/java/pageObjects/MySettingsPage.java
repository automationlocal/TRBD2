package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.Helper.LoggerHelper;


public class MySettingsPage {
	private static Logger log = LoggerHelper.getLogger(MySettingsPage.class);
	public WebDriver driver;
	
	
	HomePage homepage;
	By title = By.xpath("//img[contains(@alt,'Thompson Reuters logo')]");
	
	By defaultSeletedTabMySettings=By.xpath("//ul[contains(@class,'user-panel-account-block')]//li[contains(@class,'user-panel-account-block-item active')]//span[contains(text(),'My Settings')]");
	
	By savedList=By.xpath("//span[contains(text(),'Saved Lists')]");
	By emailNotification=By.xpath("//span[contains(text(),'Email Notifications')]");
	By dashBoardPref=By.xpath("//span[contains(text(),'Dashboard Preferences')]");
	By resetPswd=By.xpath("//span[contains(text(),'Reset Password')]");

	// This is a constructor for initialising the driver
	public MySettingsPage(WebDriver driver) {
		this.driver = driver;
		//homepage=new HomePage(driver);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement defaultSelectedDashboardTab() {
		return driver.findElement(defaultSeletedTabMySettings);
	}
	
	public WebElement savedList() {
		return driver.findElement(savedList);
	}
	public WebElement emailNotification() {
		return driver.findElement(emailNotification);
	}
	public WebElement dashboardPref() {
		return driver.findElement(dashBoardPref);
	}
	public WebElement resetPassword() {
		return driver.findElement(resetPswd);
	}
	
	
	
public boolean isScreenDisplayed() {
		
		boolean isDisplayed = false;
		WebDriverWait wt=new WebDriverWait(driver, 30);
		try {
			Thread.sleep(2000);
			wt.until(ExpectedConditions.visibilityOf(emailNotification()));
			if(defaultSelectedDashboardTab().isDisplayed() && emailNotification().isDisplayed() &&
					 dashboardPref().isDisplayed() && resetPassword().isDisplayed())
			{
				isDisplayed = true;
				log.info("My Settings Page is displayed as expected");
				log.info("User can able to see Filter Bar,Email Notification,Dashboard Preference and Reset Password option in My Settings Page");
			}
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in My Settings Page");
		}
		return isDisplayed;
	}

}
