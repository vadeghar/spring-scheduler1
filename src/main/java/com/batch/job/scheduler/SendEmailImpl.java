package com.batch.job.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class SendEmailImpl implements SendEmail {
	
	private static final Logger log = LoggerFactory.getLogger(SendEmailImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
    private JavaMailSender sender;

	@Override
	public void sendMessage(String emailBody) {
	try {
		MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
	    helper.setTo("lakshman.v@jarustech.com");
	    helper.setText(emailBody, true);
	    helper.setSubject("Mail from boot");
	    sender.send(message);
    } catch (MessagingException e) {
        e.printStackTrace();
        log.info("Error while sending mail .. {}", dateFormat.format(new Date()));
    }
        log.info("Mail Sent Success! {}", dateFormat.format(new Date()));
	}
}
