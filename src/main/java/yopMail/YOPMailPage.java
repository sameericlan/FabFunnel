package yopMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YOPMailPage {
	WebDriver driver;
	@FindBy(id="login")
	WebElement userEmailTxt;

	@FindBy(xpath="//i[text(]=''")
	WebElement submitBtn;
	
	//add frame switching here
	@FindBy(xpath = "(//span[text()='no-reply@lookfinity.com'])[1]")
	WebElement mailBtn;

	//add frame switching here
	@FindBy(xpath = "//a[contains(text(),'Start your journey')]")
	WebElement verifyBtn;
	
	public YOPMailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
}
	
	public void clickOnVerifyYOP(String email) {
		userEmailTxt.sendKeys(email);
		submitBtn.click();
		driver.switchTo().frame("ifinbox");
		
		mailBtn.click();
		
		driver.switchTo().frame("ifmail");
		
		verifyBtn.click();
	}
	
	
	
	
	
	
	
	
}
