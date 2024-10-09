package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy(className = "ant-input ant-input-lg css-1rb2j8y ant-input-outlined")
	WebElement fullNameTxt;

	@FindBy(className = "form-control w-100")
	WebElement phNoTxt;

	@FindBy(name = "password")
	WebElement pwdTxt;

	@FindBy(name="confirmPassword")
	WebElement confrmpwdTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement subBtn;

	//optional field
	@FindBy(className = "ant-input ant-input-lg css-1rb2j8y ant-input-outlined")
	WebElement aboutAgencyTxt;

	@FindBy(className = "ant-btn css-1rb2j8y ant-btn-primary ant-btn-lg w-100")
	WebElement nextBtn;

	//optional field
	@FindBy(className = "ant-select-selection-overflow-item ant-select-selection-overflow-item-suffix")
	WebElement membersEmailTxt;

	//dropdown for 'Agency Admin' or 'Media Buyer'-------optional field
	@FindBy(xpath = "//span[text()='Select Role']")
	WebElement assignRoleDropDwn;

	@FindBy(name="termAndCondition")
	WebElement chkBox;

	@FindBy(className = "ant-btn css-1rb2j8y ant-btn-primary ant-btn-lg w-100")
	WebElement subTermsBtn;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;


	}

	public void registerUser(String fullName,String phNo, String pwd) {
		fullNameTxt.sendKeys(fullName);
		phNoTxt.sendKeys(phNo);
		pwdTxt.sendKeys(pwd);
		confrmpwdTxt.sendKeys(pwd);
		subBtn.click();

		nextBtn.click();

		chkBox.click();

		subTermsBtn.click();


	}

	//	@FindBy(className = "ant-btn css-1rb2j8y ant-btn-primary ant-btn-lg w-100")
	//	WebElement subTermsBtn;
	//	
	//	@FindBy(className = "ant-btn css-1rb2j8y ant-btn-primary ant-btn-lg w-100")
	//	WebElement subTermsBtn;
	//	
	//	@FindBy(className = "ant-btn css-1rb2j8y ant-btn-primary ant-btn-lg w-100")
	//	WebElement subTermsBtn;




	//	div[contains(text(),'This Member')]
	//div[@class='ant-alert-message']
	//span[text()='Create new front']
	//input[@placeholder='Enter name']

	//span[text()='Create']

	//span[text()='Email']




}
