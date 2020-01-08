package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		System.out.println("b1");
		
	}

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath = "//h2[contains(text(),'Featured Courses')]")
	WebElement title;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li/a")
	WebElement homepageLink;
	
	@FindBy(css = "a[href*='course']")
	WebElement coursesLink;
	
	
	@FindBy(css = "a[href*='interview']")
	WebElement interviewLink;
	
	@FindBy(css = "a[href*='about']")
	WebElement aboutLink;
	
	

	public WebElement getloginLink()

	{

		return loginLink;

	}

	public WebElement getBanner()

	{

		return title;

	}

	public WebElement getHomepageLink()

	{

		return homepageLink;

	}

	
	public WebElement getCoursesLink()

	{

		return coursesLink;

	}
	
	
	public WebElement getinterviewLink()

	{

		return interviewLink;

	}
	
	
	public WebElement getaboutLink()

	{

		return aboutLink;

	}
}

