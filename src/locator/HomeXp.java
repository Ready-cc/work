package locator;

public interface HomeXp {
	String reg = "//a[text()='注册']";
	String log = "//a[text()='登录']";
	String ym = "//li/a[contains(text(),'关于云茂')]";
	String mnym = "//div/a[contains(text(),'关于云茂')]";
	String mnhp ="//div/a[contains(text(),'帮助中心')]";
	String mnkd ="//div/a[contains(text(),'我要开店')]";
	String wdgz = "//a[contains(text(),'我的关注')]";
	String fx = "//a[contains(text(),'发现')]";
	String ymmn = "//div[@class='db-menu']/a";
	String msg = "//li[@data-role='nav-msg']";
	String msgmn = "//li[@data-role='nav-msg']//a";
	String prdc = "//li[@class='feed-item']";
	String nxtpage = "//a[contains(@title,'下一页')]";
	String pagediv = "//div[contains(@class,'feed-page')]";
	
	String img  = "//a[@class='fi-img']";
	String sc = "//em[contains(text(),'收藏')]";
	String dl = "//a[contains(text(),'登录')]";
	String name = "//input[@name='account_name']";
	String passwd = "//input[@name='passwd']";
	String dlbtn = "//button[@data-role='submit']";
	
	String regname = "//input[@name='account_name']";
	String regpasswd = "//input[@name='password']";
	String nickname = "//input[@name='nickname']";	
	String registebutton = "//button[@data-role='submit']";
	String emailcheck = "//a[text()='%1$s']";
}
