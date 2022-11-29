package com.luigui.app.escuela.entidades;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;





@Table(name = "t_calificaciones")
@Entity

public class Calificacion{
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_t_calificaciones",unique = true,updatable = false,nullable = false)
	private Long id;
	
    @OneToOne
	@JoinColumn(name = "id_t_materias",nullable = false)
	private Materia materiaId;
	
    
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name="id_t_usuarios",nullable = false)
	private Usuario alumnoId;
	
	@Column(precision = 10,scale = 2,name = "calificacion") 
	private Double calificacion;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "fecha_registro")
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materia getMateriasId() {
		return materiaId;
	}

	public void setMateriasId(Materia materiasId) {
		this.materiaId = materiasId;
	}

	public Usuario getAlumnosId() {
		return alumnoId;
	}

	public void setAlumnosId(Usuario alumnosId) {
		this.alumnoId = alumnosId;
	}

	

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Calificacion() {
		
	}

	public Calificacion(Long id, @NotNull Materia materiaId, @NotNull Usuario alumnoId, Double calificacion,
			Date fecha) {
		super();
		this.id = id;
		this.materiaId = materiaId;
		this.alumnoId = alumnoId;
		this.calificacion = calificacion;
		this.fecha = fecha;
	}
	
}
