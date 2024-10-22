package hooksPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import crewControlPages.AgencyPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.JavaUtilities;
import utilities.PropertyFileUtilities;
import utilities.TryCatchFab;
import yopMail.YOPMailPage;

public   class HooksClass {
	public WebDriver driver;
	//	 private DriverFactory df;
	LoginPage lp;
	PropertyFileUtilities prop;
	TryCatchFab tcf=new TryCatchFab();
	JavaUtilities jUtil;
	AgencyPage ap;
	YOPMailPage ymp;
	String name;
	String email;
	private ITestContext context;

	@Before
	public void setup(Scenario scenario) {
		jUtil=new JavaUtilities();
		//DriverFactory.init_driver();
		System.out.println("This is before method");

		System.out.println("Scenario started : " +scenario.getName());


	}

	@After
	public void exit(Scenario scenario) {
		this.driver=DriverFactory.init_driver();
		if(scenario.isFailed()) {

			System.out.println("Scenario Failed : "+ scenario.getName());
			jUtil=new JavaUtilities();


			if(jUtil==null) {
				System.out.println("jutil not instantiated");
			}
			jUtil.takeScreenshotAs(driver, scenario.getName());
		}else {
			System.out.println("Scenario Passed : "+ scenario.getName());


		}

		System.out.println("this is after method");
		//		driver.quit();
	}





}
