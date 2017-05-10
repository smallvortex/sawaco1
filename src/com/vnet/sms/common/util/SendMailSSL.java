package com.vnet.sms.common.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author BinhNH
 *
 */

public class SendMailSSL {
	public void send(String destination, String subjectMail, String content){
		Properties props = new Properties();
		props.put("mail.smtp.host", "192.168.2.10");
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("demo","1234@qwer");
				}
			});
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("demo@vkx.com.vn"));
			
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destination));
			message.setSubject(subjectMail);
			message.setText(content);
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse("binhnh@vkx.com.vn"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Ha," +
//					"\n\n I have been trying to send you email by java code"
//					+ "\n\n Please send me confirm mail if you crawl this mail successfully!");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}