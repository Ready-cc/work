package pages.myspace;

import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;
import mylibs.WriteAndReadtxt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public class CouponPage {
	private WebDriver driver;
	private Do du;
	private Actions ac;
	private DBOP mpxp;
	private DBOP jpxp;
	private DBOP addressdate;
	private Wait wait;
	private Actions action;
	private MySpacePage mypace;
	private WriteAndReadtxt fop;

	public CouponPage(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		du = new Do(driver);
		ac = new Actions(driver);
		mpxp = new DBOP("mycoupon");
		jpxp = new DBOP("jingpinpage");
		jpxp.connxpath("jingpinXP.sqlite");
		mpxp.connxpath("jingpinXP.sqlite");
		action = new Actions(driver);
		fop = new WriteAndReadtxt("F:/TestReady/XiGua/data/coupon.xls");
//		PageFactory.initElements(driver, this);
	}
	
	public void toMycoupon(){
		mypace = new MySpacePage(driver);
		mypace.swtichSet(jpxp.getLocatorXpath("mycoupon "));
	}
	public void bindCoupon(int i){
		du.find(mpxp.getLocatorXpath("input")).sendKeys(fop.readExcel().get(i).toString());
		du.find(mpxp.getLocatorXpath("bindbtn")).click();
		wait.waitFor(1000);
		du.find(mpxp.getLocatorXpath("dialogyes")).click();
		
	}
}
