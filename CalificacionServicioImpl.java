package com.luigui.app.escuela.servicios.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luigui.app.escuela.constantes.EscuelaConstantes;
import com.luigui.app.escuela.dto.CalificacionDTO;
import com.luigui.app.escuela.dto.RespuestaPersonalizada;
import com.luigui.app.escuela.entidades.Calificacion;
import com.luigui.app.escuela.excepciones.ResourceNotFoundException;
import com.luigui.app.escuela.repositorios.ICalificacionRepositorio;
import com.luigui.app.escuela.servicios.ICalificacionServicio;

@Service
public class CalificacionServicioImpl implements ICalificacionServicio{
	@Autowired
	private ICalificacionRepositorio repositorioCalificacion;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	
	@Override
	@Transactional
	public CalificacionDTO crearCalificacion(CalificacionDTO calificacionDTO) {
		Calificacion calificacion = mapearEntidad(calificacionDTO);
		Calificacion nuevaCalificacion = repositorioCalificacion.save(calificacion);
		
		return mapearDTO(nuevaCalificacion);
	}

	@Override
	public List<Calificacion> findAllByAlumno(Long id) {
		
		return repositorioCalificacion.findAllByAlumnoId(id);
	}

	@Override
	public void eliminarCalificacion(Long id) {
		Calificacion calificacion = repositorioCalificacion.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(EscuelaConstantes.CALIFICACION, "id", id));
		repositorioCalificacion.delete(calificacion);
		
	}

	@Override
	public CalificacionDTO actualizarCalificacion(CalificacionDTO calificacionDTO, Long id) throws ParseException {
		Calificacion calificacion = repositorioCalificacion.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(EscuelaConstantes.CALIFICACION, "id", id));
		String fechaS = df.format(calificacionDTO.getFechaRegistro()); 
		Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaS);
		calificacion.setCalificacion(calificacionDTO.getCalificacionMateria());
		calificacion.setFecha(fecha);
		Calificacion nuevaCalificacion = repositorioCalificacion.save(calificacion);
		
		return mapearDTO(nuevaCalificacion);
	}

	@Override
	public CalificacionDTO obtenerCalificacionPorId(Long id) {
		Calificacion calificacion = repositorioCalificacion.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(EscuelaConstantes.CALIFICACION, "id", id));
		
		return mapearDTO(calificacion);
	}
	
	private CalificacionDTO mapearDTO(Calificacion calificacion) {
		return modelMapper.map(calificacion, CalificacionDTO.class);
	}
	
	private Calificacion mapearEntidad(CalificacionDTO calificacionDTO) {
		return modelMapper.map(calificacionDTO, Calificacion.class);
	}

	@Override
	public List<RespuestaPersonalizada> obtenerCalificacion(Long id) {
		List<RespuestaPersonalizada> listaRespuesta = new ArrayList<>();
		RespuestaPersonalizada respuesta = new RespuestaPersonalizada();
		List<Calificacion> calificaciones = repositorioCalificacion.findAllByAlumnoId(id);
		Double promedio=0.0;
		for(int i= 0;i<calificaciones.size();i++){
			respuesta.setId_t_usuario(calificaciones.get(i).getAlumnosId().getId());
			respuesta.setNombre(calificaciones.get(i).getAlumnosId().getNombre());
			respuesta.setApellido(calificaciones.get(i).getAlumnosId().getApellidoPaterno());
			respuesta.setMateria(calificaciones.get(i).getMateriasId().getNombre());
			respuesta.setCalificacion(calificaciones.get(i).getCalificacion());
			respuesta.setFecha_registro(calificaciones.get(i).getFecha());
			promedio += (respuesta.getCalificacion()/calificaciones.size());
			respuesta.setPromedio(promedio);
			listaRespuesta.add(respuesta);
		}
		
		return listaRespuesta;
	}

}
