package crewControlPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import nameEmail.DynamicVariableStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgencyPage {
	WebDriver driver;
	public  String name;

	@FindBy(xpath="//span[contains(text(),'Crew Control')]")
	WebElement crewControlBtn;

	@FindBy(xpath="//a[text()='Agencies']")
	WebElement agenciesBtn;

	@FindBy(xpath="//span[text()='Invite new agency']")
	WebElement inviteNewAgencyBtn;	

	@FindBy(xpath="//input[@placeholder='Enter Agency name']")
	WebElement agencyNameTxt;

	@FindBy(xpath="//input[@placeholder='E-mail']")
	WebElement emailTxt;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;

	//	@FindBy(xpath="//span[text()='"+name+"']/../..//span[text()='Invited']")
	//	WebElement statusOfUser;

	@FindBy(xpath="//img[@alt='Profile']")
	WebElement userImg;

	@FindBy(xpath = "//span[text()='Logout']")
	WebElement logoutBtn;

	@FindBy(xpath="//h3[text()='Welcome to FabFunnel']")
	WebElement loginPageText;

	@FindBy(xpath="//div[text()='An agency with this name already exists']")
	WebElement sameUnMsg;

	@FindBy(xpath="//div[text()='Agency or user already exists with this email']")
	WebElement sameEmailMsg;




	public AgencyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void OpenAgencyPage() {
		crewControlBtn.click();

		agenciesBtn.click();
	}
	public void addNewAgency(String agencyName, String email) throws Throwable {
		int i=0;

	
		inviteNewAgencyBtn.click();

		while(i<4) {
			agencyNameTxt.clear();
			Thread.sleep(3000);
			System.out.println("agencyname "+agencyName);
			agencyNameTxt.sendKeys(agencyName);
			System.out.println("name of agency "+name);
			this.name=agencyName;
			System.out.println("name of agency "+name);
			Thread.sleep(3000);

			emailTxt.clear();
			System.out.println(email);
			emailTxt.sendKeys(email);

			submitBtn.click();
			try {
				if(sameUnMsg.isDisplayed() || sameEmailMsg.isDisplayed()) {
					System.out.println("name or email already exists. Retrying with another name and email!!");
					//					agencyName=null;
					//					email=null;
					i++;

				}
			}catch(Exception e ) {
				break;
			}


			//		driver.findElement(By.xpath("//span[text()='"+name+"']/../..//span[text()='Invited']"));

		}
	}


	//	public String status() {
	//
	//		return statusOfUser.getText();
	//	}

	
	public String getAgencyOwnerStatus(String stat) {
		WebElement status = driver.findElement(By.xpath("//span[text()='"+DynamicVariableStore.getInstance().getName()+"']/../..//span[text()='"+stat+"']"));
		System.out.println(status.getText());
		return status.getText();
		
	}
	public void logOutUser() {
		
		userImg.click();
		logoutBtn.click();
		if(loginPageText.getText().equals("Welcome to FabFunnel")) {
			System.out.println("LogOut successful");

		}

	}

}
