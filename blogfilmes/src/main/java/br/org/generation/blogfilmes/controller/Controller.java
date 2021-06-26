package br.org.generation.blogfilmes.controller;

import java.util.List;
import java.util.Optional;

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

import br.org.generation.blogfilmes.model.Postagemf;
import br.org.generation.blogfilmes.repository.PostagemRepository;



@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class Controller {
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagemf>> GetALL(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//variavel de caminho
	@GetMapping("ifelse/{id}")
	public ResponseEntity<Postagemf> GetByIdIfElse(@PathVariable long id){
		Optional<Postagemf> ob = repository.findById(id);
		if(ob.isPresent()) {
			return ResponseEntity.ok(ob.get());
		}
		return ResponseEntity.notFound().build();
	}
	@GetMapping("/filme/{filme}")
	public ResponseEntity<List<Postagemf>> GetByFilme(@PathVariable String filme){
		return ResponseEntity.ok(repository.findAllByFilmeContainingIgnoreCase(filme));
	}
	
	@PostMapping
	public ResponseEntity<Postagemf> post (@RequestBody Postagemf post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	// Editar uma postagem
	@PutMapping
	public ResponseEntity<Postagemf> put(@RequestBody Postagemf post){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));
	}
	
	//Deletar uma Postagem
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		repository.deleteById(id);
	}
}
