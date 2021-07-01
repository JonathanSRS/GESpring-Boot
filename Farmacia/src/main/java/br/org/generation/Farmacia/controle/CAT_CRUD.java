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

import br.org.generation.Farmacia.modelo.Categoria;
import br.org.generation.Farmacia.repositorio.MetodosCat;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CAT_CRUD {
	
	@Autowired
	private MetodosCat repositorio;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> Buscartodo(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Categoria> BuscarId(@PathVariable long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> buscarcategoria(@PathVariable String Categoria){
		return ResponseEntity.ok(repositorio.findAllByCategoriaContainingIgnoreCase(Categoria));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria name){
	    return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(name));
	}
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria name){
	    return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(name));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repositorio.deleteById(id);
	}

}
