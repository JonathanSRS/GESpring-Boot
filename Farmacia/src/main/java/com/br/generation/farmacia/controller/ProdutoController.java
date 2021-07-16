package com.br.generation.farmacia.controller;




import java.util.List;

import  org.springframework.beans.factory.annotation.Autowired ;
import  org.springframework.http.HttpStatus ;
import  org.springframework.http.ResponseEntity ;
import  org.springframework.web.bind.annotation.CrossOrigin ;
import  org.springframework.web.bind.annotation.DeleteMapping ;
import  org.springframework.web.bind.annotation.GetMapping ;
import  org.springframework.web.bind.annotation.PathVariable ;
import  org.springframework.web.bind.annotation.PostMapping ;
import  org.springframework.web.bind.annotation.PutMapping ;
import  org.springframework.web.bind.annotation.RequestBody ;
import  org.springframework.web.bind.annotation.RequestMapping ;
import  org.springframework.web.bind.annotation.RestController ;

import com.br.generation.farmacia.model.Produtos;
import com.br.generation.farmacia.repository.ProdutosRepositorio;

@RestController
@CrossOrigin (origins  =  "*", allowedHeaders  =  "*")
@RequestMapping ("/produtos")
public  class  ProdutoController {

	@Autowired
	private  ProdutosRepositorio produtosRepositorio;

	@GetMapping
	public  ResponseEntity<List<Produtos>>getAll() {
		return  ResponseEntity.ok (produtosRepositorio.findAll ());

	}

	@GetMapping ("/{id}")
	public  ResponseEntity<Produtos>getById ( @PathVariable  long  id ) {
		return produtosRepositorio.findById(id).map(resp-> ResponseEntity.ok(resp))
				.orElse ( ResponseEntity.notFound().build());

	}

	@GetMapping ("/nome/{nome}")
	public  ResponseEntity <List<Produtos>>getByName(@PathVariable  String  nome ) {
		return  ResponseEntity.ok(produtosRepositorio.findAllByNomeContainingIgnoreCase (nome));

	}

	@PostMapping
	public  ResponseEntity <Produtos>  post (@RequestBody  Produtos  produto){
		return  ResponseEntity.status( HttpStatus.CREATED ).body(produtosRepositorio.save(produto));

	}

	@PutMapping
	public  ResponseEntity <Produtos>  put (@RequestBody  Produtos  produto) {
		return  ResponseEntity.status(HttpStatus.OK).body(produtosRepositorio.save(produto));
	}

	@DeleteMapping ("/{id}")
	public  void  delete ( @PathVariable  long  id ) {
		produtosRepositorio.deleteById(id);

	}
}

