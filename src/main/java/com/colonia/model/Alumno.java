package com.colonia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.colonia.util.EnumTypes.Sexo;
import com.colonia.util.EnumTypes.Socio;

@Entity
@Table(name = "ALUMNO")
@PrimaryKeyJoinColumn(name = "ALUMNO_ID")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALUMNO_ID")
	private int id;
	
	@Column (name = "NUMERO")
	private int numero;

	@NotEmpty(message="El nombre es obligatorio")
	@Column(name = "NOMBRE", length = 255)
	private String nombre;

	@NotEmpty(message="El apellido  es obligatorio")
	@Column(name = "APELLIDO", length = 255)
	private String apellido;
	
	@Column(name = "HERMANOS", length = 255)
	private boolean hermanos;

	@NotEmpty(message="El DNI es obligatorio")
	@Column(name = "DNI", length = 255)
	private String dni;

	@Column(name = "FECHA_NACIMIENTO")
	@DateTimeFormat(iso=ISO.DATE)
	private Date fechaNacimiento;

	@Column(name = "OBRA_SOCIAL", length = 255)
	private String obraSocial;
	
	@Column (name = "edad")
	private int edad;
	
	@Column(name = "NOMBRE_PAPA", length = 255)
	private String nombrePapa;
	
	@Column(name = "DNI_PAPA", length = 255)
	private String dniPapa;

	@Column(name = "TELEFONO_PAPA", length = 255)
	private String telefonoPapa;
	
	@Column(name = "MAIL_PAPA", length = 255)
	private String mailPapa;
	
	@NotEmpty(message="El nombre de la mama es obligatorio")
	@Column(name = "NOMBRE_MAMA", length = 255)
	private String nombreMama;
	
	@NotEmpty(message="El telefono de la Mama es obligatorio")
	@Column(name = "TELEFONO_MAMA", length = 255)
	private String telefonoMama;
	
	@Column(name = "MAIL_MAMA", length = 255)
	private String mailMama;
	
	@Column(name = "DNI_MAMA", length = 255)
	private String dniMama;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "GRUPO_ID")
	private Grupo grupo;
	
	@Column (name = "SEXO")
	@Enumerated (EnumType.STRING)
	private Sexo sexo;
	
	@Column (name = "ES_SOCIO")
	@Enumerated (EnumType.STRING)
	private Socio socio;
	
	@Column(name = "PAGOS")
	private String pagos;
	
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public boolean isHermanos() {
		return hermanos;
	}

	public String getDni() {
		return dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public String getNombrePapa() {
		return nombrePapa;
	}

	public String getDniPapa() {
		return dniPapa;
	}

	public String getTelefonoPapa() {
		return telefonoPapa;
	}

	public String getMailPapa() {
		return mailPapa;
	}

	public String getNombreMama() {
		return nombreMama;
	}

	public String getTelefonoMama() {
		return telefonoMama;
	}
 

	public String getDniMama() {
		return dniMama;
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

	public void setHermanos(boolean hermanos) {
		this.hermanos = hermanos;
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

	public void setNombrePapa(String nombrePapa) {
		this.nombrePapa = nombrePapa;
	}

	public void setDniPapa(String dniPapa) {
		this.dniPapa = dniPapa;
	}

	public void setTelefonoPapa(String telefonoPapa) {
		this.telefonoPapa = telefonoPapa;
	}

	public void setMailPapa(String mailPapa) {
		this.mailPapa = mailPapa;
	}

	public void setNombreMama(String nombreMama) {
		this.nombreMama = nombreMama;
	}

	public void setTelefonoMama(String telefonoMama) {
		this.telefonoMama = telefonoMama;
	}
 

	public void setDniMama(String dniMama) {
		this.dniMama = dniMama;
	}

	public String getMailMama() {
		return mailMama;
	}

	public void setMailMama(String mailMama) {
		this.mailMama = mailMama;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getPagos() {
		return pagos;
	}

	public void setPagos(String pagos) {
		this.pagos = pagos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
