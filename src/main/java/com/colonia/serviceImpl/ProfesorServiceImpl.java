package com.colonia.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colonia.model.Profesor;
import com.colonia.repo.IProfesorRepo;
import com.colonia.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	private IProfesorRepo repo;
	
	public List<Profesor> findAll() {
		return repo.findAll();
	}
	
	public Profesor saveProfesor(Profesor profesor) {
		return repo.save(profesor);
	}
	
	public  Optional<Profesor> findById(Integer id) {
		return repo.findById(id);
	}
			
}
