package com.jackson.reservadesala.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SalaC implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataDaReserva;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date dataFinalDaReserva;
	
	private String nomeDoSolicitante;
	private String contatoSolicitante;
	private String emailSolicitante;
	
	public SalaC() {
		
	}

	public SalaC(Integer id, String descricao, Date dataDaReserva, Date dataFinalDaReserva, String nomeDoSolicitante,
			String contatoSolicitante, String emailSolicitante) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataDaReserva = dataDaReserva;
		this.dataFinalDaReserva = dataFinalDaReserva;
		this.nomeDoSolicitante = nomeDoSolicitante;
		this.contatoSolicitante = contatoSolicitante;
		this.emailSolicitante = emailSolicitante;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaReserva == null) ? 0 : dataDaReserva.hashCode());
		result = prime * result + ((dataFinalDaReserva == null) ? 0 : dataFinalDaReserva.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaC other = (SalaC) obj;
		if (dataDaReserva == null) {
			if (other.dataDaReserva != null)
				return false;
		} else if (!dataDaReserva.equals(other.dataDaReserva))
			return false;
		if (dataFinalDaReserva == null) {
			if (other.dataFinalDaReserva != null)
				return false;
		} else if (!dataFinalDaReserva.equals(other.dataFinalDaReserva))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
