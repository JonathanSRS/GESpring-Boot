package br.org.generation.blogfilmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.blogfilmes.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByGeneroContainingIgnoreCase(String genero);

}
