package br.org.generation.blogfilmes.model;

//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public Usuario testeusuario;
	//objeto vazio
	//public Usuario casoErro = new Usuario();
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory()
	.getValidator();
	
	@BeforeEach
	public void start() {
		testeusuario = new Usuario(0L, "teste", "teste@gamil.com", "adminadmin");
	}
	
	@Test
	@DisplayName("👌 Valida Atributos Não Nulos")
	void testValidaAtributos() {
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(testeusuario);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
	}

}
