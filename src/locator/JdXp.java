package locator;

public interface JdXp {
String reg = "//a[contains(text(),'免费注册')]";
String logon = "//a[contains(text(),'登录')]";
String regname = "//input[@id='regName']";
String regid = "//input[@id='pwd']";
String regpwd = "//input[@type='password']";
String regsubmit = "//input[@id='registsubmit']";
String regcheck = "//div[contains(text(),' 恭喜，%1$s 已注册成功')]";
String sstext = "//input[@id='key']";
String ssbtn = "//input[@value='搜索']";
}