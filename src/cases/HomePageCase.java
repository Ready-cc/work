package cases;

import static mylibs.PrintMain.*;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mylibs.BrowserInit;
import mylibs.BrowserType;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.MyException;
import mylibs.ParseProperties;
import mylibs.Switch;
import mylibs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.myspace.CouponPage;

import br.eti.kinoshita.testlinkjavaapi.model.TestCase;

//import myTools.APIObject;

public class HomePageCase {

	private WebDriver driver;
	private Do du;
	private Wait wait;
	private Switch swtichw;
	
	   //testlink parameters
    private String url;
    private String devKey;
    private String projectName;
    private String tl;
    private String buildName;
    private String platform;
	private String caseName;
	CouponPage cp;
	 HomePage hm;
	 private  DBOP dbxp;


	@BeforeClass
	public void startBrowser() {
		BrowserInit browser = new BrowserInit(BrowserType.chrome);
		driver = browser.driver;
		du = new Do(driver);
		cp = new CouponPage(driver);
		hm = new HomePage(driver);
		wait = new Wait(driver);
		dbxp = new DBOP("jingpinpage");
		dbxp.connxpath("jingpinXP.sqlite");
		swtichw = new Switch(driver);
		driver.manage().window().maximize();
		}	
	@Test
	public void logOn(){
		hm.url("http://www.yunmall.com/");
		hm.logOn("ccf@ym.com", "112233");
		du.find(dbxp.getLocatorXpath("dlbtn")).click();
	}
	
	@Test
	public void collect() throws MyException{
		WebElement product1= du.find("//div[@class='mask-layer'   and child::a[contains(@href,'100-2091')]]");
		(new Actions(driver)).moveToElement(product1).build().perform();
		wait.waitFor(2000);
//		product1.click(); 
	}
	@Test
	public void search() throws MyException{
		du.find("//div[@class='search-box']/descendant::input[1]").sendKeys("ccf123");
		du.find("//button[text()='搜索按钮']").click();
	}
	@Test
	public void selectprodcut() throws MyException{
		du.find("//a[text()='100-1472']").click();
		swtichw.toSpecificWindow("100-1472");
		du.find("//button[text()='立即购买']").click();
		du.find("//button[text()='提交订单']").click();
		
	}
	@Test
	public void mySpace() throws MyException{
		this.logOn();
		Actions moveToE = new Actions(driver);
		WebElement user = driver.findElement(By.className("userAvatar"));
		moveToE.moveToElement(user).build().perform();
		du.find("//a[contains(text(),'我的空间')]").click();
		wait.waitFor(1000);
		du.find("//button[@class='btn-r']").click();
		wait.waitFor(5000);
		du.find("//div[object[@type='application/x-shockwave-flash']]").click();
		wait.waitFor(5000);
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
				System.out.print(titlename);
		}
	}
	@Test
	public void set() throws MyException{
		this.logOn();
		Actions moveToE = new Actions(driver);
		
		WebElement user = driver.findElement(By.className("user"));
		moveToE.moveToElement(user).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'设置')]")).click();
		WebElement mselect= du.find("//div[@class='form-group'][4]/descendant::a");
/*		mselect.click();
		List<WebElement> xbs = du.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		Iterator<WebElement> xb = xbs.iterator();
		wait.waitFor(2000);
		for(WebElement xb1:xbs){
			print(xb1.getText());
		}
		mselect.click();*/
//		swtichw.backToCurrentWindow();
		WebElement proviceselect= du.find("//div[@class='form-group'][5]/descendant::a[1]");
		proviceselect.click();
		List<WebElement> provices = du.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for(WebElement provice:provices){
			print(provice.getText());
		}
		proviceselect.click();
		
		WebElement cityelect= du.find("//div[@class='form-group'][5]/descendant::a[2]");
		cityelect.click();
		List<WebElement> city = du.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for(WebElement city1:city){
			print(city1.getText());
		}
		cityelect.click();
	
		
		WebElement areaselect= du.find("//div[@class='form-group'][5]/descendant::a[3]");
		areaselect.click();
		List<WebElement> area = du.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for(WebElement area1:area){
			print(area1.getText());
		}
		areaselect.click();
		
		
	}
//	循环绑定优惠券
	@Test
	public void myCoupon(){
		this.logOn();
		cp.toMycoupon();
		for(int i=1;i<10;i++){
			cp.bindCoupon(i);
		}
	}
	

	@AfterClass
	public void releasBrowser(){
		driver.quit();
	}	
}
