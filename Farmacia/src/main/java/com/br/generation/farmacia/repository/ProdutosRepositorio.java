package com.br.generation.farmacia.repository;

import java.util.List;

import com.br.generation.farmacia.model.Produtos;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepositorio extends JpaRepository<Produtos, Long> {
    public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);
}
