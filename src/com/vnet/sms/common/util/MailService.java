package com.vnet.sms.common.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A singleton class for sending mail messages.
 * 
 * @author BinhNH
 */
public class MailService {

	/**
	 * Sends a subject and message to a recipient
	 * 
	 * @param recipient
	 *            Internet address of the recipient
	 * @param subject
	 *            the subject of the message
	 * @param message
	 *            the message
	 * @throws MessagingException
	 */
	public static void sendMessage(String recipient, String subject,
			String message) throws MessagingException {

		if (theService == null) {
			theService = new MailService();
		}

		MimeMessage mimeMessage = new MimeMessage(mailSession);

		mimeMessage.setFrom(new InternetAddress(FROM));
		mimeMessage.setSender(new InternetAddress(FROM));
		mimeMessage.setSubject(subject);
		mimeMessage.setContent(message, "text/plain");

		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(
				recipient));

		Transport transport = mailSession.getTransport("smtps");
		transport.connect(HOST, PORT, USER, PASSWORD);

		transport.sendMessage(mimeMessage,
				mimeMessage.getRecipients(Message.RecipientType.TO));
		transport.close();

	}

	private MailService() {
		Properties props = new Properties();
		
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", HOST);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.from", FROM);
		props.put("mail.smtps.quitwait", "false");

		mailSession = Session.getDefaultInstance(props);
		mailSession.setDebug(true);
	}

	private static MailService theService = null;

	private static Session mailSession;

	private static final String HOST = "192.168.2.10";
	private static final int PORT = 25;
	private static final String USER = "binhnh"; 
	private static final String PASSWORD = "Nguyenhaibinh48";
	private static final String FROM = "binhnh@vkx.com.vn";
}