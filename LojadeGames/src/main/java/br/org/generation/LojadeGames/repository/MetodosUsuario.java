package br.org.generation.LojadeGames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.LojadeGames.model.Gamers;

@Repository
public interface MetodosUsuario extends JpaRepository<Gamers, Long>{
	
	public Optional<Gamers> findByUsuario(String gamers);
	
}
