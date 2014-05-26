package mylibs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class RemoteBrowser {
	private DesiredCapabilities caps;
	private WebDriver driver = null;
	private String projectpath = null;
	private String seleniumserverstandalone  = null;
	public WebDriver setFirefox(String nodeurl){
		projectpath = System.getProperty("user.dir");	
		caps = DesiredCapabilities.firefox();		
		seleniumserverstandalone = projectpath+"\\tool\\selenium-server-standalone.jar";
	    FirefoxProfile firefoxprofile =  new FirefoxProfile();
		try {
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			caps.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
			driver = new RemoteWebDriver(new URL(nodeurl), caps);	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return driver;
	}
	public void test(){
		driver.get("http://www.baidu.com");
	}
}
	
