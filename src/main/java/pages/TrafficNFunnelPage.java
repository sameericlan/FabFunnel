package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrafficNFunnelPage {
WebDriver driver;

@FindBy(xpath="//span[text()='Edit Agency']")
WebElement editAgencyBtn;


@FindBy(xpath="//span[text()='Add Traffic sources']")
WebElement addTrafficBtn;

@FindBy(xpath="//span[text()='Assign Assets']")  
WebElement assignAssetsBtn;

@FindBy(xpath="//span[text()='Select Traffic sources']")
WebElement selTrafficSourceDrpDwn;

@FindBy(xpath="//span[text()='Select funnel type']")
WebElement funnelTypeTxt;

@FindBy(xpath="//span[text()='Select funnel sub-type']")
WebElement fnlSbTypTxt;

@FindBy(xpath="//span[text()='Edit Agency']")
WebElement editAgencyBtn;

@FindBy(xpath="//span[text()='Edit Agency']")
WebElement editAgencyBtn;





















public TrafficNFunnelPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
	
	
}
	
	
	
	public void openTrafficFunnelPage() {
		driver.findElement(By.xpath("//span[text()='random854']/../..//span[@class='anticon']")).click();
		
		
		
	}
}
