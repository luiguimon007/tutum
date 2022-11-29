package com.luigui.app.escuela.dto;

import java.util.Date;

public class RespuestaPersonalizada {
	
	private Long id_t_usuario;
	private String nombre;
	private String apellido;
	private String materia;
	private Date fecha_registro;
	private Double promedio;
	
	public Long getId_t_usuario() {
		return id_t_usuario;
	}
	public void setId_t_usuario(Long id_t_usuario) {
		this.id_t_usuario = id_t_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public RespuestaPersonalizada() {
		// TODO Auto-generated constructor stub
	}
}
