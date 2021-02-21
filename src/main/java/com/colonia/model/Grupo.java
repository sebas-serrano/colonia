package com.colonia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "GRUPO")
@PrimaryKeyJoinColumn(name = "GRUPO_ID")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRUPO_ID")
	private int id;

	@NotEmpty(message="El nombre es obligatorio")
	@Column(name = "NOMBRE", length = 255)
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "PROFESOR_ID_AUX",  referencedColumnName = "PROFESOR_ID", updatable = false)
	private Profesor profesor;
	
	@OneToMany(mappedBy = "grupo")
	List<Alumno> listAlumnos;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Alumno> getListAlumnos() {
		return listAlumnos;
	}

	public void setListAlumnos(List<Alumno> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}
	
}