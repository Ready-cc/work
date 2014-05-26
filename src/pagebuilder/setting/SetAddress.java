package pagebuilder.setting;

import static mylibs.PrintMain.print;

import java.util.List;

import locator.HomeXp;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.HomePage;

public class SetAddress {

	private WebDriver driver;
	private Do du;
	private Actions ac;
	private DBOP mpxp;
	private DBOP jpxp;
	private DBOP addressdate;
	private Wait wait;
	private Actions action;
	
	public SetAddress(WebDriver driver) {
		
		wait = new Wait(driver);
		du = new Do(driver);
		ac = new Actions(driver);
		mpxp = new DBOP("myspace");
		jpxp = new DBOP("jingpinpage");
		addressdate = new DBOP("addressdata");
		jpxp.connxpath("jingpinXP.sqlite");
		mpxp.connxpath("jingpinXP.sqlite");
		addressdate.connxpath("testdata.sqlite");
		action = new Actions(driver);
	}
	public void addresstab() {
		wait.waitForElementPresent(mpxp.getLocatorXpath("addresstab"));
		du.find(mpxp.getLocatorXpath("addresstab")).click();
	}

	public void addAddress() {
		du.find(mpxp.getLocatorXpath("addaddress")).click();
	}

	// 输入收货地址 y=0,则保存，非0则取消;取消操作时，dialog为0则确定，非0 则取消
	public void inputAddress(int y, int dialog, String... params) {
		int i = 0;
		int j = 0;
		du.find(mpxp.getLocatorXpath("nickname")).sendKeys(params[0]);
		du.find(mpxp.getLocatorXpath("province")).sendKeys(params[1]);
		du.find(mpxp.getLocatorXpath("district")).sendKeys(params[2]);
		du.find(mpxp.getLocatorXpath("detailaddr")).sendKeys(params[3]);
		du.find(mpxp.getLocatorXpath("postcode")).sendKeys(params[4]);
		du.find(mpxp.getLocatorXpath("phone")).sendKeys(params[5]);
		if (i == y) {
			du.find(mpxp.getLocatorXpath("savebtn")).click();
			wait.waitFor(1000);
		} else {
			du.find(mpxp.getLocatorXpath("cancelbtn")).click();
			if (j == dialog) {
				du.find(mpxp.getLocatorXpath("dialogyes")).click();
			} else {
				du.find(mpxp.getLocatorXpath("dialogno")).click();
			}
			wait.waitFor(1000);
		}
	}

//输入错误信息判断
	public void failAddress(int i, String params) {
		switch (i) {
		case 1:
			du.find(mpxp.getLocatorXpath("nickname")).sendKeys(params);
			break;
		case 2:
			du.find(mpxp.getLocatorXpath("province")).clear();
			du.find(mpxp.getLocatorXpath("province")).sendKeys(params);
			break;
		case 6:
			du.find(mpxp.getLocatorXpath("phone")).clear();
			du.find(mpxp.getLocatorXpath("phone")).sendKeys(params);
			break;
		}
	}

	public void modifyAddress() {

	}
//i=1单个删除 2则循环删除 3 取消删除（i[1]--删除第几个）
	public void deleteAddress(int ...i) {
		List<WebElement> delbtns = du.finds(mpxp.getLocatorXpath("deladdress"));
		switch (i[0]) {
		case 1:
			du.finds(mpxp.getLocatorXpath("deladdress")).get(i[1]).click();
			wait.waitFor(2000);
			du.find(mpxp.getLocatorXpath("dialogyes")).click();
			break;
		case 2:
			for (WebElement delbtn : delbtns) {
				delbtn.click();
				wait.waitFor(2000);
				du.find(mpxp.getLocatorXpath("dialogyes")).click();
				break;
			}
		case 3:
			du.finds(mpxp.getLocatorXpath("deladdress")).get(i[1]).click();
			wait.waitFor(2000);
			du.find(mpxp.getLocatorXpath("dialogno")).click();
			
			break;
		
		}
		
	}
}
