package phantomPckg;


import java.io.IOException;

import org.apache.commons.mail.EmailException;


public class PhntmDriverSetup extends BaseClass {

	
public static void main(String[] args) throws InterruptedException, IOException, EmailException {
	
	screenShot scrnsht = new screenShot();
	emailSent email = new emailSent();
	
	BaseClass.driverSetup();
	scrnsht.screenshot(pjd);
	email.EmailSent();
	
	
		
		
	}
}
