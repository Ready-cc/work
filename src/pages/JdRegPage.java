package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locator.HomeXp;
import locator.JdXp;
import mylibs.Do;
public class JdRegPage {
	private WebDriver driver;
	private Do du;
	
	public JdRegPage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	
	public JdRegPage setAccountname(String accountname){
		this.du.find(JdXp.regname).sendKeys(accountname);
		return this;
	}
	
	public JdRegPage setPasswd(String passwd){
		List<WebElement> pwds = du.finds(JdXp.regpwd);
		for(WebElement pwd:pwds){
			pwd.sendKeys(passwd);
		}
		return this;
	}

	public void submmit(){
		du.find(JdXp.regsubmit).click();
	}
	public void regIn(){
		du.find(JdXp.reg).click();
	}
	public JdRegPage url(String url){
		driver.get(url);
		return this;
	}
	public WebElement getWebElement(String value){
		return du.find(value);
		}

	public WebElement getWebElement(String value,String accountname){
		return du.find(String.format(value, accountname));
		}
}
