package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	List<Object> clickList;

	@FindBy(xpath="//span[contains(text(),'Crew Control')]")
	WebElement crewControlBtn;

	public List<Object> getClickList() {
		return clickList;
	}

	public WebElement getCrewControlBtn() {
		return crewControlBtn;
	}

	public WebElement getIntegrationsBtn() {
		return integrationsBtn;
	}

	public WebElement getFunnelEngineBtn() {
		return funnelEngineBtn;
	}

	public WebElement getFmsBtn() {
		return fmsBtn;
	}

	public WebElement getToolsBtn() {
		return toolsBtn;
	}

	public WebElement getLaunchBtn() {
		return launchBtn;
	}

	public WebElement getCreativeLibraryBtn() {
		return creativeLibraryBtn;
	}

	public WebElement getReportsBtn() {
		return reportsBtn;
	}

	public WebElement getHelpSupportBtn() {
		return helpSupportBtn;
	}

	public WebElement getAgenciesBtn() {
		return agenciesBtn;
	}

	public WebElement getMembersBtn() {
		return membersBtn;
	}

	public WebElement getTeamsBtn() {
		return teamsBtn;
	}

	public WebElement getRolesPermissionBtn() {
		return rolesPermissionBtn;
	}

	public WebElement getOthersBtn() {
		return othersBtn;
	}

	public WebElement getFunnelTypeBtn() {
		return funnelTypeBtn;
	}

	public WebElement getClientConfigBtn() {
		return clientConfigBtn;
	}

	public WebElement getAsstesBtn() {
		return asstesBtn;
	}

	public WebElement getDmsBtn() {
		return dmsBtn;
	}

	public WebElement getS2SBtn() {
		return s2SBtn;
	}

	public WebElement getBusinessManagerBtn() {
		return businessManagerBtn;
	}

	public WebElement getLaunchesBtn() {
		return launchesBtn;
	}

	public WebElement getTargetTemplatesBtn() {
		return targetTemplatesBtn;
	}


	@FindBy(xpath="//span[contains(text(),'Integrations')]")
	WebElement integrationsBtn;

	@FindBy(xpath="//span[contains(text(),'Funnel Engine')]")
	WebElement funnelEngineBtn;

	@FindBy(xpath="//a[contains(text(),'FMS')]")
	WebElement fmsBtn;

	@FindBy(xpath="//span[contains(text(),'Tools')]")
	WebElement toolsBtn;

	@FindBy(xpath="//span[contains(text(),'Launch')]")
	WebElement launchBtn;

	@FindBy(xpath="//a[text()='Creative Library']")
	WebElement creativeLibraryBtn;

	@FindBy(xpath="//span[contains(text(),'Reports')]")
	WebElement reportsBtn;

	@FindBy(xpath="//a[text()='Help & Support']")
	WebElement helpSupportBtn;

	@FindBy(xpath="//a[text()='Agencies']")
	WebElement agenciesBtn;

	@FindBy(xpath="//a[text()='Members']")
	WebElement membersBtn;

	@FindBy(xpath="//a[text()='Teams']")
	WebElement teamsBtn;

	@FindBy(xpath="//a[text()='Roles & Permissions']")
	WebElement rolesPermissionBtn;

	@FindBy(xpath="//a[text()='Others']")
	WebElement othersBtn;

	@FindBy(xpath="//a[text()='Funnel type']")
	WebElement funnelTypeBtn;

	@FindBy(xpath="//a[text()='Client Configuration']")
	WebElement clientConfigBtn;

	@FindBy(xpath="//a[contains(text(),'Assets')]")
	WebElement asstesBtn;

	@FindBy(xpath="//a[contains(text(),'DMS')]")
	WebElement dmsBtn;

	@FindBy(xpath="//a[contains(text(),'S2S')]")
	WebElement s2SBtn;

	@FindBy(xpath="//a[text()='Business Manager']")
	WebElement businessManagerBtn;

	@FindBy(xpath="//a[contains(text(),'Launches')]")
	WebElement launchesBtn;

	@FindBy(xpath="//a[contains(text(),'Targeting Templates')]")
	WebElement targetTemplatesBtn;

	//	@FindBy(xpath="//a[text()='Help & Support']")
	//	WebElement helpSupportBtn;
	//	
	//	@FindBy(xpath="//a[text()='Agencies']")
	//	WebElement agenciesBtn;
	//	
	//	@FindBy(xpath="//a[text()='Members']")
	//	WebElement membersBtn;
	//	
	//	@FindBy(xpath="//a[text()='Teams']")
	//	WebElement teamsBtn;
	//	
	//	@FindBy(xpath="//a[text()='Roles & Permissions']")
	//	WebElement rolesPermissionBtn;
	//	
	//	@FindBy(xpath="//span[contains(text(),'Crew Control')]")
	//	WebElement crewControlBtn;
	//	
	//	@FindBy(xpath="//span[contains(text(),'Crew Control')]")
	//	WebElement crewControlBtn;
	//	
	//	@FindBy(xpath="//span[contains(text(),'Crew Control')]")
	//	WebElement crewControlBtn;

	public void clickOnCrewCntrl() {
		crewControlBtn.click();
	}

	public void clickOnIntegrationsBtn() {
		integrationsBtn.click();
	}

	public void clickOnFunnelEngineBtn() {
		funnelEngineBtn.click();
	}


	public void clickOnFMSBtn() {
		fmsBtn.click();
	}

	public void clickOnToolsBtn() {
		toolsBtn.click();
	}

	public void clickOnLaunchBtn() {
		launchBtn.click();
	}

	public void clickOnCreativeLibraryBtn() {
		creativeLibraryBtn.click();
	}

	public void clickOnReportsBtn() {
		reportsBtn.click();
	}

	public void clickOnHelpSupportBtn() {
		helpSupportBtn.click();
	}

	public void clickOnAgenciesBtn() {
		agenciesBtn.click();
	}

	public void clickOnMembersBtn() {
		membersBtn.click();
	}

	public void clickOnTeamsBtn() {
		teamsBtn.click();
	}

	public void clickOnRolesPermissionBtn() {
		rolesPermissionBtn.click();
	}

	public void clickOnOthersBtn() {
		othersBtn.click();
	}

	public void clickOnFunnelTypeBtn() {
		funnelTypeBtn.click();
	}

	public void clickOnClientConfigBtn() {
		clientConfigBtn.click();
	}

	public void clickOnAssetsBtn() {
		asstesBtn.click();
	}

	public void clickOnDMSBtn() {
		dmsBtn.click();
	}

	public void clickOnS2SBtn() {
		s2SBtn.click();
	}

	public void clickOnBusinessManagerBtn() {
		businessManagerBtn.click();
	}

	public void clickOnLaunchesBtn() {
		launchBtn.click();
	}

	public void clickOnTargetTemplatesBtn() {
		targetTemplatesBtn.click();
	}


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
//	public void 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}










