package pages;

import static mylibs.PrintMain.print;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import locator.HomeXp;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;



public class HomePage {
	private WebDriver driver;
	public  Do du;
	public Actions mouse;
	private Wait wait;
	private Actions ac;
	private DBOP dbxp;
	
	
	public  HomePage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver,this);
		du = new Do(driver);
		ac = new Actions(driver);
		wait = new Wait(driver);
		dbxp = new DBOP("jingpinpage");
		dbxp.connxpath("jingpinXP.sqlite");	
	}
	public void register(){
		du.find(dbxp.getLocatorXpath("reg")).click();
	}
	public HomePage url(String url){
		driver.get(url);
		return this;
	}
	public void logOn(String name,String passwd){
		
//		du.find(dbxp.getLocatorXpath("log")).click();
		
		du.find("//a[text()='登录']").click();
		du.find(dbxp.getLocatorXpath("name")).sendKeys(name);
		du.find(dbxp.getLocatorXpath("passwd")).sendKeys(passwd);
	}
	public void sc(int i){
		ac.moveToElement(du.finds(dbxp.getLocatorXpath("img")).get(i)).build().perform();
		du.finds(dbxp.getLocatorXpath("sc")).get(i).click();
	}
		public void sc(WebElement aa,int i){
		ac.moveToElement(aa).build().perform();
		du.finds(dbxp.getLocatorXpath("sc")).get(i).click();
	}
	public List<WebElement> linktz(){
		wait.waitForElementPresent(dbxp.getLocatorXpath("msg"));
		ac.moveToElement(du.find(dbxp.getLocatorXpath("msg"))).perform();
		return du.finds(dbxp.getLocatorXpath("msgmn"));
	}
	public void loadProdcut(){
		int i = 0;
		
		while(!(du.find(dbxp.getLocatorXpath("nxtpage")).isDisplayed())){
		while(!(du.find(dbxp.getLocatorXpath("pagediv")).isDisplayed())){
			List<WebElement> prod1 = du.finds(HomeXp.prdc);
			ac.sendKeys(Keys.END).build().perform();
			wait.waitFor(2000);
			i++;
			List<WebElement> prod2 =  du.finds(HomeXp.prdc);
			int num  = prod2.size() -prod1.size();
			print("第"+i+"次加载"+"加载数量"+num);
		}
		du.find(HomeXp.nxtpage).click();
		}
		List<WebElement> prod2 =  du.finds(HomeXp.prdc);
		print("商品数量"+prod2.size()+"共加载"+i+"次");
	}
	public void loadProdcutnum(){
		new LoadProdcut().countProdcut(HomeXp.prdc);
		/*int i = 1;
		int num=1;
		while(num!=0){
			List<WebElement> prod1 = du.finds(HomeXp.prdc);
			ac.sendKeys(Keys.END).build().perform();
			wait.waitFor(2000);
			List<WebElement> prod2 =  du.finds(HomeXp.prdc);
			num  = prod2.size() -prod1.size();
			print("第"+i+"次加载"+"加载数量"+num);
			i++;
		}
		List<WebElement> prod2 =  du.finds(HomeXp.prdc);
		print("商品数量"+prod2.size()+"共加载"+i+"次");*/
	}
	public void pricefilt(int i){
		List<WebElement> priceattrs = du.finds(dbxp.getLocatorXpath("priceattrs"));
		priceattrs.get(i).click();
	}
	class LoadProdcut{
		public void countProdcut(String element){
			int i = 1;
			int num=1;
			while(num!=0){
				List<WebElement> prod1 = du.finds(element);
				ac.sendKeys(Keys.END).build().perform();
				wait.waitFor(2000);
				List<WebElement> prod2 =  du.finds(element);
				num  = prod2.size() -prod1.size();
				print("第"+i+"次加载"+"加载数量"+num);
				i++;
			}
			List<WebElement> prod2 =  du.finds(element);
			print("商品数量"+prod2.size()+"共加载"+i+"次");
	}
}
}
