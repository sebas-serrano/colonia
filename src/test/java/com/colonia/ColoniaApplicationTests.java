package com.colonia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.colonia.model.Usuario;
import com.colonia.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColoniaApplicationTests {
	
	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void contextLoads() {
		Usuario usuario= new Usuario();
		usuario.setPassword(encoder.encode("admin"));
		usuario.setId(1);
		usuario.setNombre("colonia");
		repo.save(usuario);
	}

}
