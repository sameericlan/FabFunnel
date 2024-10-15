package crewControlPages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgencyPage {
	WebDriver driver;
	String name;
	
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


	public AgencyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void addNewAgency(String agencyName, String email) {
		crewControlBtn.click();
		agenciesBtn.click();
		inviteNewAgencyBtn.click();

		agencyNameTxt.sendKeys(agencyName);
this.name=agencyName;
		emailTxt.sendKeys(email);

		submitBtn.click();

		
//		driver.findElement(By.xpath("//span[text()='"+name+"']/../..//span[text()='Invited']"));

	}
	
	
//	public String status() {
//
//		return statusOfUser.getText();
//	}

	public void logOutUser() {
		WebElement status = driver.findElement(By.xpath("//span[text()='"+name+"']/../..//span[text()='Invited']"));
System.out.println(status.getText());
Assert.assertTrue(status.getText().equals("Invited"));
		userImg.click();
		logoutBtn.click();
		if(loginPageText.getText().equals("Welcome to FabFunnel")) {
			System.out.println("LogOut successful");

		}

	}

}
