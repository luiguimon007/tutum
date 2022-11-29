package com.luigui.app.escuela.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.luigui.app.escuela.dto.CalificacionDTO;
import com.luigui.app.escuela.entidades.Calificacion;

@Repository
public interface ICalificacionRepositorio extends CrudRepository<Calificacion, Long> {

	@Query(value = "SELECT c FROM Calificacion c JOIN Usuario a On c.alumnoId= a.id WHERE a.id= ?1")
	public List<Calificacion> findAllByAlumnoId(@Param("id")Long alumnoId);
}
