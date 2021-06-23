package com.br.generation.helloword.controller;

//Autor: Jonathan da Silva
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@RequestMapping("/hab")
	public String hab() {
		return "Atenção ao detalhe\n Proatividade";
	}
	//http://localhost:8080/hab
}
