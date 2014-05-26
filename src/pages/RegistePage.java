package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import mylibs.DBOP;
import mylibs.Do;
public class RegistePage {
	private WebDriver driver;
	private Do du;
	private DBOP dbxp;
	
	public RegistePage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		dbxp = new DBOP("jingpinpage");
	}
	
	public RegistePage setAccountname(String accountname){
		this.du.find(dbxp.getLocatorXpath("regname")).sendKeys(accountname);
		return this;
	}
	
	public RegistePage setPasswd(String passwd){
		this.du.find(dbxp.getLocatorXpath("regpasswd")).sendKeys(passwd);
		return this;
	}
	
	public RegistePage setNickname(String nickname){
		this.du.find(dbxp.getLocatorXpath("regnickname")).sendKeys(nickname);
		return this;
	}
	public void submmit(){
		du.find(dbxp.getLocatorXpath("registebutton")).click();
	}
	public WebElement getWebElement(String value){
		return du.find(value);
		}
//	
	public WebElement getWebElement(String value,String accountname){
		return du.find(String.format(value, accountname));
		}
}
