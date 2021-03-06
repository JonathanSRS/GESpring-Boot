package br.org.generation.blogfilmes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogfilmes.model.Usuario;


@Repository
public interface MetodosUsuario extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String usuario);
	//public Usuario findByUsuarioEmail(String usuario);
	public Usuario findFirstByNome(String nome);
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
