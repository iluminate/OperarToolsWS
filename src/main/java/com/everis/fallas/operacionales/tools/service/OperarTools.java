package com.everis.fallas.operacionales.tools.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.everis.fallas.operacionales.tools.bean.App;
import com.everis.fallas.operacionales.tools.bean.Response;
import com.everis.fallas.operacionales.tools.dao.FallasDBImpl;

@Path("/tool")
public class OperarTools {
	@GET
	@Path("/getlistapp")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces({MediaType.APPLICATION_JSON})
	public Response obtenerInfo(@QueryParam("servicename") String servicio){
		Response response = new Response();
		
		FallasDBImpl fallasDB = new FallasDBImpl();
		List<App> datos = fallasDB.obtenerApp(servicio);
		
		response.setCodigoError("0");
		response.setMensajeError("Proceso exitoso");
		response.setDatos(datos);
		return response;
	}
}
