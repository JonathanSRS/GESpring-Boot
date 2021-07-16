package com.br.generation.farmacia.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import  lombok.Data;
import  lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produtos {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    private String nome;
    
    @NotNull
    private int preco;
    
    @NotNull
    private float qtd;
    
    @NotNull
    private String marca;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());
    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    
}
