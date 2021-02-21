package com.colonia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colonia.model.Profesor;

public interface IProfesorRepo extends JpaRepository<Profesor, Integer>{

}