package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/main/resource/featuresRepo/test.feature",
glue= {"stepDefinitions"},
monochrome= true,
plugin= {"pretty","html: target/htmlreport.html", "json: json-report"}

		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//			
//		return super.scenarios();
//		
//		
//		
	}
	

//}
