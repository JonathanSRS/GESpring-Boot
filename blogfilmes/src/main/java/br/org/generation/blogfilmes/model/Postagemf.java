package br.org.generation.blogfilmes.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	//@Column(name = "Data de Lançamento")
	private Date lanca;
	
	@Temporal(TemporalType.TIMESTAMP)
	//@Column(name = "Data de postagem")
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagemf")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagemf")
	private Usuario usuario;
	
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
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
	
	
}
