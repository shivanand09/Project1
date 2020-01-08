package Qa;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.HomePageObjects;
import resources.Base;

public class ValidateTitle extends Base {
	WebDriver driver;

	private static Logger log = LogManager.getLogger(Base.class.getName()); 
	@BeforeTest
	 
	 public void intilize() throws IOException
	 {
		 driver = intializeDriver();

		 driver.get(prop.getProperty("url")); 
		 
		 log.info("driver intialized");
	 }
	
	
	
	// validated FEATURED COURSES title on home page
	@Test
	public void titleValidation() throws IOException {
		

		HomePageObjects h2 = new HomePageObjects(driver);

		Assert.assertEquals(h2.getBanner().getText(), "FEATURED COURSES123");
		
		log.info("Title verified");

	}



	 @AfterTest
     public void closeResources()
     {
   	  
   	  driver.close();
   	driver=null;
   	  
     }







}


  