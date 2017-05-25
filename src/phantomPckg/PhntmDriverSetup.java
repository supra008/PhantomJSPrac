package phantomPckg;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.*;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.*;

public class PhntmDriverSetup {

	public static void main(String[] args) throws InterruptedException, IOException, EmailException {
		
		//System.setProperty("phantomjs.binary.path", "D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		 WebDriver pjd = driverSetup();
		
		pjd.get("https://www.youtube.com");
		Thread.sleep(5000);
		pjd.manage().window().maximize();
		System.out.println("Redirected to : " + pjd.getTitle());
		
		if(!pjd.getCurrentUrl().equals("https://www.google.co.in/"))
		{
			screenshot(pjd);
			emailSent();
			
		}
		
		
		
		else 
		{
			System.out.println("Redirection Successful to " + pjd.getCurrentUrl());
		}
		
	

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

	public static WebDriver driverSetup() {
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setJavascriptEnabled(true);
		 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe" );
		 WebDriver pjd = new PhantomJSDriver(caps);
		return pjd;
	}

	private static void screenshot(WebDriver pjd) throws IOException {
		File srcfile = ((TakesScreenshot)pjd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:/Practice/ScreenShots/sample.jpg"),true);
		System.out.println("ScreenShot Taken");
	}

}
