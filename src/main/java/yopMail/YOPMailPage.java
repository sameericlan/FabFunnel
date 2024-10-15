package yopMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.JavaUtilities;

public class YOPMailPage {
	JavaUtilities jUtil;
	WebDriver driver;
	@FindBy(id="login")
	WebElement userEmailTxt;

	@FindBy(id ="refreshbut")
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
		jUtil=new JavaUtilities();
		
		userEmailTxt.sendKeys(email);
		submitBtn.click();
		driver.switchTo().frame("ifinbox");
		
		mailBtn.click();
//		driver.navigate().refresh();
	
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2); 
		
//		driver.switchTo().frame("ifmail");
		
//		WebElement frameSwitch = driver.findElement(By.xpath("//iframe[@name='ifmail']"));
//		driver.switchTo().frame(frameSwitch);
		
		System.out.println("frame switched successfully");
		jUtil.scrollToEle(driver, verifyBtn);
		verifyBtn.click();
		jUtil.switchWindow(driver, "FabFunnel");
		
	}
	
	
	
	
	
	
	
	
}
