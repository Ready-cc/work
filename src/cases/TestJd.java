package cases;

import libs.BrowserInit;
import libs.BrowserType;
import libs.Do;
import libs.Wait;
import locator.JdXp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.JdHomePage;
import pages.JdRegPage;

public class TestJd {
	public WebDriver driver;
	public Do du;
	public Wait wait;
	JdRegPage jdpg;
	JdHomePage jdhp;
	
	
	@BeforeClass
	public void initBrowser(){
		BrowserInit browser = new BrowserInit(BrowserType.chrome);
		driver = browser.driver;
		du = new Do(driver);
		jdpg = new JdRegPage(driver);
		jdhp = new JdHomePage(driver);
		wait = new Wait(driver);
		driver.manage().window();
	}
	@Test
	public void regist(){
		jdpg.url("http://www.jd.com").regIn();
		jdpg.setAccountname("ready004").setPasswd("ready111").submmit();
		Assert.assertEquals(jdpg.getWebElement(JdXp.regcheck, "ready004").isDisplayed(), true);		
	}
	@Test
	public void ss(){
		jdhp.url("http://www.jd.com");
		jdhp.ss("aaa");	
		
	}
	@AfterClass
	public void release(){
		driver.close();
		driver.quit();
	} 
}
