package cases;

import junit.framework.Assert;
import mylibs.BrowserInit;
import mylibs.BrowserType;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;
import mylibs.WriteAndReadtxt;
import static mylibs.PrintMain.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilder.setting.ErrorText;
import pages.HomePage;
import pages.myspace.*;;

public class UserSet {
	private WebDriver driver;
	private Do du;
	private Wait wait;
	HomePage hm;
	MySpacePage myspace;
	ErrorText tips = null;
	

	WriteAndReadtxt fop;
	private DBOP mpxp;
	private DBOP jpxp;

	public void addressmn(){
		myspace.swtichSet(mpxp.getLocatorXpath("setmenu"));
		myspace.address();
	}
	
	
	@SuppressWarnings("static-access")
	@BeforeClass
	public void init() {
		BrowserInit browser = new BrowserInit(BrowserType.chrome);
		driver = browser.driver;
		du = new Do(driver);
		wait = new Wait(driver);
		hm = new HomePage(driver);
		myspace = new MySpacePage(driver);
		jpxp = new DBOP("jingpinpage");
		mpxp = new DBOP("myspace");
		mpxp.connxpath("jingpinXP.sqlite");
		jpxp.connxpath("jingpinXP.sqlite");
		driver.manage().window().maximize();
	}

	@Test
	public void logOn() {
		hm.url("http://www.yunmall.com/");
		hm.logOn("ccf@ym.com", "1111111");
		wait.waitFor(1000);
		du.find(jpxp.getLocatorXpath("dlbtn")).click();
	}

	// 新增收货地址--成功的记录
	@Test
	public void address() {
		this.logOn();
		myspace.swtichSet(mpxp.getLocatorXpath("setmenu"));
		myspace.address();
		myspace.aaddress(0, 0, "陈测试c", "北京市", "朝阳区", "详细地址", "100012",
				"13112121212");
		// 判断地址计数是否加1
//		判断列表中是否存在新增的收件人信息
	}

	// 删除收货地址(可1条，可多条)
	@Test
	public void deladdress() {
		this.logOn();
		this.addressmn();	
		if (du.finds(mpxp.getLocatorXpath("deladdress")).get(0).isDisplayed()) {
			int beforedel = du.finds(mpxp.getLocatorXpath("deladdress")).size();
			myspace.delAddress(1,0);
			wait.waitFor(2000);
			int afterdel = du.finds(mpxp.getLocatorXpath("deladdress")).size();
			wait.waitFor(2000);
			// 判断地址计数是否减1
			Assert.assertEquals(beforedel - afterdel, 1);
			print("===删除成功===");
		} else {
			print("===无记录===");
			return;
		}
	}

	// 修改收货地址 判断输入框默认加载
	@Test
	public void modifyaddress() {
		this.logOn();
		myspace.swtichSet(mpxp.getLocatorXpath("setmenu"));
		myspace.address();
		myspace.aaddress(1, 0, "陈测试c", "北京市", "朝阳区", "详细地址", "100012",
				"13112121212");
		// 判断地址计数是否加1
	}

	// 新增收货地址-验证各提示条件 ；id值为输入框的顺序。
	@Test
	public void failaddress() {
		tips = new ErrorText();
		this.logOn();
		myspace.swtichSet(mpxp.getLocatorXpath("setmenu"));
		myspace.address();
		myspace.addressbtn();
		myspace.failAddress(1, "111");
		Assert.assertEquals(
				du.find("//div[@class='layout-form address-form']//div[@class='team']//span")
						.getText(), tips.falsetps("falsename"));
		myspace.failAddress(2, "111");
		wait.waitFor(1000);
		Assert.assertEquals(
				du.find("//div[@class='layout-form address-form']/div[2]/descendant::span[4]")
						.getText(),tips.falsetps("fprovin"));
		wait.waitFor(1000);
		myspace.failAddress(6, "111");
		System.out
				.println(du
						.find("//div[@class='layout-form address-form']/div[6]/descendant::span[2]")
						.getText());
		Assert.assertEquals(
				du.find("//div[@class='layout-form address-form']/div[6]/descendant::span[2]")
						.getText(), tips.falsetps("fphone"));
	}

	@AfterClass
	public void release() {
		driver.close();
		driver.quit();
	}

}
