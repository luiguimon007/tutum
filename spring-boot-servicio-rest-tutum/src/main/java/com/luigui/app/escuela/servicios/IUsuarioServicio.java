package com.luigui.app.escuela.servicios;

import com.luigui.app.escuela.dto.UsuarioDTO;


public interface IUsuarioServicio {
	
	public UsuarioDTO crearAlumno(UsuarioDTO alumno);
	public UsuarioDTO obtenerAlumnoPorId(Long id);
	public void eliminarAlumno(Long id);
	
}
