package com.everis.fallas.operacionales.tools.bean;

import java.util.List;

public class Response {
	
	private String codigoError;
	private String mensajeError;
	private List<App> datos;

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public List<App> getDatos() {
		return datos;
	}

	public void setDatos(List<App> datos) {
		this.datos = datos;
	}
}
