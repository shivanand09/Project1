package Qa;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePageObjects;
import resources.Base;

public class ValidateTabs extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest

	public void intilize() throws IOException {
		driver = intializeDriver();

		driver.get(prop.getProperty("url"));

	}

	WebDriver driver;

	// validates home , courses, interview guide, about links on the page
	@Test

	public void validateTabs() throws IOException {

		HomePageObjects h1 = new HomePageObjects(driver);

		Assert.assertTrue(h1.getHomepageLink().isDisplayed());

		Assert.assertTrue(h1.getCoursesLink().isDisplayed());

		Assert.assertTrue(h1.getinterviewLink().isDisplayed());

		Assert.assertTrue(h1.getaboutLink().isDisplayed());

		log.info("Links are verified");

	}

	@AfterTest
	public void closeResources() {

		driver.close();
		driver=null;

	}

}
