package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Base{

	@Before
	public void ss() {
  System.out.println("Calling inside the Before Hooks");
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		System.out.println("Calling After the Before Hooks");
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			}
		}
		//tearDownDriver();
	}
	
	
	public void tearDownDriver()
	{
		driver.quit();
		System.out.println("Driver is terminated");
	}
}
