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

	/**
	 * 
	 * this method takes screenshot 
	 * @param driver
	 * @param fileName
	 */
	public void takeScreenshotAs(WebDriver driver,String fileName) {
		System.out.println("enters ss block");
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


	/**
	 * 
	 * This method helps in switching between windows
	 * 
	 * @param driver
	 * @param window
	 */
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


	/**
	 * 
	 * This method helps in generating a random number upto 1000
	 * @return
	 */
	public int getRandomNum() {
		Random ran=new Random();
		int randNum = ran.nextInt(1000);
		return randNum;
	}

	/**
	 * 
	 * 
	 * 
	 * This method helps in getting current date
	 * @return
	 */
	public String getCurrentDate() {
		Date currentDate=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=dateFormat.format(currentDate);
		return currentDateTime;
	}



	/** 
	 * 
	 * 
	 * This method helps in scrolling through the webpage
	 * @param driver
	 * @param ele
	 */
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
