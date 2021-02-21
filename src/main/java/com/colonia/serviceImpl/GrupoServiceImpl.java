package com.colonia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colonia.model.Grupo;
import com.colonia.repo.IGrupoRepo;
import com.colonia.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{
	
	@Autowired
	private IGrupoRepo repo;
	
	public List<Grupo> findAll() {
		return repo.findAll();
	}
	
	public Grupo saveGrupo(Grupo grupo) {
		return repo.save(grupo);
	}
	
	public Grupo findById(Integer id) {
		return repo.findById(id).get();
	}
			
}