package br.org.generation.Farmacia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.Farmacia.modelo.Categoria;

public interface MetodosCat extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);
	
}
