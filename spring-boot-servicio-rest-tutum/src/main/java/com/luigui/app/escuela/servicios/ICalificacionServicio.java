package com.luigui.app.escuela.servicios;

import java.text.ParseException;
import java.util.List;

import com.luigui.app.escuela.dto.CalificacionDTO;
import com.luigui.app.escuela.entidades.Calificacion;

public interface ICalificacionServicio {

	public CalificacionDTO crearCalificacion(CalificacionDTO calificacion);
	public void eliminarCalificacion(Long id);
	public List<Calificacion> findAllByAlumno(Long id);
	public CalificacionDTO actualizarCalificacion(CalificacionDTO calificacion,Long id) throws ParseException;
	public CalificacionDTO obtenerCalificacionPorId(Long id);
}
