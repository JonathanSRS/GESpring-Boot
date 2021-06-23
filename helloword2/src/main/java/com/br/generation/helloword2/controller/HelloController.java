package com.br.generation.helloword2.controller;
//Autor: Jonathan da Silva

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/Obj")
	public String Obj() {
		return "Dominar Spring conseguir fazer as implementações do banco de dados "
				+ "definir o nome do projeto integrador";
	}
	//http://localhost:8585/Obj
}
