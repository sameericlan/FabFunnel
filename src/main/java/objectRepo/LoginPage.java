package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


	@FindBy(xpath="//div//input[contains(@name,'email') or contains(@name,'username')]")
	WebElement usernameTxt;

	@FindBy(xpath="//input[@name='password']")
	WebElement pwdTxt;

	@FindBy(xpath="//span[text()='Sign in']")
	WebElement loginBtn;

	@FindBy(xpath="//h3[text()='Welcome to FabFunnel']")
	WebElement loginPageText;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement homeText;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String username, String password) {
		usernameTxt.sendKeys(username);
		pwdTxt.sendKeys(password);
		loginBtn.click();
	}

	public WebElement verifyLoginPage() {
		return loginPageText;
	}

	public String verifyHomePage() {
		return homeText.getText();
	}

}
