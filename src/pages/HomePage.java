package pages;

import java.util.List;

import libs.Do;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import locator.HomeXp;


public class HomePage {
	private WebDriver driver;
	public  Do du;
	public Actions mouse;
	
	public  HomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		du = new Do(driver);

	}
	public void register(){
		du.find(HomeXp.reg).click();
	}
	
	public void logOn(){
		du.find(HomeXp.log).click();
	}
	public HomePage url(String url){
		driver.get(url);
		return this;
	}
	public List<WebElement> linktz(){
		mouse = new Actions(driver);
		mouse.moveToElement(du.find(HomeXp.mntz)).build().perform();
		return du.finds(HomeXp.mntz1);
				
	}
	public List<WebElement> linkhm(String locator){
		mouse = new Actions(driver);
		mouse.moveToElement(du.find(locator)).build().perform();
		return du.finds(locator);
				
	}
	public String href(String locator){
		return du.find(locator).getAttribute("href");
				
	}

}
