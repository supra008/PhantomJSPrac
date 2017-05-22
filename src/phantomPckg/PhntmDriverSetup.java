package phantomPckg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.*;

public class PhntmDriverSetup {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("phantomjs.binary.path", "D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		 /*DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setJavascriptEnabled(true);
		 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe" );*/
		 WebDriver pjd = new PhantomJSDriver();
		
		pjd.get("https://www.youtube.com");
		Thread.sleep(5000);
		pjd.manage().window().maximize();
		System.out.println("Redirected to : " + pjd.getTitle());
		
		if(!pjd.getCurrentUrl().equals("https://www.google.co.in/"))
		{
			File srcfile = ((TakesScreenshot)pjd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("D:/Practice/ScreenShots/sample.jpg"),true);
			System.out.println("ScreenShot Taken");
		}
		
		else 
		{
			System.out.println("Redirection Successful to " + pjd.getCurrentUrl());
		}

	}

}
