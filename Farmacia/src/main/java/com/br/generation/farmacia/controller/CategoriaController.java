package com.br.generation.farmacia.controller;


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

import com.br.generation.farmacia.model.Categoria;
import com.br.generation.farmacia.repository.CategoriaRepositorio;
    
    @RestController
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/categoria")
    public class CategoriaController {
    
        @Autowired
        private CategoriaRepositorio Repositorio;
    
        @GetMapping
        public ResponseEntity<List<Categoria>> getAll() {
            return ResponseEntity.ok(Repositorio.findAll());
    
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<Categoria> getById(@PathVariable long id) {
            return Repositorio.findById(id).map(resp -> ResponseEntity.ok(resp))
                    .orElse(ResponseEntity.notFound().build());
    
        }
    
        @GetMapping("/descricao/{descricao}")
        public ResponseEntity<List<Categoria>> getByName(@PathVariable String desc) {
            return ResponseEntity.ok(Repositorio.findAllByDescricaoContainingIgnoreCase(desc));
    
        }
    
        @PostMapping
        public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Repositorio.save(categoria));
    
        }
    
        @PutMapping
        public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
            return ResponseEntity.status(HttpStatus.OK).body(Repositorio.save(categoria));
        }
    
        @DeleteMapping("/{id}")
        public void delete(@PathVariable long id) {
            Repositorio.deleteById(id);
    
        }  
}
