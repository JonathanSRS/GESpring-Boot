package br.org.generation.LojadeGames.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.LojadeGames.model.Gamers;
import br.org.generation.LojadeGames.repository.MetodosUsuario;

@Service
public class ImplementosServico implements UserDetailsService{
	
	@Autowired
	private MetodosUsuario metodos;
	
	@Override
	public UserDetails loadUserByUsername(String nomeusuario) throws UsernameNotFoundException {
		
		Optional<Gamers> gam = metodos.findByUsuario(nomeusuario);
		gam.orElseThrow(()-> new UsernameNotFoundException(nomeusuario + "not found."));
		
		return gam.map(UsuarioImplementos::new).get();
	}

}
