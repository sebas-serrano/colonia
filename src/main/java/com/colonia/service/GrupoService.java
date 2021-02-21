package com.colonia.service;

import java.util.List;

import com.colonia.model.Grupo;


public interface GrupoService {
	
	public List<Grupo> findAll();
	
	public Grupo saveGrupo(Grupo grupo);
	
	public Grupo findById(Integer id);

}
