package Qa;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePageObjects;
import pageObject.LoginPageObject;
import resources.Base;

public class Login extends Base {
    
	
	private static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest

	public void intilize() throws IOException {

		driver = intializeDriver();

		log.info("driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void firstTest(String userName, String password) throws IOException {
       
		
		driver.get(prop.getProperty("url"));
		HomePageObjects h1 = new HomePageObjects(driver);

		h1.getloginLink().click();

		LoginPageObject l1 = new LoginPageObject(driver);

		l1.getUserName().sendKeys(userName);

		l1.getPassword().sendKeys(password);

		l1.getsignInButton().click();
		
		log.info("Successfully Clicked on Login");

         
	}

	@DataProvider

	public Object[][] getData() {
		// firstTest will run 2 times
		Object[][] data = new Object[2][2];

		data[0][0] = "user1@test.com";
		data[0][1] = "ozocom1234";

		data[1][0] = "user2@test.com";
		data[1][1] = "ozocom1234";

		return data;

	}

	@AfterTest
	public void closeResources() {

		driver.close();
		driver=null;

	}

}
