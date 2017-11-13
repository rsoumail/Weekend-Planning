package fr.istic.m2il.weekendplanning.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	
	private Properties props = new Properties();
	private Session session;
	private Message message;
	
	public SendMailSSL() {
		setProperties();
		setSession();
	}
	
	void setProperties(){
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
	}
	
	void setSession() {
		this.session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("weekendplanningapp@gmail.com","weekendplanningappv1");
			}
		});
	}
	
	void setMessage(String to, String subject, String text) {
		message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("weekendplanningapp@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	void send() {
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		String sujet = "Testing mail service";
		String text  =  "Du coup j'ai fais un service mail qui marche";
		String to    = "waberi.houssein@gmail.com";
		SendMailSSL mail = new SendMailSSL();
		mail.setMessage(to, sujet, text);
		mail.send();
		System.out.println("Done!");

	}
}
