package hooksPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import crewControlPages.AgencyPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.JavaUtilities;
import utilities.PropertyFileUtilities;
import utilities.TryCatchFab;
import yopMail.YOPMailPage;

public   class HooksClass {
	private static WebDriver driver;
	//	 private DriverFactory df;
	LoginPage lp;
	PropertyFileUtilities prop;
	TryCatchFab tcf=new TryCatchFab();
	JavaUtilities jUtil;
	AgencyPage ap;
	YOPMailPage ymp;
	String name;
	String email;


	@Before
	public void setup(Scenario scenario) {
		jUtil=new JavaUtilities();

		System.out.println("This is before method");
		String URL=null;
		prop=new PropertyFileUtilities();
		try {
			URL=prop.readDataFromPropertFile( "URL");
			System.out.println(URL);

		} catch (Throwable e) {

			e.printStackTrace();
		}
		//		df=new DriverFactory();
		//		df.init_driver("chrome");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("Scenario started : " +scenario.getName());
	}

	@After
	public void exit(Scenario scenario) {
		if(scenario.isFailed()) {
			System.out.println("Scenario Failed : "+ scenario.getName());
			jUtil=new JavaUtilities();
			jUtil.takeScreenshotAs(driver, scenario.getName());
		}else {
			System.out.println("Scenario Passed : "+ scenario.getName());


		}

		System.out.println("this is after method");
		//		driver.quit();
	}

	/**
	 * This method returns driver instance
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver;
	}


}
