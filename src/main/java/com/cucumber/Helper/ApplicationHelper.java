package com.cucumber.Helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import stepdefinition.ApplicationSession;
import stepdefinition.Base;


public class ApplicationHelper extends Base{
	private static final Logger LOGGER = Logger
			.getLogger(ApplicationHelper.class.getName());

	private ApplicationHelper() {

	}
	
	public static void takeScreenShot()
	{
		try {
				 String fileNamePattern = "HH-mm-ss";
					SimpleDateFormat fileFormat = new SimpleDateFormat(fileNamePattern);

					String tagName = getTagName();

					System.out.println("################################### tagName: "
							+ tagName);

					String name = "";
					if (tagName != null) {
						name = tagName + "_Screenshot" + fileFormat.format(new Date());
					} else {
						name = "Screenshot" + fileFormat.format(new Date());
					}


					String screenshotDirectory = System.getProperty(
							"appium.screenshots.dir",
							System.getProperty("java.io.tmpdir", ""));
					/*String screenshotDirectory = System.getProperty(("user.dir")+"/Screenshots");*/
					File screenshot = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);
					screenshot.renameTo(new File(screenshotDirectory, String.format(
							"%s.png", name)));
					System.out
							.println("################################### screenshotDirectory: "
									+ screenshotDirectory + "|" + name);  
					   
		} catch (WebDriverException ex) {
		}
	}
	public static String getTagName() {

		String tagName = (String) ApplicationSession.getInstance()
				.getAttribute("TAG_NAME");

		return tagName;
	}
	
	public static void navigatePageBack() {

		try {
			driver.navigate().back();
		} catch (Exception ex) {
			LOGGER.info("Exception occurred while navigating back: ", ex);
			System.out.println("Exception occurred while navigating back: "
					+ ex.getMessage());
		}
	}
}
