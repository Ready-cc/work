package cases;

import java.util.List;


import org.openqa.selenium.JavascriptExecutor;

import libs.BrowserInit;
import libs.BrowserType;
import libs.Do;
import libs.Wait;
import locator.HomeXp;
import locator.Jpin;
import static libs.PrintMain.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JpinPage;



public class JingPin {
	

	private WebDriver driver;
	private Do du;
	private Wait wait;
	HomePage hm;
	HomePage hm1;
	JpinPage jpg;
	@BeforeClass
	public void startBrowser(){
		BrowserInit browser = new BrowserInit(BrowserType.chrome);
		driver = browser.driver;
		du = new Do(driver);
		wait = new Wait(driver);
		hm = new HomePage(driver);
		hm1 = new HomePage(driver);
		jpg = new JpinPage(driver);
		driver.manage().window().maximize();
	}	
	@Test
	public void logOn(){
		hm.url("http://www.yunmall.com/");
		jpg.dl("ccf@ym.com", "111111");
		du.find(Jpin.dlbtn).click();
	}
/*	@Test
	public void link(){
		List<WebElement> mn = hm.linktz();
		 ((JavascriptExecutor)driver).executeScript("document");
 		for(WebElement m:mn){
			print(m.getText());
			print(m.getAttribute("href"));
		}
		WebElement fx = du.find(HomeXp.fx);
		print(fx.getText()+fx.getAttribute("href"));
		WebElement gz = du.find(HomeXp.wdgz);
		print(gz.getText()+gz.getAttribute("href"));
	}*/
/*	@Test
	public void prdJZ(){
		Actions ax = new Actions(driver);
		int i = 0;
		int expectnum = 25;
		while(!(du.find("//div[contains(@class,'feed-page')]").isDisplayed())){
			List<WebElement> prod1 =  du.finds(HomeXp.prdc);
			ax.sendKeys(Keys.END).build().perform();
			wait.waitFor(2000);
			i++;
			List<WebElement> prod2 =  du.finds(HomeXp.prdc);
			int num  = prod2.size() -prod1.size();
			print("第"+i+"次加载"+"加载数量"+num);
			
		}
		List<WebElement> prod2 =  du.finds(HomeXp.prdc);
		print("商品数量"+prod2.size()+"共加载"+i+"次");
	}*/
	@Test
	public void sCang(){
		List<WebElement> sp = du.finds(Jpin.img);
		int length = sp.size();
		for(int i = 0;i<length;i++){
			jpg.sc(sp.get(i), i);
		}
	}

	@AfterClass
	public void releasBrowser(){
		driver.quit();
	}	


}
