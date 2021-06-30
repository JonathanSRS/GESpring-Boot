package br.org.generation.LojadeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.LojadeGames.model.ACreed;

public interface Metodosadd extends JpaRepository<ACreed, Long>{
	
	public List<ACreed> findAllByNomeGContainingIgnoreCase(String nome);
	public List<ACreed> findAllByIdContainingIgnoreCase(long id);
						
	
}
