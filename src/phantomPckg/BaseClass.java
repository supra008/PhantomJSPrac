package phantomPckg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	

		public static void screenshot() throws IOException 
		{
			File srcfile = ((TakesScreenshot)pjd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("D:/Practice/ScreenShots/sample.jpg"),true);
			System.out.println("ScreenShot Taken");
		}
		
		public static void emailSent() throws EmailException {
			
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("D:/Practice/ScreenShots/sample.jpg");
			attachment.setDescription(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Redirected page screenshot");
			attachment.setName("Error page");
			//System.out.println("ScreenShot Attached");
			
			
			//Email email = new SimpleEmail();
			
			MultiPartEmail email = new MultiPartEmail (); 
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("ts19470815@gmail.com", "Abcd@12345"));
			email.setSSLOnConnect(true);
			email.setFrom("user@gmail.com", "Tony Stark");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("mondal.supratim8@gmail.com");
			email.attach(attachment);
			
			email.send();
			System.out.println("======Email Sent=======");
		}

}