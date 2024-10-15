package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void switchWindow(WebDriver driver, String window) {
		Set<String> winID = driver.getWindowHandles();
		for(String winIDs:winID) {
			driver.switchTo().window(winIDs);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(window)) {
				System.out.println("Window successfully switched");
				break;

			}
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

	public void scrollToEle(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public String generateRandomPhNo() {
		Random random = new Random(); 
		long randomNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L); 
		String number=""+randomNumber;
		System.out.println("Phone: " + randomNumber); 
		return number;
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
