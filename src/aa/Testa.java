package aa;



import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import mylibs.BrowserInit;
import mylibs.BrowserType;
import mylibs.DBOP;
import mylibs.Do;
import mylibs.ScreenShot;
import mylibs.Wait;
import mylibs.WriteAndReadtxt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;


public class Testa{
	private WebDriver driver;
	 HomePage hm;
	 WriteAndReadtxt fop;
	private  DBOP dbxp;
	Wait wait;
	ScreenShot ss;

	@BeforeClass
	public void startBrowser(){
		BrowserInit browser = new BrowserInit(BrowserType.firefox);
		driver = browser.driver;
		hm = new HomePage(driver);
		fop = new WriteAndReadtxt("F:/TestReady/XiGua/src/data/data_link.txt");
		dbxp = new DBOP("jingpinpage");
		dbxp.connxpath("jingpinXP.sqlite");
		driver.manage().window().maximize();
		wait = new Wait(driver);
		ss = new ScreenShot();
	}	
	
	@Test
	public void logOn(){
		driver.get("http://www.yunmall.com/");
		driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
		driver.findElement(By.name("account_name")).sendKeys("ccf@ym.com");
		driver.findElement(By.name("passwd")).sendKeys("112233");
		driver.findElement(By.name("passwd")).submit();
		WebElement user = driver.findElement(By.xpath("//a[contains(@href,'ucenter')]"));
		Assert.assertTrue(user.isDisplayed());
		System.out.print(user.getLocation());
		System.out.print(user.getLocation().x+" "+user.getLocation().getY());
		System.out.println();
		System.out.print(user.getSize());
		System.out.println();
		System.out.print(user.getSize().getHeight()+" "+user.getSize().getWidth());
		ss.elementScreen(user);
		wait.waitFor(1000);
//		WindowsUtils.tryToKillByName("firefox.exe");
		
	}

	@Test
	public void testBuild(){
		driver.get("file:///F:/testdata/javascript/parc2/prac.html");
		wait.waitFor(1000);
		Actions aa = new Actions(driver);
		WebElement one = driver.findElement(By.name("one"));
		WebElement three = driver.findElement(By.name("three"));
		WebElement five = driver.findElement(By.name("five"));
		// Add all the actions into the Actions builder.
		
		aa.keyDown(Keys.CONTROL)
		.click(one)
		.click(three)
		.click(five)
		.keyUp(Keys.CONTROL);
		// Perform the action.
		aa.perform();
		wait.waitFor(1000);
	}
/*	@AfterMethod
	public void updatereport(ITestResult result) throws Exception {  
//		String caseName ="a";
		ScreenShot.autoScreenShot(driver);
//		ScreenShot.screenShot(driver, result.getName(), result);
		System.out.println(result.getName());
	}*/
	@AfterClass
	public void releasBrowser(){
		driver.close();
		driver.quit();
	}	
}