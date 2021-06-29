package br.org.generation.blogfilmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.org.generation.blogfilmes.model.Tema;
import br.org.generation.blogfilmes.repository.TemaRepository;


@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository repositorio;
	
	//Get
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("idTryCatch/{id}")
	public ResponseEntity<Tema> GetByIdTryCatch(@PathVariable long id){
		Optional<Tema> tema = repositorio.findById(id);
		try {
			return ResponseEntity.ok(tema.get());
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Tema>> GetByGenero(@PathVariable String genero){
		return ResponseEntity.ok(repositorio.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	//Post
	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema tema){
		return ResponseEntity.ok(repositorio.save(tema));
	}
	//Put
	@PutMapping
	public ResponseEntity<Tema> put(@RequestBody Tema tema){
		return ResponseEntity.ok(repositorio.save(tema));
	}
	//Delete
	@DeleteMapping("/{id}")
	public void deletetema(@PathVariable long id){
		repositorio.deleteById(id);
	}

}
