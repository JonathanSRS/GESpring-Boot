package br.org.generation.Farmacia.controle;

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

import br.org.generation.Farmacia.modelo.AtributosFarmacia;
import br.org.generation.Farmacia.repositorio.Metodos;

@RestController
@RequestMapping("/farmsenju")
@CrossOrigin("*")
public class CRUD {
	@Autowired
	private Metodos reposit;
	
	@GetMapping
	public ResponseEntity<List<AtributosFarmacia>> BuscarTudo(){
		return ResponseEntity.ok(reposit.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtributosFarmacia> BuscarId(@PathVariable long id){
		return reposit.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
						.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<AtributosFarmacia>> Buscarnome(@PathVariable String nome){
		return ResponseEntity.ok(reposit.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<AtributosFarmacia> Cadastrar(@RequestBody AtributosFarmacia post){
		return ResponseEntity.status(HttpStatus.OK).body(reposit.save(post));
	}
	
	@PutMapping
	public ResponseEntity<AtributosFarmacia> atualizar(@RequestBody AtributosFarmacia put){
		return ResponseEntity.status(HttpStatus.OK).body(reposit.save(put));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		reposit.deleteById(id);
	}
}
