package com.colonia.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.colonia.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendMailServiceImpl.class);

	// Importante hacer la inyección de dependencia de JavaMailSender:
	@Autowired
	private JavaMailSender mailSender;

	// Pasamos por parametro: destinatario, asunto y el mensaje
	public String sendEmail(String to, String subject, String content) {

		SimpleMailMessage email = new SimpleMailMessage();

		email.setTo(to);
		email.setSubject(subject);
		email.setText(content);

		mailSender.send(email);
		return "OK";
	}

	@Override
	public String sendEmail2() {
		LOGGER.info("EmailBody: {}", "");
		return sendEmailTool("","serranoavila@gmail.com","");
	}

	private String sendEmailTool(String textMessage, String email, String subject) {
		String send = "NO";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			helper.setText(textMessage, true);
			helper.setSubject(subject);
			mailSender.send(message);
			send = "SI";
			LOGGER.info("Mail enviado!");
		} catch (MessagingException e) {
			LOGGER.error("Hubo un error al enviar el mail: {}", e);
		}
		return send;
	}
}
