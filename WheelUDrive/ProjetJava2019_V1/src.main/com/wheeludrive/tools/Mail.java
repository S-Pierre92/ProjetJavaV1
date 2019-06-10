package com.wheeludrive.tools;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class Mail {
	private final static String SMTP_HOST = "smtp.gmail.com";
	private final static String SMTP_PORT = "586";
	private final static String SMTP_AUTH = "true";
	private final static String SMTP_TLS_ENABLE = "true";

	private final static String SENDER = "projetjava2019@gmail.com";
	private final static String SENDER_PASSWORD = "2019projetjava2019";

	private Session mailSession;
	
	private final static Logger log = Logger.getLogger(Mail.class);

	private static Mail _instance = null;

	private Mail() {

	}

	public static Mail getInstance() {
		if (Mail._instance == null) {
			Mail._instance = new Mail();
		}

		return Mail._instance;
	}

	private void setMailServerProperties() {
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", Mail.SMTP_PORT);
		emailProperties.put("mail.smtp.auth", Mail.SMTP_AUTH);
		emailProperties.put("mail.smtp.starttls.enable", Mail.SMTP_TLS_ENABLE);
		emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		mailSession = Session.getDefaultInstance(emailProperties, null);
	}

	private MimeMessage draftEmailMessage(List<String> to, String subject, String content)
			throws AddressException, MessagingException {
		String emailSubject = subject;
		String emailBody = content;
		MimeMessage emailMessage = new MimeMessage(mailSession);
		// Set the mail recipients
		for (String email : to) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		}
		emailMessage.setSubject(emailSubject);
		// If sending HTML mail
		emailMessage.setContent(emailBody, "text/html");
		return emailMessage;
	}

	public void sendEmail(List<String> string, String subject, String content)
			throws AddressException, MessagingException {
		// Sender's credentials
		String fromUser = Mail.SENDER;
		String fromUserEmailPassword = Mail.SENDER_PASSWORD;
		String emailHost = Mail.SMTP_HOST;

		this.setMailServerProperties();

		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);

		// Draft the message
		MimeMessage emailMessage = this.draftEmailMessage(string, subject, content);
		// Send the mail
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}
	
	public boolean send() {
		String  d_email = Mail.SENDER,
	            d_uname = "Name",
	            d_password = Mail.SENDER_PASSWORD,
	            d_host = "smtp.gmail.com",
	            d_port  = "465",
	            m_to = "altonio2323@gmail.com",
	            m_subject = "Indoors Readable File: ",
	            m_text = "This message is from Indoor Positioning App. Required file(s) are attached.";
	    Properties props = new Properties();
	    props.put("mail.smtp.user", d_email);
	    props.put("mail.smtp.host", d_host);
	    props.put("mail.smtp.port", d_port);
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.debug", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.socketFactory.port", d_port);
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");

	    Session session = Session.getDefaultInstance(props, null);
	    session.setDebug(true);

	    MimeMessage msg = new MimeMessage(session);
	    try {
	        msg.setSubject(m_subject);
	        msg.setFrom(new InternetAddress(d_email));
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));

	Transport transport = session.getTransport("smtps");
	            transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
	            transport.sendMessage(msg, msg.getAllRecipients());
	            transport.close();

	        } catch (AddressException e) {
	            log.debug(e.getMessage());
	            return false;
	        } catch (MessagingException e) {
	        	log.debug(e.getMessage());
	            return false;
	        }
		return true;
	}
}
