package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;
	//	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	//	
	public static WebDriver init_driver() {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		return driver;
		


	}
	//		
	//		
	//		if(browser.equals("chrome")) {
	//			WebDriverManager.chromedriver().setup();
	//		tldriver.set(new ChromeDriver());
	//		}
	//		
	//		else if(browser.equals("firefox")){
	//			WebDriverManager.firefoxdriver().setup();
	//			tldriver.set(new FirefoxDriver());
	//		}
	//		else if(browser.equals("safari")){
	//			WebDriverManager.safaridriver().setup();
	//			tldriver.set(new SafariDriver());
	//		}
	//		else {
	//			System.out.println("Invalid Input. Kindly check your browser input");
	//		}	
	//		return getDriver();
	//	}
	//
	//	public static synchronized WebDriver getDriver() {
	//		return tldriver.get();
	//	}
	//	
	//	public static WebDriver getDriver() {
	//		return driver;
	//	}


}
