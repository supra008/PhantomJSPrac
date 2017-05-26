package phantomPckg;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class emailSent {
	public void EmailSent() throws EmailException {
		
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
