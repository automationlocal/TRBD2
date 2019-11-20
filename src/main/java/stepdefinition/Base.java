package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;




public class Base {
	public static WebDriver driver;
	public Properties prop;
	//WebDriverWait wt = new WebDriverWait(driver, 30);
	
	public static final String USERNAME = "VinayBhat123";
	public static final String ACCESS_KEY = "7fa2c521-2e22-459d-bedf-79593b6d6d2d";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	public String Environment ="Client";
	public String features="Regression and Sanity";

	public WebDriver initializeDriver() throws IOException {
		/*prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\UX015797\\Desktop\\Zawya Codes\\My Workspace_Proper_05 Aug\\Automation (1)\\Automation\\src\\main\\resources\\Data.properties");	

		prop.load(fis);*/
		getpropertiesValues();
		String browser = prop.getProperty("browser");
		
		
		/*DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL("http://10.25.48.153:4444/wd/hub"),dc);//provide the path,where HUB is listening
		driver.manage().window().maximize();*/

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\UX012817\\Automation_Sep\\Automation_Sep\\Automation\\drivers\\chromedriver.exe");
			
			//For Saucelab Execution
			/*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 7");
			caps.setCapability("version", "51.0");
			driver=new RemoteWebDriver(new java.net.URL(URL), caps);*/
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\UX015797\\Documents\\Lib required\\IEDriverServer_x64_3.14.0 (1)\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					"C:\\Users\\UX015797\\Documents\\Lib required\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	protected Object getpropertiesValues() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Data.properties");
		prop.load(fis);
		
		return prop;
		
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
 
		// TODO Auto-generated method stub
		
	}	
		
		
	}

