package com.colonia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "PROFESOR")
@PrimaryKeyJoinColumn(name = "PROFESOR_ID")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFESOR_ID")
	private int id;

	@NotEmpty(message = "El nombre es obligatorio")
	@Column(name = "NOMBRE", length = 255)
	private String nombre;

	@NotEmpty(message = "El apellido  es obligatorio")
	@Column(name = "APELLIDO", length = 255)
	private String apellido;

	@NotEmpty(message = "El DNI es obligatorio")
	@Column(name = "DNI", length = 255)
	private String dni;

	@Column(name = "FECHA_NACIMIENTO")
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;

	@Column(name = "OBRA_SOCIAL", length = 255)
	private String obraSocial;

	@NotEmpty(message = "El telefono es obligatorio")
	@Column(name = "TELEFONO", length = 255)
	private String telefono;

	@Column(name = "PROFESOR", length = 255)
	private boolean esProfe;

	private String esProfesor;

	private String idBuscado;

	@OneToOne
	private Grupo grupo;

	@Column(name = "CARGO", length = 255)
	private String cargo;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public String getTelefono() {
		return telefono;
	}

	public boolean isEsProfe() {
		return esProfe;
	}

	public String getCargo() {
		return cargo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEsProfe(boolean esProfe) {
		this.esProfe = esProfe;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEsProfesor() {
		return esProfesor;
	}

	public void setEsProfesor(String esProfesor) {
		this.esProfesor = esProfesor;
	}

	public String getIdBuscado() {
		return idBuscado;
	}

	public void setIdBuscado(String idBuscado) {
		this.idBuscado = idBuscado;
	}

}
