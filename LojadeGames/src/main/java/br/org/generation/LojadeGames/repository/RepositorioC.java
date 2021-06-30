package br.org.generation.LojadeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.LojadeGames.model.Categoria;

public interface RepositorioC extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByGeneroContainingIgnoreCase(String genero);
	
	public List<Categoria> findAllByIdContainingIgnoreCase(long id);
}
