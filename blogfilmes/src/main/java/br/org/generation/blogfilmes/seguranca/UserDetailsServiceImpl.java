package br.org.generation.blogfilmes.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.blogfilmes.model.Usuario;
import br.org.generation.blogfilmes.repository.MetodosUsuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private MetodosUsuario metodos;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = metodos.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));
		return user.map(UserDetailsImpl::new).get();
	}

}
