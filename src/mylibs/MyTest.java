package mylibs;

import org.openqa.selenium.WebDriver;

public  class MyTest{
	public WebDriver driver;
	public WebDriver driver(){
		BrowserInit browser = new BrowserInit(BrowserType.chrome);
		return driver = browser.driver;
	}
	
	

}
