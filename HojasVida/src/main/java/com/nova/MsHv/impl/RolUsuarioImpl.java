package com.nova.MsHv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.RolUsuarioDAO;
import com.nova.MsHv.dto.Respuesta;
import com.nova.MsHv.dto.RolUsuarioResponse;
import com.nova.MsHv.entidad.RolUsuario;


@Service
public class RolUsuarioImpl {

	@Autowired private RolUsuarioDAO dao ;
	
	public Iterable<RolUsuario> consultarTodos(){
		return dao.findAll();
	}

	public RolUsuario save(RolUsuario data) {
		return dao.save(data);
	}

	public boolean remove(RolUsuario data) {
		remove(data);
		return true;
	}
	

	public RolUsuarioResponse consultaUser(RolUsuario data) {
		RolUsuarioResponse rolUsuarioResponse = new RolUsuarioResponse();
		Respuesta respuesta= new Respuesta();
		rolUsuarioResponse.setRolUsuario(dao.consultaUser(data.getRol().getId(), data.getUsuario().getNombreUsuario()));
		rolUsuarioResponse.setRespuesta(respuesta);
		respuesta.setEstado("OK");

		return rolUsuarioResponse;
	}
}
