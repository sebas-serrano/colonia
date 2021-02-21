package com.colonia.service;

import java.util.List;

import com.colonia.model.Alumno;


public interface AlumnoService {
	
	public List<Alumno> findAll();
	
	public Alumno saveAlumno(Alumno alumno);
	
	public Alumno findById(Integer id);

}
