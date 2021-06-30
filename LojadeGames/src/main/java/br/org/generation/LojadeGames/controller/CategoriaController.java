package br.org.generation.LojadeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.LojadeGames.model.Categoria;
import br.org.generation.LojadeGames.repository.RepositorioC;

@RestController
@RequestMapping("/cat")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private RepositorioC repo;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> BuscarId(long id){
		return repo.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> BuscarporGenero(@PathVariable String genero){
		return ResponseEntity.ok(repo.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> Cadastro(@RequestBody Categoria cadastro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(cadastro));
	}
	@PutMapping
	public ResponseEntity<Categoria> Atualizacao(@RequestBody Categoria cadastro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(cadastro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repo.deleteById(id);
	}

}
