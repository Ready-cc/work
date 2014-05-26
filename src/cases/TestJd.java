package cases;

import locator.JdXp;
import mylibs.BrowserInit;
import mylibs.BrowserType;
import mylibs.Do;
import mylibs.ScreenShot;
import mylibs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public ScreenShot ss;
	
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
	@Test
	public void home(){
		
		ss = new ScreenShot();
		driver.get("http://www.baidu.com");
		driver.findElement(By.xpath("//input[@id='kw1']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='kw1']")).submit();
		WebElement ee = driver.findElement(By.xpath("//a[@class='s_logo']"));
		wait.waitFor(500);
		try {
			ss.screenHot(driver, "aa");
			ss.captureScreen(ee, "aa", 0, 0, 100, 100);
			ss.gsscAddTooltip(ee, ss.gsscCreateTooltip(ee, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void release(){
		driver.close();
		driver.quit();
	} 
}
