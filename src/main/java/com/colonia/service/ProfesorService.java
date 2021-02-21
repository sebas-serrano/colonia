package com.colonia.service;

import java.util.List;
import java.util.Optional;

import com.colonia.model.Profesor;


public interface ProfesorService {
	
	public List<Profesor> findAll();
	
	public Profesor saveProfesor(Profesor profesor);
	
	public  Optional<Profesor> findById(Integer id);
	

}
