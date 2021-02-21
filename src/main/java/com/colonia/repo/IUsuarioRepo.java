package com.colonia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colonia.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);

}
