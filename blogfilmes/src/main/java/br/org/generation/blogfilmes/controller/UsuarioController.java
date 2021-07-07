package br.org.generation.blogfilmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogfilmes.model.Login;
import br.org.generation.blogfilmes.model.Usuario;
import br.org.generation.blogfilmes.repository.MetodosUsuario;
import br.org.generation.blogfilmes.servico.UsuarioServico;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private MetodosUsuario metodos;
	
	@Autowired
	private UsuarioServico servico;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(metodos.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id){
		return metodos.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());				
	}
	
	@PostMapping("/logar")
	public ResponseEntity<Login> Autentication(@RequestBody Optional<Login> usuario){
		return servico.Logar(usuario).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
		return  ResponseEntity.status(HttpStatus.CREATED)
				.body(servico.CadastrarUsuario(usuario));
	}
	
	
}
