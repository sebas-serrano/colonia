package com.colonia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colonia.model.Alumno;
import com.colonia.model.Grupo;
import com.colonia.repo.IAlumnoRepo;
import com.colonia.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private IAlumnoRepo repo;
	
	public List<Alumno> findAll() {
		List<Alumno> lista = repo.findAll();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getGrupo()==null) {
				Grupo  grupo = new Grupo();
				grupo.setNombre("--");
				lista.get(i).setGrupo(grupo);
			}
		}
		return lista;
	}
	
	public Alumno saveAlumno(Alumno alumno) {
		return repo.save(alumno);
	}
	
	
	public Alumno findById(Integer id) {
		return repo.findById(id).get();
	}
			
}
