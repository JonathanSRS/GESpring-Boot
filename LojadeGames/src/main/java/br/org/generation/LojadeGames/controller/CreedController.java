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

import br.org.generation.LojadeGames.model.ACreed;
import br.org.generation.LojadeGames.repository.Metodosadd;

@RestController
@RequestMapping("/Creed")
@CrossOrigin("*")
public class CreedController {
	@Autowired
	private Metodosadd ac;
	
	@GetMapping
	public ResponseEntity<List<ACreed>> GetAll(){
		return ResponseEntity.ok(ac.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ACreed>GetById(long id){
		return ac.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeG/{nomeG}")
	public ResponseEntity<List<ACreed>> GetByNomeG(String nomeG){
		return ResponseEntity.ok(ac.findAllByNomeGContainingIgnoreCase(nomeG));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<ACreed>> GetByIdd(long id){
		return ResponseEntity.ok(ac.findAllByIdContainingIgnoreCase(id));
	}
	
	@PostMapping
	public ResponseEntity<ACreed> cadastrar(@RequestBody ACreed post){
		return ResponseEntity.status(HttpStatus.OK).body(ac.save(post));
	}
	
	@PutMapping
	public ResponseEntity<ACreed> atualizar(@RequestBody ACreed put){
		return ResponseEntity.status(HttpStatus.OK).body(ac.save(put));
	}
	
	@DeleteMapping("/{id}")
	public void apagardados(@PathVariable long id) {
		ac.deleteById(id);
	}
	
}
