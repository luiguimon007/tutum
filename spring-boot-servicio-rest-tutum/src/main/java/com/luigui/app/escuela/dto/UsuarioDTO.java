package com.luigui.app.escuela.dto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.luigui.app.escuela.entidades.Calificacion;

public class UsuarioDTO {
	
	@NotNull
	private Long id;
	
	private String nombre;
	
	
	private String apellidoPaterno;
	
	
	private String apellidoMaterno;
	
	
	private Integer activo;
	
	private List<Calificacion> calificaciones = new ArrayList<>();

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

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public UsuarioDTO() {
		super();
	}
}
