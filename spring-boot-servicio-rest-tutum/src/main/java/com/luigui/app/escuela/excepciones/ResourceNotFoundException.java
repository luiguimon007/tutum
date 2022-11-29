package com.luigui.app.escuela.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String nombreDelRecurso;
	private final String nombreDelCampo;
	private final Long valorDelCampo;
	
	
	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, Long valorDelCampo) {
		super();
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelCampo = valorDelCampo;
	}
	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}
	
	public String getNombreDelCampo() {
		return nombreDelCampo;
	}
	
	public Long getValorDelCampo() {
		return valorDelCampo;
	}
	

	
}
