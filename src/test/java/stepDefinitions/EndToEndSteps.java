package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import crewControlPages.AgencyPage;
import hooksPack.HooksClass;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import nameEmail.DynamicVariableStore;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.DriverFactory;
import utilities.JavaUtilities;
import utilities.PropertyFileUtilities;
import utilities.TryCatchFab;
import yopMail.YOPMailPage;

public class EndToEndSteps  {

	public WebDriver driver;
	private LoginPage lp;
	PropertyFileUtilities prop;
	JavaUtilities jUtil;
	private  AgencyPage ap;
	private YOPMailPage ymp;
	String name;
	String email;
	TryCatchFab tcf=new TryCatchFab();
	RegistrationPage rp;

	public EndToEndSteps() {

		this.driver=DriverFactory.init_driver();
		jUtil=new JavaUtilities();
		lp=new LoginPage(driver);
		prop=new PropertyFileUtilities();
		ap=new AgencyPage(driver);
		rp=new RegistrationPage(driver);

	}

	//	@Given("browser is open")
	//	public void browser_is_open() {
	//		
	//		String URL=null;
	//		prop=new PropertyFileUtilities();
	//		try {
	//			URL=prop.readDataFromPropertFile( "URL");
	//			System.out.println(URL);
	//
	//		} catch (Throwable e) {
	//
	//			e.printStackTrace();
	//		}
	//	
	//		driver.get(URL);
	////				this.driver=HooksClass.getDriver();
	//
	//		jUtil=new JavaUtilities();
	//		//		driver=new ChromeDriver();
	//
	//		if(driver==null) {
	//			System.out.println("driver NOT initialized");
	//		}else {
	//			System.out.println("successful");
	//		}
	//
	//	}
	//
	//	@When("user credentials are logged in and new Agency is invited")
	//	public void user_credentials_are_logged_in_and_new_agency_is_invited() {
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//
	//
	//		System.out.println("1st step");
	//		lp=new LoginPage(driver);
	//		//		System.out.println("2nd step");
	//
	//
	//		prop=new PropertyFileUtilities();
	//
	//
	//		tcf.execute(this :: tc1); // calling the try catch from here
	//
	//
	//	}
	//
	//This is going from try catch class block
	public void tc1()  {
		//		String loginText = lp.verifyLoginPage().getText();
		//		System.out.println("3rd step");
		//
		//		Assert.assertEquals(loginText, "Welcome to FabFunnel");
		//		System.out.println("=========LoginPage verification successful=========");
		//
		String USERNAME=null;

		try {
			USERNAME = prop.readDataFromPropertFile( "username");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(USERNAME);


		String PASSWORD=null;

		try {
			PASSWORD = prop.readDataFromPropertFile( "password");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(PASSWORD);

		//
		//
		lp.loginToApp(USERNAME, PASSWORD);
		//
		//		ap=new AgencyPage(driver);
		//		name="random"+jUtil.getRandomNum();
		//		email=name+"@yopmail.com";
		//		ap.addNewAgency( name, email);
		//		System.out.println(name+"- User Registration successful!!");
		//		ap.logOutUser();
		//		System.out.println("============User logged out============");
	}
	//
	//
	//	@And("user verifies from mail box and registration is done")
	//	public void user_verifies_from_mail_box_and_registration_is_done() {
	//		driver.get("https://yopmail.com/en/");
	//		ymp=new YOPMailPage(driver);
	//		ymp.clickOnVerifyYOP(email);
	//
	//
	//	}
	//
	//	@And("user accepts the invitation")
	//	public void user_accepts_the_invitation() {
	//		RegistrationPage rp=new RegistrationPage(driver);
	//		rp.registerUser("random", jUtil.generateRandomPhNo(), "Test@123");
	//
	//
	//	}
	//
	//	@Then("status is verified through owner")
	//	public void status_is_verified_through_owner() {
	//
	//	}







	//=====================================

	@Given("homepage is open")
	public void homepage_is_open() {

		jUtil=new JavaUtilities();

		//		this.driver=DriverFactory.init_driver();
		//Assert.fail();
		String URL=null;
		try {
			URL=prop.readDataFromPropertFile( "URL");
			System.out.println(URL);

		} catch (Throwable e) {

			e.printStackTrace();
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		System.out.println("1st step");



		String loginText = lp.verifyLoginPage().getText();
		//		System.out.println("3rd step");

		Assert.assertEquals(loginText, "Welcome to FabFunnel");
		System.out.println("=========LoginPage verification successful=========");

	}

	@Then("user credentials are logged in")
	public void user_credentials_are_logged_in() {
		tcf.execute(this :: tc1); // calling the try catch from here

	}

	@Given("user clicks on crew control and agency button")
	public void user_clicks_on_crew_control_and_agency_button() {



	}

	@Then("user invites new agency")
	public void user_invites_new_agency() throws Throwable {
		//		jUtil=new JavaUtilities();

		name="random"+jUtil.getRandomNum();
		email=name+"@yopmail.com";
		DynamicVariableStore.getInstance().setName(name);
		DynamicVariableStore.getInstance().setEmail(email);

		System.out.println(name);

		System.out.println(email);

		//				name="random765";
		//				email=name+"@yopmail.com";



		//				email=name+"@yopmail.com";
		ap.OpenAgencyPage();
		ap.addNewAgency( name, email);
		//		try {
		//			ap.addNewAgency( "random626", "random626@yopmail.com");
		//		} catch (Throwable e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}





		System.out.println(name+"- User Registration successful!!");
		String status=ap.getAgencyOwnerStatus("Invited");
		Assert.assertTrue(status.equals("Invited"));

		ap.logOutUser();
		System.out.println("============User logged out============");

	}

	@Given("Login to YOPmail")
	public void login_to_yo_pmail() {



		driver.get("https://yopmail.com/en/");
		ymp=new YOPMailPage(driver);
		//		ymp.clickOnVerifyYOP(email);


		ymp.clickOnVerifyYOP(DynamicVariableStore.getInstance().getEmail());



	}

	@When("Token catch from to-mail")
	public void token_catch_from_to_mail() {

		rp.registerUser("random", jUtil.generateRandomPhNo(), "Test@123");

		//Assert.fail();
	}

	@Then("Signup agency")
	public void signup_agency() {

		lp.loginToApp(DynamicVariableStore.getInstance().getEmail(), "Test@123");
		String homepageText = lp.verifyHomePage();
		//		System.out.println("3rd step");

		Assert.assertEquals(homepageText, "Dashboard");
		System.out.println("=========HomePage verification successful=========");


	}


	@And("Check the status of agency owner")
	public void Check_the_status_of_agency_owner() {

		ap.logOutUser();

		String USERNAME=null;

		try {
			USERNAME = prop.readDataFromPropertFile( "username");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(USERNAME);


		String PASSWORD=null;

		try {
			PASSWORD = prop.readDataFromPropertFile( "password");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(PASSWORD);

		//
		//
		lp.loginToApp(USERNAME, PASSWORD);
		ap.OpenAgencyPage();
		String status=ap.getAgencyOwnerStatus("Active");
		Assert.assertEquals(status, "Active");


	}



}
