package com.luigui.app.escuela.servicios.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luigui.app.escuela.constantes.EscuelaConstantes;
import com.luigui.app.escuela.dto.UsuarioDTO;
import com.luigui.app.escuela.entidades.Usuario;
import com.luigui.app.escuela.excepciones.ResourceNotFoundException;
import com.luigui.app.escuela.repositorios.IUsuarioRepositorio;
import com.luigui.app.escuela.servicios.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUsuarioRepositorio alumnoRepositorio;
	
	
	@Override
	public UsuarioDTO crearAlumno(UsuarioDTO alumnoDTO) {
		Usuario alumno = mapearEntidad(alumnoDTO);
		Usuario nuevoAlumno = alumnoRepositorio.save(alumno);
		return mapearDTO(nuevoAlumno);
	}


	@Override
	public UsuarioDTO obtenerAlumnoPorId(Long id) {
		Usuario alumno = alumnoRepositorio.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException(EscuelaConstantes.ALUMNO, "id", id));
		return mapearDTO(alumno);
	}


	@Override
	public void eliminarAlumno(Long id) {
		Usuario alumno = alumnoRepositorio.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException(EscuelaConstantes.ALUMNO, "id", id));
		alumnoRepositorio.delete(alumno);
		
	}
	
	private UsuarioDTO mapearDTO(Usuario alumno) {
		return modelMapper.map(alumno, UsuarioDTO.class);
	}
	
	private Usuario mapearEntidad(UsuarioDTO alumnoDTO) {
		return modelMapper.map(alumnoDTO, Usuario.class);
	}
}
