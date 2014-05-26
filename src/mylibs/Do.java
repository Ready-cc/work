package mylibs;

import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import mylibs.Wait;

public class Do {
	private WebDriver driver;
	private Wait waiter;
	
	public Do(WebDriver driver){
		this.driver = driver;	
		waiter = new Wait(driver);
	}
	public WebElement find(String locator) {
		return driver.findElement(By.xpath(locator));
		
	}
	public List<WebElement> finds(String locator){
		return driver.findElements(By.xpath(locator));
	}

	public void waitForElementPresent(String webelement){
		waiter.waitForElementPresent(webelement);
	}
	
	public void waitForElementIsEnable(String webelemente){
		waiter.waitForElementIsEnable(webelemente);
	}
	
	public void waitFor(long timeout){
		waiter.waitFor(timeout);
	}

}
