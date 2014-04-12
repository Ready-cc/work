package locator;

public interface RegistXp {
	String name = "//input[@name='account_name']";
	String passwd = "//input[@name='password']";
	String nickname = "//input[@name='nickname']";	
	String registebutton = "//button[@data-role='submit']";
	String emailcheck = "//a[text()='%1$s']";
	

}
