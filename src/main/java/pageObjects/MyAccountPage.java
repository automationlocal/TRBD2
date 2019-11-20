package pageObjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.Helper.LoggerHelper;


public class MyAccountPage {
	private static Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	public WebDriver driver;
	
	
	HomePage homepage;
	By title = By.xpath("(//a[contains(text(),'My Account')])[1]");
	
	
	

	// This is a constructor for initialising the driver
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		//homepage=new HomePage(driver);
	}

	public WebElement myAccountTitle() {
		return driver.findElement(title);
	}
	
	
	
public boolean isScreenDisplayed() {
		
		boolean isDisplayed = false;
		WebDriverWait wt=new WebDriverWait(driver, 30);
		try {
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    log.info("Page is redirected to: "+driver.getCurrentUrl());
			System.out.println("Page is redirected to: "+driver.getCurrentUrl());
			
			if(myAccountTitle().isDisplayed())
			{
				isDisplayed = true;
				log.info("My Account Page is displayed as expected");
			}
			driver.close();
		    driver.switchTo().window(tabs2.get(0));
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in My Settings Page");
		}
		return isDisplayed;
	}

}
