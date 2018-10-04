package com.jackson.reservadesala.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackson.reservadesala.domain.SalaC;

public class SalaCDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=5, max=120, message="O tamanho de ser entre 5 e 80 caracteres")
	private String descricao;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	private Date dataDaReserva;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	private Date dataFinalDaReserva;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String nomeDoSolicitante;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String contatoSolicitante;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Email(message="email invalido")
	private String emailSolicitante;
	
	public SalaCDTO() {
		
	}
	
	public SalaCDTO(SalaC obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		dataDaReserva = obj.getDataDaReserva();
		dataFinalDaReserva = obj.getDataFinalDaReserva();
		nomeDoSolicitante = obj.getNomeDoSolicitante();
		contatoSolicitante = obj.getContatoSolicitante();
		emailSolicitante = obj.getEmailSolicitante();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataDaReserva() {
		return dataDaReserva;
	}
	public void setDataDaReserva(Date dataDaReserva) {
		this.dataDaReserva = dataDaReserva;
	}
	public Date getDataFinalDaReserva() {
		return dataFinalDaReserva;
	}
	public void setDataFinalDaReserva(Date dataFinalDaReserva) {
		this.dataFinalDaReserva = dataFinalDaReserva;
	}
	public String getNomeDoSolicitante() {
		return nomeDoSolicitante;
	}
	public void setNomeDoSolicitante(String nomeDoSolicitante) {
		this.nomeDoSolicitante = nomeDoSolicitante;
	}
	public String getContatoSolicitante() {
		return contatoSolicitante;
	}
	public void setContatoSolicitante(String contatoSolicitante) {
		this.contatoSolicitante = contatoSolicitante;
	}
	public String getEmailSolicitante() {
		return emailSolicitante;
	}
	public void setEmailSolicitante(String emailSolicitante) {
		this.emailSolicitante = emailSolicitante;
	}
	
	

}
