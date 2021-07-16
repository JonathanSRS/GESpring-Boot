package com.br.generation.farmacia.repository;

import java.util.List;

import com.br.generation.farmacia.model.Categoria;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
