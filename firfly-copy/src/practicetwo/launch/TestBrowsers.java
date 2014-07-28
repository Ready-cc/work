package practicetwo.launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class TestBrowsers {
	
	private WebDriver driver;

	@Test
	public void start(){
		Browsers browser = new Browsers(BrowsersType.ie);
		driver = browser.driver;
		
		driver.get("http://www.126.com");
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	
}
