package com.luigui.app.escuela.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Table(name = "t_alumnos")
@Entity
public class Usuario {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_t_usuarios",unique = true,updatable = false,nullable = false)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ap_paterno")
	private String apellidoPaterno;
	
	@Column(name="ap_materno")
	private String apellidoMaterno;
	
	@Column(name = "activo")
	private Integer activo;

	@JsonBackReference
	@OneToMany(mappedBy = "alumnoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Calificacion> calificaciones = new ArrayList<>();
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.activo = activo;
	}

	
	
}
