package cucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests; 

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\features",
		glue="stepdefinition",
		plugin= { "pretty","com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html","json:target/cucumber.json",
				"html:target/selenium-reports"},
		monochrome = true
		

		)

public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Vinay Bhat");
	Reporter.setSystemInfo("Application Name", "Zawya");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "QA");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
