package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement signInButton;

	public WebElement getUserName() {

		return userName;
	}

	public WebElement getPassword() {

		return password;
	}

	public WebElement getsignInButton() {

		return signInButton;
	}

}
