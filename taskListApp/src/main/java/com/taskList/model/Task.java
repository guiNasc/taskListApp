package com.taskList.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="tasks")
public class Task {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String titulo;

	private boolean concluido;
	
	private String descricao;
	
	@Column(name="dt_criacao") @Temporal(TemporalType.TIMESTAMP)
	private Date dtCricao = new Date();
	
	@Column(name="dt_edicao") @Temporal(TemporalType.TIMESTAMP)
	private Date dtEdicao = new Date();
	
	@Column(name="dt_remocao") @Temporal(TemporalType.TIMESTAMP)
	private Date dtRemocao;
	
	public Task(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtCricao() {
		return dtCricao;
	}

	public void setDtCricao(Date dtCricao) {
		this.dtCricao = dtCricao;
	}

	public Date getDtEdicao() {
		return dtEdicao;
	}

	public void setDtEdicao(Date dtEdicao) {
		this.dtEdicao = dtEdicao;
	}

	public Date getDtRemocao() {
		return dtRemocao;
	}

	public void setDtRemocao(Date dtRemocao) {
		this.dtRemocao = dtRemocao;
	}

}
