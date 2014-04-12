package pages;

import libs.Do;
import locator.JdXp;

import org.openqa.selenium.WebDriver;


public class JdHomePage {
	private WebDriver driver;
	private Do du;
	public JdHomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public JdHomePage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		
	}

	public JdHomePage url(String url){
		driver.get(url);
		return this;
	}
	public Sousuo ss(String word){
		return new Sousuo(word);
	}
	public regAndLog rl(){
		return new regAndLog();
	}

	class  regAndLog{
		public void reg(){
			du.find(JdXp.reg).click();
		}
		public void logOn(){
			du.find(JdXp.logon).click();
		}
	}

	class Sousuo {
		private Sousuo(String word){
			du.find(JdXp.sstext).sendKeys(word);
			du.find(JdXp.ssbtn).click();
			System.out.print(word);
			
		}
	}
	public static void main(String args[]){
		JdHomePage jdhp = new JdHomePage();
		jdhp.ss("aaaa");
		
	}
	
}
