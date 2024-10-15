package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/main/resource/features/endToEnd.feature",
glue= {"stepDefinitions", "hooksPack"},
monochrome= true,
plugin= {"pretty","html: target/htmlreport.html", "json: json-report", /*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/},
tags="@smoketest"


		)
public class EndToEndRunner  extends AbstractTestNGCucumberTests{

}