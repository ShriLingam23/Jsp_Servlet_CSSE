package email_new;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

	public static void send(String to, String sub, String msg, final String user, final String pass) {
		
		//create an instance of Properties Class   
		Properties props = new Properties();

		/*
		 * Specifies the IP address of your default mail server for e.g if you are using
		 * gmail server as an email sever you will pass smtp.gmail.com as value of
		 * mail.smtp host. As shown here in the code. Change accordingly, if your email
		 * id is not a gmail id
		 */
		props.put("mail.smtp.host", "smtp.gmail.com");
		// below mentioned mail.smtp.port is optional 
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		/*
		 * Pass Properties object(props) and Authenticator object for authentication to
		 * Session instance
		 */

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		try {

			/*
			 * Create an instance of MimeMessage, it accept MIME types and headers
			 */

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			//message.setText(msg);
			String htmlsg="<html>\r\n" + 
					"  <head>\r\n" + 
					"    <style>\r\n" + 
					"      .colored {\r\n" + 
					"        color: blue;\r\n" + 
					"      }\r\n" + 
					"      #body {\r\n" + 
					"        font-size: 14px;\r\n" + 
					"      }\r\n" + 
					"      @media screen and (min-width: 500px) {\r\n" + 
					"        .colored {\r\n" + 
					"          color:red;\r\n" + 
					"        }\r\n" + 
					"      }\r\n" + 
					"    </style>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <div id='body'>\r\n" + 
					"      <p>Hi Pierce,</p>\r\n" + 
					"      <p class='colored'>\r\n" + 
					"        This text is blue if the window width is\r\n" + 
					"        below 500px and red otherwise.\r\n" + 
					"      </p>\r\n" + 
					"      <p>Jerry</p>\r\n" + 
					"    </div>\r\n" + 
					"  </body>\r\n" + 
					"</html>";			
			
			message.setContent(htmlsg,"text/html; charset=utf-8");

			/* Transport class is used to deliver the message to the recipients */

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
