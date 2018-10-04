package com.jackson.reservadesala.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.jackson.reservadesala.domain.SalaC;

public class MockEmailService extends AbstractEmailService{
	

	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("simulando Envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(SalaC pedido) {
		// TODO Auto-generated method stub
		
	}


}
