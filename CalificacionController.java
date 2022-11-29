package com.luigui.app.escuela.controladores;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.luigui.app.escuela.dto.CalificacionDTO;
import com.luigui.app.escuela.dto.RespuestaGenerico;
import com.luigui.app.escuela.dto.RespuestaPersonalizada;
import com.luigui.app.escuela.entidades.Calificacion;
import com.luigui.app.escuela.excepciones.ResourceNotFoundException;
import com.luigui.app.escuela.servicios.impl.CalificacionServicioImpl;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {
	
	@Autowired
	private CalificacionServicioImpl servicioCalificacion;
	
	/**
	 * Método para dar de alta nuevas calificaciones
	 * @param nuevaCalificacion
	 * @return
	 */
	@PostMapping("/crear")
	public ResponseEntity<RespuestaGenerico> darAltaCalificacion(@Valid @RequestBody CalificacionDTO calificacion){
		RespuestaGenerico respuesta = new RespuestaGenerico();
	    try {
	    	servicioCalificacion.crearCalificacion(calificacion);
	    	respuesta.setMsg("Calificacion registrada");
	    	respuesta.setSucess(HttpStatus.CREATED);
	 		return  new ResponseEntity<>(respuesta,respuesta.getSucess());
	    }catch(ResourceNotFoundException e) {
	    	respuesta.setMsg("Calificacion no registrada");	
	    	return new ResponseEntity<>(respuesta,HttpStatus.BAD_REQUEST);
	    	
	    }
	    
	}
	
	/**
	 * 
	 * @param idAlumno
	 * @return
	 */
	@GetMapping("/lista/{id}")
	public ResponseEntity<List<Calificacion>>obtenerCalificaciones(@PathVariable("id")Long idAlumno){
		
		return new ResponseEntity<>(servicioCalificacion.findAllByAlumno(idAlumno),HttpStatus.OK);	
	}
	@GetMapping("/listar/{id}")
	public ResponseEntity<List<RespuestaPersonalizada>>obtenerCalificacion(@PathVariable("id")Long idAlumno){
		
		return new ResponseEntity<>(servicioCalificacion.obtenerCalificacion(idAlumno),HttpStatus.OK);	
	
	}
	/**
	 * Método para Actualizar calificacion
	 * @param id
	 * @param calificacion
	 * @return
	 * @throws ParseException 
	 */
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<RespuestaGenerico> actualizarCalificacion(@PathVariable("id")Long id,@RequestBody CalificacionDTO calificacion) throws ParseException{
		RespuestaGenerico respuesta = new RespuestaGenerico();
		try {
			servicioCalificacion.actualizarCalificacion(calificacion, id);
			respuesta.setMsg("Calificacion actualizada");
			respuesta.setSucess(HttpStatus.OK);
			return new ResponseEntity<>(respuesta,respuesta.getSucess());
		}catch(ResourceNotFoundException e) {
	    	respuesta.setMsg("Calificacion no actualizada");	
	    	respuesta.setSucess(HttpStatus.BAD_REQUEST);
	    	return new ResponseEntity<>(respuesta,respuesta.getSucess());
		}
		
	}
	
	/**
	 * Método para eliminar calificaciones
	 * @param id
	 * @return
	 */
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<RespuestaGenerico> eliminarCalificacion(@PathVariable("id")Long id){
		RespuestaGenerico respuesta = new RespuestaGenerico();
		servicioCalificacion.eliminarCalificacion(id);
		
		respuesta.setMsg("Calificacion eliminada");
		respuesta.setSucess(HttpStatus.OK);
		return new ResponseEntity<>(respuesta,respuesta.getSucess());
	}
}
