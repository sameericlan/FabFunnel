package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import io.cucumber.plugin.EventListener;

public class ListenersImplementationClass implements WebDriverListener {

	@Override
	public void afterClick(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterClick(element);
	}

}
