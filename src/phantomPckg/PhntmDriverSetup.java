package phantomPckg;


import java.io.IOException;

import org.apache.commons.mail.EmailException;


public class PhntmDriverSetup extends BaseClass {

	
public static void main(String[] args) throws InterruptedException, IOException, EmailException {
		
		//System.setProperty("phantomjs.binary.path", "D:/Practice/SeleniumJars/phantomjs-2.1.1-windows/bin/phantomjs.exe");
	/*
		BaseClass.driverSetup();
		BaseClass.screenshot();
		BaseClass.emailSent();*/
		
	/*testClass a = new testClass();
	
	a.testMethod();*/
	
	screenShot scrnsht = new screenShot();
	emailSent email = new emailSent();
	
	BaseClass.driverSetup();
	scrnsht.screenshot(pjd);
	email.EmailSent();
	
	
		
		
	}
}
