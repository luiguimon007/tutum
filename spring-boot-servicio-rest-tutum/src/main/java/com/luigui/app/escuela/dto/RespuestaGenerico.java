package com.luigui.app.escuela.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;


public class RespuestaGenerico  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus sucess;
	private String msg;
	
	
	public HttpStatus getSucess() {
		return sucess;
	}
	public void setSucess(HttpStatus sucess) {
		this.sucess = sucess;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
