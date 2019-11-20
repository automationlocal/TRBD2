package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.Helper.ApplicationHelper;
import com.cucumber.Helper.LoggerHelper;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class LoginPage {
	private static Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	public WebDriver driver;
	By username = By.xpath("//input[contains(@name,'username')]");
	By storedUserName=By.xpath("//input[contains(@id,'username') and contains(@class,'form-control ng-pristine ng-untouched ng-valid ng-not-empty')]");
	By emptyUserName=By.xpath("//input[contains(@class,'form-control ng-valid ng-touched ng-dirty ng-valid-parse ng-empty')]");
	By password = By.xpath("//input[contains(@name,'password')]");
	By signIn = By.xpath("//button[contains(text(),'Sign In')]");
	By title = By.xpath("//img[contains(@alt,'Thompson Reuters logo')]");
	By invalidUsernameAndPswdMsg=By.xpath("//span[contains(text(),\"The Username or Password is incorrect. Please try again.\")]");
	
	By anotherSession=By.xpath("//span[contains(text(),'You are already logged in another session.')]");
    By signAnywayButton=By.xpath("//button[contains(text(),'Sign in anyway')]");
    By rememberMeChkbox=By.xpath("//input[contains(@ng-model,'vm.rememberMe')]");
    
    By cookiePolicyElement=By.xpath("//a[contains(text(),'Cookie Policy')]");
    By privacyStatementElement=By.xpath("//a[contains(text(),'Privacy Statement')]");
    By termsOfUseElement=By.xpath("//a[contains(text(),'Terms of Use')]");
    By copyRightElement=By.xpath("//a[contains(text(),'Copyright')]");
    
    By abouttrbdMenaLink=By.xpath("//span[contains(text(),'ABOUT TRBD MENA')]");
    By whySubscribeLink=By.xpath("//span[contains(text(),'WHY SUBSCRIBE')]");
    
    By forgotPswdLink=By.xpath("//span[contains(text(),'Forgotten your password?')]");
    By pswdAssistance=By.xpath("//div[contains(text(),'Password Assistance')]");
    By userId=By.xpath("//input[contains(@name,'userId')]");
    By okBtn=By.xpath("//div[contains(text(),'OK')]");
    By emailSentMsg=By.xpath("//div[contains(text(),' Email sent ')]");         
    
    public WebElement cookiePolicyElement() {
		return driver.findElement(cookiePolicyElement);
	}
    public WebElement privacyStatementElement() {
		return driver.findElement(privacyStatementElement);
	}
    public WebElement termsOfUseElement() {
		return driver.findElement(termsOfUseElement);
	}
    public WebElement copyRightElement() {
		return driver.findElement(copyRightElement);
	}
    public WebElement abouttrbdMenaLink() {
		return driver.findElement(abouttrbdMenaLink);
	}
    public WebElement whySubscribeLink() {
		return driver.findElement(whySubscribeLink);
	}
    
    /*@FindBy(xpath = "//a[contains(text(),'Cookie Policy')]")
    public WebElement cookiePolicyElement;
    
    @FindBy(xpath = "//a[contains(text(),'Privacy Statement')]")
    public WebElement privacyStatementElement;
    
    @FindBy(xpath = "//a[contains(text(),'Terms of Use')]")
    public WebElement termsOfUseElement;
    
    @FindBy(xpath = "//a[contains(text(),'Copyright')]")
    public WebElement copyRightElement;*/
    
    /*@FindBy(xpath = "//b[contains(text(),'Cookies and similar technologies')]")
    public WebElement cookiePolicyHeadlineText;
    
    @FindBy(xpath = "//h1[contains(text(),'Thomson Reuters Privacy Statement')]")
    public WebElement privacyStatementHeadlinetext;
    
    @FindBy(xpath = "//p[contains(text(),'Our Privacy Statement & Cookie Policy')]")
    public WebElement termsOfUseHeadlineText;
    
    @FindBy(xpath = "//h1[contains(text(),'Copyright notice')]")
    public WebElement copyRightHeadlineText;*/
    
    By cookiePolicyHeadlineText=By.xpath("//b[contains(text(),'Cookies and similar technologies')]");
    By privacyStatementHeadlinetext=By.xpath("//h1[contains(text(),'Thomson Reuters Privacy Statement')]");
    By termsOfUseHeadlineText=By.xpath("//p[contains(text(),'Our Privacy Statement & Cookie Policy')]");
    By copyRightHeadlineText=By.xpath("//h1[contains(text(),'Copyright notice')]");
    
    By TRBDHeadlineText=By.xpath("(//span[contains(text(),'Thomson Reuters Business Development MENA')])[1]");
    By whySubscribeHeadlineText=By.xpath("");
    
    public WebElement cookiePolicyHeadlineText() {
		return driver.findElement(cookiePolicyHeadlineText);
	}
    public WebElement privacyStatementHeadlinetext() {
		return driver.findElement(privacyStatementHeadlinetext);
	}
    public WebElement termsOfUseHeadlineText() {
		return driver.findElement(termsOfUseHeadlineText);
	}
    public WebElement copyRightHeadlineText() {
		return driver.findElement(copyRightHeadlineText);
	}
    

	// This is a constructor for initialising the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement clickSignIn() {
		return driver.findElement(signIn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement anotherSessionScreen() {
		return  driver.findElement(anotherSession);
	}
	
	public WebElement invalidUsernameAndPswdMsg() {
		return  driver.findElement(invalidUsernameAndPswdMsg);
	}
	
	public WebElement signInAnyway() {
		return driver.findElement(signAnywayButton);
	}
	
	public WebElement stored() {
		return driver.findElement(rememberMeChkbox);
	}
	public WebElement storedUserName() {
		return driver.findElement(storedUserName);
	}
	public WebElement rememberMeChkbox() {
		return driver.findElement(rememberMeChkbox);
	}
	
	public WebElement TRBDHeadlineText() {
		return driver.findElement(TRBDHeadlineText);
	}
	
	public WebElement forgotPswdLink() {
		return driver.findElement(forgotPswdLink);
	}
    public WebElement pswdAssistance() {
		return driver.findElement(pswdAssistance);
	}
    public WebElement userId() {
		return driver.findElement(userId);
	}
    public WebElement okBtn() {
		return driver.findElement(okBtn);
	}
    public WebElement emailSentMsg() {
		return driver.findElement(emailSentMsg);
	}
	
	public boolean isScreenDisplayed() {

		boolean isDisplayed = false;
		try {
			if (getUsername().isDisplayed() && getPassword().isDisplayed()) {
				isDisplayed = true;
				log.info("Username and Password fields are displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isScreenDisplayed method in LoginScreen");
		}
		return isDisplayed;
	}
	
	public boolean isPasswordAssistanceScreenIsDisplayed() {

		boolean isDisplayed = false;
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			
			if (pswdAssistance().isDisplayed()|| pswdAssistance().isEnabled()) {
				isDisplayed = true;
				log.info("Password Assistance Screen is Displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isPasswordAssistanceScreenIsDisplayed");
		}
		return isDisplayed;
	}
	
	/*public boolean isAlreadyLoggedInAnotherSession()
	{
		boolean isDisplayed = false;
		try {
			if (anotherSessionScreen()) {
				isDisplayed = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception in isAlreadyLoggedInAnotherSession method in LoginScreen");
		}
		return isDisplayed;
	}*/	public boolean isInvalidScreenDisplayed() {
		
		boolean isDisplayed = false;
		try {
			if(invalidUsernameAndPswdMsg().isDisplayed())
			{
				isDisplayed = true;
				ApplicationHelper.takeScreenShot();
				//Assert.assertFalse("Invalid Credentials Entered", invalidUsernameAndPswdMsg().isDisplayed());
				log.info("Invalid Username and Password Alert message is displayed as expected");
				Assert.assertTrue("Invalid Username and Password Alert Message is displayed as expected", invalidUsernameAndPswdMsg().isDisplayed());
			}
		} catch (Exception ex) {
			//log.info("Exception in isInvalidScreenDisplayed");
		}
		return isDisplayed;
	}
	
	public boolean isAbouttrbdLinkAvailable()
	{
		boolean isAbouttrbdLinkAvailable=false;
		try {		
			if (abouttrbdMenaLink().isDisplayed()) {

				isAbouttrbdLinkAvailable = true;
				log.info("About TRBD Hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isAbouttrbdLinkAvailable");
		}
		return isAbouttrbdLinkAvailable;
	}
	
	public boolean isWhySubscribeLinkAvailable()
	{
		boolean isWhySubscribeLinkAvailable=false;
		try {		
			if (whySubscribeLink().isDisplayed()) {

				isWhySubscribeLinkAvailable = true;
				log.info("Why Subscribe Hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isWhySubscribeLinkAvailable");
		}
		return isWhySubscribeLinkAvailable;
	}
	
	public boolean isCookiePolicyAvailable()
	{
		boolean isCookiePolicyAvailable=false;
		try {		
			if (cookiePolicyElement().isDisplayed()) {

				isCookiePolicyAvailable = true;
				log.info("Cookie Policy Hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isCookiePolicyAvailable");
		}
		return isCookiePolicyAvailable;
	}
	public void clickCookiePolicy() {
		try {	
			cookiePolicyElement().click();
			log.info("Clicked on Cookie Policy");
		} catch (Exception ex) {
			log.info("Exception in clickCookiePolicy");
		}

	}
	public void clickAboutTRBDMena() {
		try {	
			abouttrbdMenaLink().click();
			log.info("Clicked on About TRBD Mena Link");
		} catch (Exception ex) {
			log.info("Exception in clickAboutTRBDMena");
		}

	}
	
	public void clickWhySubscribe() {
		try {	
			whySubscribeLink().click();
			log.info("Click on Why Subscribe Link");
		} catch (Exception ex) {
			log.info("Exception in clickAboutTRBDMena");
		}

	}
	public boolean isPrivacyStatementAvailable()
	{
		boolean isPrivacyStatementAvailable=false;
		try {		
			if (privacyStatementElement().isDisplayed()) {

				isPrivacyStatementAvailable = true;
				log.info("Privacy Statement hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isPrivacyStatementAvailable");
		}
		return isPrivacyStatementAvailable;
	}
	public void clickPrivacyStatement() {
		try {	
			privacyStatementElement().click();
			log.info("Clicked on Privacy Statement");
		} catch (Exception ex) {
			log.info("Exception in clickPrivacyStatement");
		}

	}
	public boolean isTermsOfUseAvailable()
	{
		boolean isTermsOfUseAvailable=false;
		try {		
			if (termsOfUseElement().isDisplayed()) {

				isTermsOfUseAvailable = true;
				log.info("Terms Of Use hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isTermsOfUseAvailable");
		}
		return isTermsOfUseAvailable;
	}
	public void clickTermsOfUse() {
		try {	
			termsOfUseElement().click();
			log.info("Clicked on Terms Of Use");
		} catch (Exception ex) {
			log.info("Exception in clickTermsOfUse", ex);
		}

	}
	public boolean isCopyRightAvailable()
	{
		boolean isCopyRightAvailable=false;
		try {		
			if (copyRightElement().isDisplayed()) {

				isCopyRightAvailable = true;
				log.info("Copy Right hyperlink is displayed");
			}
		} catch (Exception ex) {
			log.info("Exception in isCopyRightAvailable");
		}
		return isCopyRightAvailable;
	}
	
	public void clickCopyRight() {
		try {	
			copyRightElement().click();
			log.info("Clicked on Copy Right");
		} catch (Exception ex) {
			log.info("Exception in clickCopyRight");
		}

	}
	public boolean isAboutTRBDPageDisplayed() {
		boolean isDisplayed = false;
		try {
			if(cookiePolicyHeadlineText().isEnabled()) {
				isDisplayed	= true;
			}
		} catch (Exception ex) {
			log.info("Exception in isCookiePolicyDisplayed");
		}
		return isDisplayed;
		
	}
	public boolean isCookiePolicyDisplayed() {
		boolean isDisplayed = false;
		try {
			if(cookiePolicyHeadlineText().isEnabled()) {
				isDisplayed	= true;
				log.info("Cookie Policy Related Page is displayed as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in isCookiePolicyDisplayed");
		}
		return isDisplayed;
		
	}
	
	public boolean isPrivacyStatementDisplayed() {
		boolean isDisplayed = false;
		try {
			if(privacyStatementHeadlinetext().isEnabled()) {
				isDisplayed	= true;
				log.info("Privacy Statement Related Page is displayed as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in isPrivacyStatementDisplayed");
		}
		return isDisplayed;
		
	}
	
	public boolean isTermsOfUseDisplayed() {
		boolean isDisplayed = false;
		try {
			if(termsOfUseHeadlineText().isEnabled()) {
				isDisplayed	= true;
				log.info("Terms Of Use Related Page is displayed as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in isTermsOfUseDisplayed");
		}
		return isDisplayed;
		
	}
	
	public boolean isCopyRightDisplayed() {
		boolean isDisplayed = false;
		try {
			if(copyRightHeadlineText().isEnabled()) {
				isDisplayed	= true;
				log.info("Copy Right Related Page is displayed as expected");
			}
		} catch (Exception ex) {
			log.info("Exception in isCopyRightDisplayed");
		}
		return isDisplayed;
		
	}
	

}
