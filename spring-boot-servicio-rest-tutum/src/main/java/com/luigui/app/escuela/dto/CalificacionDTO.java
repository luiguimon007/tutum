package com.luigui.app.escuela.dto;


import java.util.Date;

import javax.validation.constraints.NotNull;




public class CalificacionDTO{

	@NotNull
	private Long materiasId;
	@NotNull
	private Long alumnosId;
	@NotNull
	private Double calificacionMateria;
	private Date fechaRegistro;
	
	


	public Long getMateriasId() {
		return materiasId;
	}

	public void setMateriasId(Long materiasId) {
		this.materiasId = materiasId;
	}

	
	public Double getCalificacionMateria() {
		return calificacionMateria;
	}

	public void setCalificacionMateria(Double calificacionMateria) {
		this.calificacionMateria = calificacionMateria;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public CalificacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getAlumnosId() {
		return alumnosId;
	}

	public void setAlumnosId(Long alumnosId) {
		this.alumnosId = alumnosId;
	}

	
	
	
}
