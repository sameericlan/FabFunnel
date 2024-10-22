package utilities;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * 
	 * This method quits the current session
	 * @param driver
	 */
	public void quitDriver(WebDriver driver) {
		if(driver!=null) {
			driver.quit();}
	}

	/**
	 * 
	 * This method helps in maximizing the webpage
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	
	/**
	 * 
	 * This method wait uses elements
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	/**
	 * 
	 * 
	 * This a fluent wait method used till 10 seconds
	 * @param driver
	 * @param ele
	 */
	public void fluentWait(WebDriver driver,WebElement ele) {
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	
	/**
	 * 
	 * This method helps in getting the URL
	 * @param driver
	 * @param URL
	 */
	public void getUrl(WebDriver driver, String URL) {
		driver.get(URL);
	}

	
	/**
	 * 
	 * 
	 * @param driver
	 * @param actTitle
	 */
	public void windowSwitch(WebDriver driver, String actTitle) {
		Set<String> winID=driver.getWindowHandles();
		for(String winIDS : winID) {
			driver.switchTo().window(winIDS);
			String title=driver.getTitle();
			if (title.equalsIgnoreCase(actTitle)) {
				break;
			}	
		}
	}

	
	/**
	 * 
	 * This method helps in switching between windows
	 * 
	 * @param driver
	 * @param window
	 */
	public String getCurrentURl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	
	/**
	 * 
	 * This method helps in getting the page source
	 * @param driver
	 */
	public void getPageSource(WebDriver driver) {
		driver.getPageSource();
	}

	
	/**
	 * 
	 * 
	 * 
	 * @param driver
	 * @param actualTitle
	 */
	


}
