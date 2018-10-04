package com.jackson.reservadesala.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jackson.reservadesala.domain.SalaC;

public abstract class AbstractEmailService implements EmailService{
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSernder;
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
    public void sendOrderConfirmationEmail(SalaC obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromSalaC(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromSalaC(SalaC obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmailSolicitante());
		sm.setFrom(sender);
		sm.setSubject("Reserva confirmada: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateSalaC(SalaC obj) {
		Context context = new Context();
		context.setVariable("salaC", obj);
		return templateEngine.process("email/confirmacaoReserva", context);
	}
	
	@Override
    public void sendOrderConfirmationHtmlEmail(SalaC obj){
		try {
		MimeMessage mm = prepareMimeMessageFromSalaC(obj);
		sendHtmlEmail(mm);
		}
		catch(MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromSalaC(SalaC obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSernder.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmailSolicitante());
		mmh.setFrom(sender);
		mmh.setSubject("Reserva Confirmada codigo :" + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateSalaC(obj), true);
		return mimeMessage;
	}
	

}
                                                                                                                                                                                                                                                                                                                          