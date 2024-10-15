package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
//	public static WebDriver driver;
//	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
//	
//	public WebDriver init_driver(String browser) {
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
	}
