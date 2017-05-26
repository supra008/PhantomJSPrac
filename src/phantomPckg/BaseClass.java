package phantomPckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
	static WebDriver pjd;
	public static void driverSetup() throws InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setJavascriptEnabled(true);
		 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe" );
		 pjd = new PhantomJSDriver(caps);
		pjd.get("https://www.google.co.in");
		Thread.sleep(5000);
		pjd.manage().window().maximize();
		System.out.println("Done");

	}	

}