package br.org.generation.LojadeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ACreed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nomeG;
	
	private String resumoHis;
	
	@NotNull
	private int qtd;
	
	@NotNull
	private float preco;
	
	@NotNull
	private String clasificacao;
	
	//resp
	
	@ManyToOne
	@JsonIgnoreProperties("acreed")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeG() {
		return nomeG;
	}

	public void setNomeG(String nomeG) {
		this.nomeG = nomeG;
	}

	public String getResumoHis() {
		return resumoHis;
	}

	public void setResumoHis(String resumoHis) {
		this.resumoHis = resumoHis;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getClasificacao() {
		return clasificacao;
	}

	public void setClasificacao(String clasificacao) {
		this.clasificacao = clasificacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
