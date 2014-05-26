package cases;

import java.util.List;



import locator.HomeXp;
import mylibs.BrowserInit;
import mylibs.BrowserType;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;
import mylibs.WriteAndReadtxt;
import static mylibs.PrintMain.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;



public class JingPin {
	

	private  WebDriver driver;
	private  Do du;
	private  Wait wait;
	 HomePage hm;
	 WriteAndReadtxt fop;
	private  DBOP dbxp;

	@BeforeClass
	public void startBrowser(){
		BrowserInit browser = new BrowserInit(BrowserType.firefox);
		driver = browser.driver;
		du = new Do(driver);
		wait = new Wait(driver);
		hm = new HomePage(driver);
		fop = new WriteAndReadtxt("F:/TestReady/XiGua/src/data/data_link.txt");
		dbxp = new DBOP("jingpinpage");
		dbxp.connxpath("jingpinXP.sqlite");
		driver.manage().window().maximize();
	}	
	@Test
	public void logOn(){
		hm.url("http://www.yunmall.com/");
		hm.logOn("ccf@ym.com", "112233");
		du.find(dbxp.getLocatorXpath("dlbtn")).click();
	}
	@Test
	public void link(){
		hm.url("http://www.yunmall.com/");
		List<WebElement> mn = hm.linktz();
 		for(WebElement m:mn){
 			print("case:link");
 			fop.writeFile(m.getText());
			fop.writeFile(m.getAttribute("href"));
		}
		WebElement fx = du.find(HomeXp.fx);
		print(fx.getText()+fx.getAttribute("href"));
		WebElement gz = du.find(HomeXp.wdgz);
		print(gz.getText()+gz.getAttribute("href"));
	}
	@Test
	public void prdJZ(){
		hm.url("http://www.yunmall.com/");
		while(!(du.find(dbxp.getLocatorXpath("nxtpage")).isDisplayed())){
			hm.loadProdcutnum();
			du.find(dbxp.getLocatorXpath("nxtpage")).click();
			wait.waitFor(2000);
			}
	}
	@Test
	public void sCang(){
		List<WebElement> sp = du.finds(dbxp.getLocatorXpath("img"));
		int length = sp.size();
		for(int i = 0;i<length;i++){
			hm.sc(sp.get(i), i);
		}
	}
	@Test
	public void myFollow(){
		this.logOn();
		wait.waitFor(1000);
		du.find(dbxp.getLocatorXpath("myfollow")).click();
		while(!(du.find(dbxp.getLocatorXpath("nxtpage")).isDisplayed())){
			hm.loadProdcutnum();
			du.find(dbxp.getLocatorXpath("nxtpage")).click();
			wait.waitFor(2000);
			}
		
	}
	@AfterClass
	public void releasBrowser(){
		driver.close();
		driver.quit();
		
	}	


}
