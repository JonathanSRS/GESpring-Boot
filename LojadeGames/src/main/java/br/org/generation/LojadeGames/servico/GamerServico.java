package br.org.generation.LojadeGames.servico;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.org.generation.LojadeGames.model.Gamers;
import br.org.generation.LojadeGames.model.Login;
import br.org.generation.LojadeGames.repository.MetodosUsuario;

@Service
public class GamerServico {
	
	@Autowired
	private MetodosUsuario metodos;
	
	public Optional<Gamers> CadastrarGamers(Gamers gamers) {
		
		if(metodos.findByUsuario(gamers.getUsuario()).isPresent())
			return null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(gamers.getSenha());
		gamers.setSenha(senhaEncoder);
		return Optional.of(metodos.save(gamers));
	}
	
	public Optional<Gamers> atualizarGamers(Gamers gamers){
		if(metodos.findById(gamers.getId()).isPresent()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(gamers.getSenha());
			gamers.setSenha(senhaEncoder);
			
			return Optional.of(metodos.save(gamers));
			
		}else {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Usuário não encontrado!",null);
		}
	}
	
	public Optional<Login> Logar(Optional<Login> usuario){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Gamers> gamers = metodos.findByUsuario(usuario.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(usuario.get().getSenha(), gamers.get().getSenha())) {
			String auth = usuario.get().getUsuario() + ":" + usuario.get().getSenha();
			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String(encodedAuth);
			
			usuario.get().setToken(authHeader);
			usuario.get().setNome(gamers.get().getNome());
			return usuario;
			}
		}
	
	return null;
	}

}
