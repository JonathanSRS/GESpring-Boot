package br.org.generation.blogfilmes.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogfilmes.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositorioTeste {
	
	@Autowired
	private MetodosUsuario metodos;
	
	@BeforeAll
	void start() {
		Usuario teste1 = new Usuario(0L, "Fred Flintstone", "fred@bedrock.com", "12548920");
		if(metodos.findFirstByNome(teste1.getUsuario()) == null)
			metodos.save(teste1);
		
		/*teste1 = new Usuario(0L, "Betty Rubble", "betty@bedrock.com", "65897100");
		if(metodos.findByUsuarioEmail(teste1.getUsuario()) == null)
			metodos.save(teste1);		
		
		teste1 = new Usuario(0L, "Gazoo", "gazoo@marte.com", "65897100");
		if(metodos.findByUsuarioEmail(teste1.getUsuario()) == null)
			metodos.save(teste1);
		
		teste1 = new Usuario(0L, "MrSlate", "slate@bedrock.com", "65897100");
		if(metodos.findByUsuarioEmail(teste1.getUsuario()) == null)
			metodos.save(teste1);*/
		
		teste1 = new Usuario(0L, "MrSlate", "slate@bedrock.com", "65897100");
		if(metodos.findFirstByNome(teste1.getNome()) == null)
			metodos.save(teste1);
		
		
		teste1 = new Usuario(0L, "Wilma Flintstone", "wilma@bedrock.com", "65897100");
		if(metodos.findFirstByNome(teste1.getNome()) == null)
			metodos.save(teste1);
		
		teste1 = new Usuario(0L, "Pedritta Flintstone", "pedritta@bedrock.com", "65897100");
		if(metodos.findFirstByNome(teste1.getNome()) == null)
			metodos.save(teste1);
	}
	
	/*@Test
	public void findByUsuarioRetornaUsuario() throws Exception {
		Usuario teste1 = metodos.findByUsuarioEmail("slate@bedrock.com");
		assertTrue(teste1.getUsuario().equals("slate@bedrock.com"));
	}*/
	
	@Test
	public void findFirstNomeRetornaNome() throws Exception {
		Usuario teste1 = metodos.findFirstByNome("MrSlate");
		assertTrue(teste1.getNome().equals("MrSlate"));
	}
	
	@Test
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {
		List<Usuario> listaDeUsuarios = metodos.findAllByNomeContainingIgnoreCase("Flintstone");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	@AfterAll
	public void end() {
		metodos.deleteAll();
	}

}
