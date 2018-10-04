package com.jackson.reservadesala.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.jackson.reservadesala.domain.SalaC;

public interface EmailService {
	
	void sendOrderConfirmationEmail(SalaC obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(SalaC obj);
	
	void sendHtmlEmail(MimeMessage msg);
}
