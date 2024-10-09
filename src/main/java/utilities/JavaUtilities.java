package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class JavaUtilities {


	public void takeScreenshotAs(WebDriver driver,String fileName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		String destination=System.getProperty("user.dir")+"/target/cucumber-reports/screenshots/"+ fileName.replaceAll(" ", "_")+"_"+timeStamp+".png";
		try{

			FileUtils.copyFile(source, new File(destination) );
			System.out.println("Screenshot pasted : "+ destination);
		}catch(Exception e) {
			System.out.println("Failed to capture screenshot : "+ e.getMessage());
			e.printStackTrace();

		}
	}

	public int getRandomNum() {
		Random ran=new Random();
		int randNum = ran.nextInt(1000);
		return randNum;
	}

	public String getCurrentDate() {
		Date currentDate=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=dateFormat.format(currentDate);
		return currentDateTime;
	}


}

//Scenario scenario;
//String screenshotName = scenario.getName().replaceAll(" ", "_");
//try {
//	File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
//	
//	File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
//	
//	File.copy(sourcePath, destinationPath);   
//
//	Reporter.addScreenCaptureFromPath(destinationPath.toString());
//} catch (IOException e) {
//}
