package mylibs;

import org.apache.commons.io.FileUtils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class ScreenShot {
	public  WebDriver driver;
	public Point point;
	public ScreenShot(){
		this.driver = BrowserInit.getDriver();
	}

	public static File screenShot(WebDriver driver, String caseName,ITestResult tr) {
		String dir_name = "E:/screenshot"; // 这里定义了截图存放目录名
		File Screenfile = null;
		if (!(new File(dir_name).isDirectory())) { // 判断是否存在该目录
			new File(dir_name).mkdir(); // 如果不存在则新建一个目录
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date()); // 这里格式化当前时间，例如20120406-165210，后面用的着

		try {
			File source_file = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			Screenfile = new File(dir_name + File.separator + time + caseName
					+ ".png");// 关键代码，执行屏幕截图，默认会把截图保存到temp目录
			FileUtils.copyFile(source_file, Screenfile); // 这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
			System.out.println("11");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.setCurrentTestResult(tr);
		return Screenfile.getAbsoluteFile();
	}

	public static File screentest(WebDriver driver, String caseName) {
		String dir_name = "E:/testshot"; // 这里定义了截图存放目录名
		File Screenfile = null;
		if (!(new File(dir_name).isDirectory())) { // 判断是否存在该目录
			new File(dir_name).mkdir(); // 如果不存在则新建一个目录
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date()); // 这里格式化当前时间，例如20120406-165210，后面用的着
		try {
			File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Screenfile = new File(dir_name + File.separator + time + caseName
					+ ".png");// 关键代码，执行屏幕截图，默认会把截图保存到temp目录
			FileUtils.copyFile(source_file, Screenfile); // 这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Screenfile.getAbsoluteFile();
	}
	

	public   void autoScreenShot(ITestResult tr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String fileName = mDateTime + "_" + tr.getName();
		String filePath = "";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		//这里可以调用不同框架的截图功能
		filePath = "E:/screenshot/" + fileName + ".jpg";
		File destFile = new File(filePath);
		FileUtils.copyFile(screenshot, destFile);
		} catch (Exception e) {
		filePath = fileName + " firefox tackScreentshot Failure:" + e.getMessage();
		System.out.println(filePath);
		}
		if (!"".equals(filePath)) {
		Reporter.setCurrentTestResult(tr);
		Reporter.log(filePath);
		//把截图写入到Html报告中方便查看
		Reporter.log("<img src=\"../" + filePath + "\"/>");
		}
		}
//	Rectangle 调用此类，实现按坐标截图。
	public void captureScreen(WebElement xx,String screenName, int x, int y,
			   int width, int height) {
		  String screenpath="E:/testshot/";
		  try {
		   BufferedImage capture = null;
		   Rectangle area = new Rectangle(x, y, width, height);
		   Robot robot = new Robot();
		   point = xx.getLocation();
		   robot.mouseMove(point.getX(), point.getY());
		   capture = robot.createScreenCapture(area);
		   
		   String fn = screenpath + screenName + ".jpg";
		   FileOutputStream out = new FileOutputStream(fn);
		   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		   encoder.encode(capture);
		   out.flush();
		   out.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
	public static File captureElement(WebElement element) throws Exception {
		WrapsDriver wrapsDriver = (WrapsDriver) element;
		// 截图整个页面
		File screen = ((TakesScreenshot) wrapsDriver
		.getWrappedDriver())
		.getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		// 获得元素的高度和宽度
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		// 创建一个矩形使面上面的高度，和宽度
		Rectangle rect = new Rectangle(width, height);
		// 得到元素的坐标
		Point p = element.getLocation();
		BufferedImage dest = img.getSubimage(p.getX()
		, p.getY(), rect.width,
		rect.height);
		//存为png格式
		ImageIO.write(dest, "png", screen);
		return screen;
		}
	public static File screenHot(WebDriver driver, String caseName) {
		String dir_name = "E:/testshot"; // 这里定义了截图存放目录名
		File Screenfile = null;
		if (!(new File(dir_name).isDirectory())) { // 判断是否存在该目录
			new File(dir_name).mkdir(); // 如果不存在则新建一个目录
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date()); // 这里格式化当前时间，例如20120406-165210，后面用的着
		try {
			File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Screenfile = new File(dir_name + File.separator + time + caseName
					+ ".png");// 关键代码，执行屏幕截图，默认会把截图保存到temp目录
			FileUtils.copyFile(source_file, Screenfile); // 这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Screenfile;
	}
	//获取title属性值，创建tooltip
	public  BufferedImage gsscCreateTooltip (WebElement element, int size) throws Exception{
		
		String text = element.getAttribute("title");
		String text_font = element.getCssValue("font-family");
		point = element.getLocation();
		int tooltip_h = size+7;
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D tooltip = img.createGraphics();
	        //设置悬浮框的宽度为文本的宽度加上7像素
		int tooltip_w = tooltip.getFontMetrics().stringWidth(text)+7;
		img = new BufferedImage(tooltip_w, tooltip_h, BufferedImage.TYPE_INT_ARGB);
		tooltip = img.createGraphics();
		//将创建图像的文字字体设置为从页面元素中获取到的文字字体
		tooltip.setFont(new Font(text_font, Font.PLAIN, size));
		
		tooltip.setPaint(Color.decode("#F5FCDE"));
		tooltip.fillRect(0, 0, tooltip_w, tooltip_h);
		tooltip.setPaint(Color.black);
		tooltip.draw3DRect(0, 0, tooltip_w-1, tooltip_h-1, true);
	        //将文本绘制到图像上，drawString()并不支持文本的自动换行，当需打印的文                         
	        //本太长时，需要自己实现自动换行
		tooltip.drawString(text,3,tooltip_h-5);
		tooltip.dispose();
		return img;
	}
//	tooltip加到截图中
	public  BufferedImage gsscAddTooltip (WebElement element, BufferedImage img) throws Exception{	
		// 创建tooltip
		BufferedImage tooltip = gsscCreateTooltip(element, 12);
		int tooltip_w = tooltip.getWidth();
		int tooltip_h = tooltip.getHeight();
		BufferedImage buffImg;
		Graphics2D graphic;
		point = element.getLocation();
		if (img != null){
			// 将tooltip添加到img中
			int img_w = img.getWidth();
			int img_h = img.getHeight();
			
			if (img_w >= (tooltip_w+point.getX())){
				buffImg = new BufferedImage(img_w, img_h+tooltip_h+2, BufferedImage.TYPE_INT_ARGB);
			}else{
			buffImg = new BufferedImage(tooltip_w+point.getX()+10, img_h+tooltip_h+2, BufferedImage.TYPE_INT_ARGB);
			}
			graphic = buffImg.createGraphics();
			graphic.drawImage(img, 0, 0, null);
			graphic.drawImage(tooltip, point.x+20, point.y+20, null);
		}else{
			buffImg = new BufferedImage(tooltip_w+3, tooltip_h+2, BufferedImage.TYPE_INT_ARGB);
			graphic = buffImg.createGraphics();
			graphic.drawImage(tooltip, 3, 1, null);
		}
		graphic.dispose();
		return buffImg;
	}
/**
 * 对指定元素截图
 * @param element
 * screenshot 全屏图的文件
 * destFile 目标文件
 * 先获取元素的坐标和xy的轴
 * ImageIO.read 读取全图
 * BufferedImage.getSubimage 子图的截取
 * ImageIO.write 写到目标文件
 */
	public void elementScreen(WebElement element){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String mDateTime = formatter.format(new Date());
		String filePath = "E:/testshot/";
//		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File  destFile = new File(filePath+mDateTime+ ".png");
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		Rectangle rect = new Rectangle(width, height);
		point = element.getLocation();
		try {
			BufferedImage elementimg = ImageIO.read(screenshot);
			BufferedImage screenimg = elementimg.getSubimage(point.getX(), point.getY(), rect.width, rect.height);
			ImageIO.write(screenimg, "jpeg", screenshot);
			FileUtils.copyFile(screenshot, destFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
//	完整截图
/*	public  void captureFlyover(WebDriver driver,String xpath,String screenName) throws Exception{
	    BufferedImage img;
	    BufferedImage img1;
	    //img1为抓取的不包含tooltip的屏幕截图
	    img1 = screentest(driver,"home");
	    //img为将悬浮框添加到img1后返回的屏幕截图
		img = gsscAddTooltip(driver.findElement(By.xpath(xpath)), img1);
		ImageIO.write(img, "png", new File(screenpath+screenName+".jpg"));
	}*/
}
