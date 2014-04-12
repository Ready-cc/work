package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locator.RegistXp;
import libs.Do;
public class RegistePage {
	private WebDriver driver;
	private Do du;
	
	public RegistePage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	
	public RegistePage setAccountname(String accountname){
		this.du.find(RegistXp.name).sendKeys(accountname);
		return this;
	}
	
	public RegistePage setPasswd(String passwd){
		this.du.find(RegistXp.passwd).sendKeys(passwd);
		return this;
	}
	
	public RegistePage setNickname(String nickname){
		this.du.find(RegistXp.nickname).sendKeys(nickname);
		return this;
	}
	public void submmit(){
		du.find(RegistXp.registebutton).click();
	}
	public WebElement getWebElement(String value){
		return du.find(value);
		}
//	
	public WebElement getWebElement(String value,String accountname){
		return du.find(String.format(value, accountname));
		}
}
