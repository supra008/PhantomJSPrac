package phantomPckg;

import java.io.File;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class emailSent {
	
	int count = 0;

	public void EmailSent() throws EmailException {
		
		MultiPartEmail email = new MultiPartEmail (); 
		
		File f = new File("D:/Practice/ScreenShots");
		
		for(File file : f.listFiles())
		{
			if(file.isFile())
			{
				
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath("D:/Practice/ScreenShots/"+file.getName());
				attachment.setDescription(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Redirected page screenshot");
				attachment.getName();
				email.attach(attachment);
			}
		}
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ts19470815@gmail.com", "Abcd@12345"));
		email.setSSLOnConnect(true);
		email.setFrom("user@gmail.com", "Tony Stark");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("mondal.supratim8@gmail.com");
		
		
		email.send();
		System.out.println("======Email Sent=======");
	}

}
