package br.org.generation.blogfilmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogfilmes.model.Postagemf;

@Repository
public interface PostagemRepository extends JpaRepository<Postagemf, Long> {
	public List<Postagemf> findAllByFilmeContainingIgnoreCase(String filme);
}
