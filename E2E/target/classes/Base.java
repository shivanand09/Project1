package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


public class Base {

	public static WebDriver driver;

	public Properties prop;

	public WebDriver intializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Selenium\\E2E\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_All\\chrome_driver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("driver is intialized as chrome");

		}

		else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium_All\\ff_driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("driver is intialized as ff");

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Selenium_All//ScreenShots//"+result+"screenshot.png"));

	}

}
