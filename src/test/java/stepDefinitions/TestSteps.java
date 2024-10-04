package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.LoginPage;
import utilities.PropertyFileUtilities;
import utilities.TryCatchFab;
public class TestSteps {
	WebDriver driver;
	LoginPage lp;
	PropertyFileUtilities prop;
	TryCatchFab tcf=new TryCatchFab();
	
	@Before
	public void setup() {
		System.out.println("This is before method");
		String URL=null;
		prop=new PropertyFileUtilities();
		try {
			URL=prop.readDataFromPropertFile( "URL");
			System.out.println(URL);

		} catch (Throwable e) {

			e.printStackTrace();
		}
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
	}


	@Given("login page is open")
	public void login_page_is_open() {
		//	lp=new LoginPage(driver);
		//	String loginText = lp.verifyLoginPage().getText();
		//	Assert.assertEquals(loginText, "Welcome to FabFunnel");
		//	System.out.println("LoginPage verification successful");
			tcf.execute(this:: testCase1);
//		executor.execute(new Runnable() {
//
//			@Override
//			public void run() {
//				testCase1();				
//			}
//		});
	}

	@When("user enters username and password")
	public void user_enters_username_and_password()  {
		String USERNAME=null;
		try {
			USERNAME = prop.readDataFromPropertFile( "username");
			System.out.println(USERNAME);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		String PASSWORD=null;
		try {
			PASSWORD = prop.readDataFromPropertFile( "password");
			System.out.println(PASSWORD);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			lp.loginToApp(USERNAME, PASSWORD);}
		catch(Exception e) {}
	}

	@And("user clicks on login button")
	public void user_click_on_login_button() {
		System.out.println("user enters login credentials and clicks login button");

	}

	@Then("user enters HomePage")
	public void user_enters_HomePage() {
		Assert.assertEquals(lp.verifyHomePage(), "Dashboard");
		System.out.println("User has successfully entered the Home Page");
	}

	@After
	public void exit() {
		System.out.println("this is after method");
		driver.quit();
	}
	public void testCase1() {
		lp=new LoginPage(driver);
		String loginText = lp.verifyLoginPage().getText();
		Assert.assertEquals(loginText, "Welcome to FabFunnel");
		System.out.println("LoginPage verification successful");
	}

}
