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

	public void quitDriver(WebDriver driver) {
		if(driver!=null) {
			driver.quit();}
	}

	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void fluentWait(WebDriver driver,WebElement ele) {
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void getUrl(WebDriver driver, String URL) {
		driver.get(URL);
	}

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

	public String getCurrentURl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void getPageSource(WebDriver driver) {
		driver.getPageSource();
	}

	public void getWindowHandlesSingle(WebDriver driver, String actualTitle) {
		String abc=driver.getWindowHandle();
		driver.switchTo().window(abc);
		String expectedTitle =driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle)) 
		{
			
		}
	}


}
