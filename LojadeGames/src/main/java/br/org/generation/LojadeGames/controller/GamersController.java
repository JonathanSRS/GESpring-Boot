package br.org.generation.LojadeGames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.LojadeGames.model.Gamers;
import br.org.generation.LojadeGames.model.Login;
import br.org.generation.LojadeGames.repository.MetodosUsuario;
import br.org.generation.LojadeGames.servico.GamerServico;


@RestController
@RequestMapping("/gamers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GamersController {
	
	@Autowired
	private GamerServico servico;
	
	@Autowired
	private MetodosUsuario metodos;
	
	@GetMapping("/all")
	public ResponseEntity<List<Gamers>> getAll() {
		return ResponseEntity.ok(metodos.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Gamers> getById(@PathVariable long id){
		return metodos.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());				
	}
	
	
	@PostMapping("/logar")
	public ResponseEntity<Login> Autentication(@RequestBody Optional<Login> usuario){
		return servico.Logar(usuario).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Gamers>> post(@RequestBody Gamers gam){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(servico.CadastrarGamers(gam));
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Gamers> putUsuario(@RequestBody Gamers gam){
		Optional<Gamers> updateGamers = servico.atualizarGamers(gam);
		try {
			return ResponseEntity.ok(updateGamers.get());
		} catch (Exception exececao) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
