package com.luigui.app.escuela.servicios;

import com.luigui.app.escuela.entidades.Materia;

public interface IMateriaServicio {

	public Materia save(Materia materia);
	public void delete(Long id);
	public Materia findById(Long id);
}
