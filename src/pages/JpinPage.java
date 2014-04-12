package pages;

import libs.Do;
import locator.Jpin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JpinPage {
	private WebDriver  driver;
	private Do du;
	private Actions ac;
	public JpinPage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		ac = new Actions(driver);
	}
	
	public void sc(int i){
		ac.moveToElement(du.finds(Jpin.img).get(i)).build().perform();
		du.finds(Jpin.sc).get(i).click();
	}
	
	public void sc(WebElement aa,int i){
		ac.moveToElement(aa).build().perform();
		du.finds(Jpin.sc).get(i).click();
/*		if(du.find(Jpin.sc).isDisplayed()){
			
	}*/

	}
	public void dl(String name,String pswd){
		du.find(Jpin.dl).click();
		du.find(Jpin.name).sendKeys(name);
		du.find(Jpin.passwd).sendKeys(pswd);

	}
	
}
