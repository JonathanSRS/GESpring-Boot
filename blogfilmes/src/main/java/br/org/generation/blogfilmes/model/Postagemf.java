package br.org.generation.blogfilmes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_mypostagens")
public class Postagemf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 50)	
	private String filme;
	@NotNull
	@Size(min = 5, max = 255)
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date lanca = new java.sql.Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.TIMESTAMP)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilme() {
		return filme;
	}
	public void setFilme(String filme) {
		this.filme = filme;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getLanca() {
		return lanca;
	}
	public void setLanca(Date lanca) {
		this.lanca = lanca;
	}
	public Date getDataA() {
		return date;
	}
	public void setDataA(Date date) {
		this.date = date;
	} 
	
}
