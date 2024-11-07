package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.DriverFactory;
import utilities.ExtentManager;
import utilities.JavaUtilities;

@CucumberOptions(
		features="src/main/resource/features/endToEnd.feature",
		glue= {"stepDefinitions", "hooksPack"},
		monochrome= true,
		plugin= {"pretty","html: target/htmlreport.html", "json: json-report.json", /*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/},
		tags = "@smoke"



		)
public class EndToEndRunner  extends AbstractTestNGCucumberTests{


	@BeforeClass
	public void befAll() {
		JavaUtilities jUtil=new JavaUtilities();

		ExtentManager.createInstance("./target/ExtentSparkReport"+jUtil.getCurrentDate()+".html");

		System.out.println("This is before class method");	
	}
	
	


	@AfterClass
	public void teardownBrowser() {
		System.out.println("This is after class method");	

		DriverFactory.init_driver().quit();
		 ExtentManager.flush();


	}
}