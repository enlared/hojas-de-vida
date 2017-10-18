package com.nova.MsHv.dto;

import com.nova.MsHv.entidad.RolUsuario;

public class RolUsuarioResponse {
	private Respuesta respuesta;
	private RolUsuario rolUsuario;
	public RolUsuario getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(RolUsuario rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
}
