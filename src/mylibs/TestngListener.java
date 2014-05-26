package mylibs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;



public class TestngListener extends TestListenerAdapter{

	private static Logger logger = Logger.getLogger(TestngListener.class);
//	public static final String CONFIG = "config.properties";
	public void onTestFailure(ITestResult tr){
		super.onTestFailure(tr);
		ScreenShot ss = new ScreenShot();
		ss.autoScreenShot(tr);
		logger.info(tr.getName() + " Failure");
	}
	
	public void onTestSkipped(ITestResult tr){
		super.onTestSkipped(tr);
		ScreenShot ss = new ScreenShot();
		logger.info(tr.getName()+"Skipped");
		ss.autoScreenShot(tr);
	}
	
	public void onTestSuccess(ITestResult tr){
		super.onTestSuccess(tr);
		logger.info(tr.getName()+"Success");
		System.out.println(tr.getName());
		
	}
	public void onTestStart(ITestResult tr){
		super.onTestStart(tr);
		logger.info(tr.getName()+"Start");
	}
	
	public void onFinish(ITestContext testContext){
		super.onFinish(testContext);
		
	}


}
