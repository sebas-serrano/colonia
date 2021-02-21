package com.colonia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colonia.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, Integer>{

}
