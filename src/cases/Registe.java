package cases;

import libs.BrowserInit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import libs.Wait;


import pages.HomePage;
import pages.RegistePage;

import libs.*;
import locator.RegistXp;

public class Registe {
	public WebDriver driver;
	public Do du;
	public Wait wait;
	RegistePage rgpg;
	HomePage hmpg;
	
	@BeforeClass
	public void initBrowser(){
		BrowserInit browser = new BrowserInit(BrowserType.ie);
		driver = browser.driver;
		du = new Do(driver);
		hmpg = new HomePage(driver);
		rgpg = new RegistePage(driver);
		wait = new Wait(driver);
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void regist(){
		hmpg.url("http://www.xigua365.com").register();
		
		rgpg.setAccountname("ccf20140331010@qq.com").setPasswd("111111").setNickname("ccf20140331010").submmit();
//		wait.waitFor(2000);
//		rgpg.submmit();
//		wait.waitFor(2000);
//		du.find(RegistXp.registebutton).click();
		Assert.assertEquals(rgpg.getWebElement(RegistXp.emailcheck, "ccf20140331010").isDisplayed(), true);
		
		
	}
	@AfterClass
	public void release(){
		driver.close();
		driver.quit();
	} 
}

