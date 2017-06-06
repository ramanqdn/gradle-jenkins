/**
 * DMA - Data Management System. 
 * Copyright © 2013 DMA. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF DMA. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF DMA.
 */
package com.dma.email;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * <code>EmailManager</code> is used to send the emails to the ETMS user's EMAIL ID
 * @author rsingh4
 * @timestamp Jul 18, 2013
 */
@Component(value = "emailManager")
public class EmailManager {
	
	@Value("${smtp.host}")
	String smtpHost;

	@Value("${smtp.username}")
	String smtpUsername;

	@Value("${smtp.password}")
	String smtpPassword;


	private String subject;
	private String recipientEmail;
	private String message;

	public EmailManager() {
	}

	public EmailManager(String subject, String recipientEmail, String message) {
		this.subject = subject;
		this.recipientEmail = recipientEmail;
		this.message = message;
	}

	private JavaMailSenderImpl getMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(smtpHost);
		javaMailSenderImpl.setUsername(smtpUsername);
		javaMailSenderImpl.setPassword(smtpPassword);
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		javaMailSenderImpl.setJavaMailProperties(properties);
		return javaMailSenderImpl;

	}

	public boolean sendMessage() throws MessagingException {

		try {
			JavaMailSenderImpl javaMailSenderImpl=getMailSender();

			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom("DMA");
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}
	}

	public void sendMessage(String subject, String recipientEmail,
			String message) throws MessagingException {
		
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
		msg.setFrom(smtpUsername);
		msg.setTo(recipientEmail);
		msg.setSubject(subject);
		msg.setText(message, true);
		javaMailSenderImpl.send(mimeMessage);
	}
	
	
	public void sendMessage(String subject, String[] recipientEmails,
			String message) throws MessagingException {
		
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		
		
		for (int i = 0; i < recipientEmails.length; i++) {
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(smtpUsername);
		    msg.setTo(recipientEmails[i]);
		    msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);
		 }
		
	}

	public boolean sendMessageWithAttachment(String filePath)
			throws MessagingException {
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(smtpUsername);
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);

			FileSystemResource file = new FileSystemResource(filePath);
			msg.addAttachment(file.getFilename(), file);
			javaMailSenderImpl.send(mimeMessage);
			return true;
		}

		catch (MailException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

	public boolean sendMessageWithAttachment(String filePath1, String filePath2)
			throws MessagingException {
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(smtpUsername);
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			FileSystemResource file1 = new FileSystemResource(filePath1);
			msg.addAttachment(file1.getFilename(), file1);

			FileSystemResource file2 = new FileSystemResource(filePath2);
			msg.addAttachment(file2.getFilename(), file2);
			javaMailSenderImpl.send(mimeMessage);
			return true;
		}

		catch (MailException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
			return false;
		}
	}

}
