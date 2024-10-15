package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
features={"src/main/resource/features/loginTest.feature","src/main/resource/features/endToEnd.feature"},
glue= {"stepDefinitions"},
monochrome= true,
plugin= {"pretty","html: target/htmlreport.html", "json: json-report", /*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/}

		)

public class LoginRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//			
//		return super.scenarios();
//		
//		
//		
//	}
	

}