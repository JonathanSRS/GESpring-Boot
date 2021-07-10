package br.org.generation.blogfilmes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.org.generation.blogfilmes.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTeste {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	
	private Usuario usuarioAtualize;
	
	

	@BeforeAll
	public void start() {
		//usuario = new Usuario(2L, "Administrador", "admin@email.com.br", "admin123");
		usuario = new Usuario(0L, "Pedritta Flintstone", "pedritta@bedrock.com", "65897100");
		usuarioAtualize = new Usuario(2L, "Pedritta Flintstone", "novoadmin@admin.com", "admin3456");
	}
	
	@Disabled
	@Test
	@DisplayName("✏")
	public void realizarPostUsuario() {
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	@DisplayName("📖")
	public void mostrarTodosUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("admin@admin.com", "admin123").exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	//@Disabled
	@Test
	@DisplayName("👨‍💻")
	public void realizarPutUsuario() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioAtualize);
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("admin@admin.com", "admin123").exchange("/usuarios/alterar", HttpMethod.PUT, request, Usuario.class);
		//testRestTemplate.withBasicAuth("admin@admin.com", "admin123").exchange("/usuarios/alterar", HttpMethod.PUT, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	@DisplayName("🗑")
	public void realizarDeleteUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.exchange("/usuarios/2", HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	

}
