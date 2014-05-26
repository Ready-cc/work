package page;

import static mylibs.PrintMain.print;

import java.util.List;

import mylibs.DBOP;
import mylibs.Do;
import mylibs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pagebuilder.setting.SetAddress;

public class MySpacePage {
	private WebDriver driver;
	private Do du;
	private Actions ac;
	private DBOP mpxp;
	private DBOP jpxp;
	private DBOP addressdate;
	private Wait wait;
	private Actions action;

	public MySpacePage(WebDriver driver) {
		this.driver = driver;
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
//		PageFactory.initElements(driver, this);
	}

	public void swtichSet(String locator) {
		wait.waitFor(2000);
		WebElement user = du.find(jpxp.getLocatorXpath("userinfo"));
		ac.moveToElement(user).build().perform();
		wait.waitForElementPresent(locator);
		du.find(locator).click();
	}

	public void setuser() {
		/*
		 * WebElement user = driver.findElement(By.className("user"));
		 * ac.moveToElement(user).build().perform();
		 * driver.findElement(By.xpath("//a[contains(text(),'设置')]")).click();
		 */
		WebElement mselect = du
				.find("//div[@class='form-group'][4]/descendant::a");

		WebElement proviceselect = du
				.find("//div[@class='form-group'][5]/descendant::a[1]");
		proviceselect.click();
		List<WebElement> provices = du
				.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for (WebElement provice : provices) {
			print(provice.getText());
		}
		proviceselect.click();

		WebElement cityelect = du
				.find("//div[@class='form-group'][5]/descendant::a[2]");
		cityelect.click();
		List<WebElement> city = du
				.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for (WebElement city1 : city) {
			print(city1.getText());
		}
		cityelect.click();

		WebElement areaselect = du
				.find("//div[@class='form-group'][5]/descendant::a[3]");
		areaselect.click();
		List<WebElement> area = du
				.finds("//div[@class='bd' and @data-role='body']/descendant::span/a");
		for (WebElement area1 : area) {
			print(area1.getText());
		}
		areaselect.click();
	}

	public void setUserInstall() {

	}

	public void setaccountsync() {

	}

	// 收货地址tab
	public void address() {
		new SetAddress(driver).addresstab();
	}

	// 新增收货地址按钮
	public void addressbtn() {
		new SetAddress(driver).addAddress();
	}
	//输入正确收货地址
	public void aaddress(int y, int dialog, String... params) {
		new SetAddress(driver).inputAddress(y, dialog, params);
	/*	Setaddress add = new Setaddress();
		add.addAddress();
		add.inputAddress(y, dialog, params);*/
	}
//输入错误的收货地址
	public void failAddress(int i, String params) {
		new SetAddress(driver).failAddress(i, params);
		action.sendKeys(Keys.ENTER).build().perform();
/*		new Setaddress().failAddress(i, params);
		action.sendKeys(Keys.ENTER).build().perform();*/
	}
//删除收货地址：i为第几条
	public void delAddress(int ...i){
		new SetAddress(driver).deleteAddress(i);
		/*new Setaddress().deleteAddress(i);*/
		
	}

}
