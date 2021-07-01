package br.org.generation.Farmacia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.Farmacia.modelo.AtributosFarmacia;

public interface Metodos extends JpaRepository<AtributosFarmacia, Long>{
	public List<AtributosFarmacia> findAllByNomeContainingIgnoreCase(String nome);

}
